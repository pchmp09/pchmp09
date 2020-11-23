package sugoroku;

import java.util.Random;

public class Event extends GamePlay {

	//イベントを発生させる処理
	static void event(Player player) {
		Random r = new Random();
		int event = r.nextInt(100);
		int num; 		//ランダム数値管理の変数. ポイント変動とマス移動で共用

		if (0 <= event && event < 25) {
			num = r.nextInt(5);
			System.out.println("ラッキーマス！ポイントが" + (num + 1) + "点増えた");
			player.setPoint(num + 1);

		} else if (25 <= event && event < 50) {
			num = r.nextInt(5);
			System.out.println("アンラッキーマス！ポイントが" + (num + 1) + "点減った");
			player.setPoint(-(num + 1));

		} else if (50 <= event && event < 90) {
			System.out.print("カードマス！");
			getCard(player);

		} else if (90 <= event && event < 95) {
			num = r.nextInt(6);
			System.out.println("進みマス！" + (num + 1) + "マス進みます");
			player.setMasu(num);
			if (player.getMasu() > GOAL) {
				System.out.println("ゴールを" + (player.getMasu() - GOAL) + "分オーバーしました");
				player.setMasu();
			}

		} else {
			num = r.nextInt(6);
			System.out.println("戻りマス！" + (num + 1) + "マス戻ります");
			player.setMasu(-num - 2);

			//現在地が0マスを下回ったら全部0にする
			if (player.getMasu() < 0) {
				player.clearMasu();
			}
		}
	}

	//カードイベントを踏んだときの処理
	static void getCard(Player player) {
		Random r = new Random();
		int num = r.nextInt(100);

		if (0 <= num && num < 10) {
			System.out.println("1進めるカードを手に入れた");
			Useable card = new MoveCard1();
			player.cards.add(card);
			
		} else if (10 <= num && num < 20) {
			System.out.println("2進めるカードを手に入れた");
			Useable card2 = new MoveCard2();
			player.cards.add(card2);
			
		} else if (20 <= num && num < 30) {
			System.out.println("3進めるカードを手に入れた");
			Useable card3 = new MoveCard3();
			player.cards.add(card3);
			
		} else if (30 <= num && num < 40) {
			System.out.println("4進めるカードを手に入れた");
			Useable card4 = new MoveCard4();
			player.cards.add(card4);
			
		} else if (40 <= num && num < 50) {
			System.out.println("5進めるカードを手に入れた");
			Useable card5 = new MoveCard5();
			player.cards.add(card5);
			
		} else if (50 <= num && num < 60) {
			System.out.println("6進めるカードを手に入れた");
			Useable card6 = new MoveCard6();
			player.cards.add(card6);
			
		} else if (60 <= num && num < 70) {
			System.out.println("ギャンブルカードを手に入れた");
			Useable card7 = new GambleCard();
			player.cards.add(card7);
			
		} else if (70 <= num && num < 80) {
			System.out.println("ポイントゲットカードを手に入れた");
			Useable card8 = new GetPointsCard();
			player.cards.add(card8);
			
		} else if (80 <= num && num < 90) {
			System.out.println("ポイント入れ替えカードを手に入れた");
			Useable card9 = new ExchangeCard();
			player.cards.add(card9);
			
		} else if (90 <= num && num < 100) {
			System.out.println("ポイント減らしカードを手に入れた");
			Useable card10 = new ReducePointCard();
			player.cards.add(card10);
		}
	}
}
