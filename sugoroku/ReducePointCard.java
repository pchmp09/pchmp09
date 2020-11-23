package sugoroku;

import java.util.Random;
import java.util.Scanner;

public class ReducePointCard extends GamePlay implements Useable{
	String name = "ポイント減らしカード";

	@Override
	public String toString() {
		return name;
	}

	public int use(Player player) {
		Scanner sc = new Scanner(System.in);
		Random r = new Random();
		int who;
		int use;
		int point;

		//対象選択用のループ処理
		do {
			System.out.println("相手のポイントを1~10点減らすことができます");
			System.out.println("誰のポイントを減らしますか？");

			for(int i = 0;i<players.size();i++) {
				System.out.println(players.get(i) + "[" + i + "]:");
			}
			System.out.println("[ ]の数字を入力してください");
			who = sc.nextInt();

			System.out.println(players.get(who).getName() + "さんと入れ替えます。よろしいですか？");
			System.out.println("よろしい->1 , もう一回考え直す->0");
			use = sc.nextInt();

			}while(use == 0);

		 	point = r.nextInt(10);
			System.out.println((point + 1) + "点減らしました！");
			players.get(who).setPoint(-point - 1);
			System.out.println(players.get(who));

			return -1;

		}

}
