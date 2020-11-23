package sugoroku;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Game {
	static final int GOAL = 30;
	static List<Player> players = new ArrayList<>();

	//プレイヤーの人数と名前を設定する処理
	static void createPlayers() {

		int num = 0;
		while (true) {
			System.out.print("何人でプレイしますか？：");
			try {
				Scanner sc = new Scanner(System.in);
				num = sc.nextInt();
				if (num < 1) {
					System.out.println("このゲームは一人以上のプレイです");
					continue;
				}
			} catch (InputMismatchException e) {
				System.out.println("半角数字を入力してください");
			}
			break;
		}

		System.out.println("名前を入力してください");
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < num; i++) {
			System.out.print((i + 1) + "人目のプレイヤー：");
			String name = sc.next();
			Player player = new Player(name);
			players.add(player);
		}

	}

	public static void main(String[] args) {

		Game game = new Game();
		createPlayers();
		GamePlay.playGame();

	}
}
