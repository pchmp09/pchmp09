package sugoroku;

import java.util.Scanner;

public class ExchangeCard extends GamePlay implements Useable{
	String name = "ポイント入れ替えカード";

	@Override
	public String toString() {
		return name;
	}

	public int use(Player player) {
		Scanner sc = new Scanner(System.in);
		int who;
		int use;

		//入れ替え対象選択用のループ処理
		do {
		System.out.println("誰とポイントを入れ替えますか？");

		for(int i = 0;i<players.size();i++) {
			System.out.println(players.get(i) + "[" + i + "]:" );
		}
		System.out.println("[ ]の数字を入力してください");
		who = sc.nextInt();

		System.out.println(players.get(who).getName() + "さんと入れ替えます。よろしいですか？");
		System.out.println("よろしい->1 , もう一回考え直す->0");
		use = sc.nextInt();

		}while(use == 0);

		player.exchangePoint(players.get(who));
		System.out.println("ポイントを入れ替えました");
		System.out.println(player);
		System.out.println(players.get(who));

		return -1;
	}
}
