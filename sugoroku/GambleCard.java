package sugoroku;

import java.util.Random;
import java.util.Scanner;

public class GambleCard extends GamePlay implements Useable {
	String name = "ギャンブルカード";

	@Override
	public String toString() {
		return name;
	}

	public int use(Player player) {
		Scanner sc = new Scanner(System.in);
		Random r = new Random();

		System.out.println("2分の1の確率でポイントが10倍かマイナス10倍になります");
		System.out.println("本当に使用しますか？ 使う->1 , やっぱりやめる->0");
		int use = sc.nextInt();
		if (use == 0) {
			return -2;
		}
		int gamble = r.nextInt(2);
		int point;

		if (gamble == 0) {
			point = player.getPoint() * 10;
			player.setPoint(point);
			System.out.println("10倍です");
			System.out.println("現在 " + player.getPoint() + " 点");

			return -1;
		} else {
			point = player.getPoint() * -10;
			player.setPoint(point);
			System.out.println("マイナス10倍です");
			System.out.println("現在 " + player.getPoint() + " 点");

			return -1;
		}
	}
}
