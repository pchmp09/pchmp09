package sugoroku;

import java.util.Comparator;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.TreeMap;

public class GamePlay extends Game {

	static void playGame() {
		Scanner sc = new Scanner(System.in);
		Random r = new Random();

		int dice;
		int turn = 1;
		int command;

		//ゲーム全体のループ処理
		game: while (true) {

			//プレイヤーごとのターンのループ処理
			turn: for (int i = 0; i < players.size(); i++) {
				try {
					System.out.println(players.get(i).getName() + "さんの順番です");

					//コマンド選択のループ処理
					command: while (true) {
						System.out.println("----------------------------------------");
						System.out.println("コマンド？");
						System.out.println("サイコロ->1\nカード->2\n情報->3");
						command = sc.nextInt();

						//コマンド選択後の行動の処理
						switch (command) {

						case 1:
							dice = r.nextInt(5);
							break command;

						case 2:
							if (players.get(i).cards.size() < 1) {
								System.out.println("カードを持っていません");
								break;
							}
							players.get(i).showCards();
							System.out.println("どれを使用しますか？([0]でコマンド入力に戻る)");
							int num = sc.nextInt()-1;

							if (num == -1) {
								break;

							} else if (num<0 || players.get(i).cards.size()<num+1) {
								System.out.println("入力に誤りがあります");
								break;
							}

							dice = players.get(i).cards.get(num).use(players.get(i));

							//サイコロの数値に影響を与えないカードを使用した時の処理
							if (-1 == dice) {
								players.get(i).cards.remove(players.get(i).cards.get(num));
								continue turn;

							//カードの使用を止めた時の処理
							}else if(-2 == dice){
								break;
							}
							players.get(i).cards.remove(players.get(i).cards.get(num));
							break command;

						case 3:
							players.get(i).showInformation();
							break;

						default:
							System.out.println("入力に誤りがあります");
							break;
						}
					}

					System.out.println("出目は " + (dice + 1) + " です");
					players.get(i).setMasu(dice);

					//ゴール判定. 進むイベントを踏んだ時用のループ処理
					diceTurn: for (int j = 0; j < 2; j++) {

						//ゴールを超えたら超過分のマスを戻る
						if (players.get(i).getMasu() > GOAL) {
							System.out.println("ゴールを" + (players.get(i).getMasu() - GOAL) + "マス分オーバーしました");
							players.get(i).setMasu();
						} else if (players.get(i).getMasu() == GOAL) {
							System.out.println("ゴール！");
							System.out.println("1着の特典として10ポイント");
							players.get(i).setPoint(10);
							break game;
						}
						if (j < 1) {
							int masu = players.get(i).getMasu();
							Event.event(players.get(i));

							if (masu == players.get(i).getMasu()) {
								break diceTurn;
							}
						}
					}

					System.out.println("現在位置：" + players.get(i).getMasu() + "マス目");
					System.out.println("----------------------------------------");

				} catch (Exception e) {
					System.out.println("エラー発生" + e);
					continue turn;
				}
			}

			System.out.println(turn + "ターン目終了");
			for (Player player : players) {
				System.out.println(player);
			}
			System.out.println("----------------------------------------");
			turn++;
		}

		//ゴール後、ポイント降順にプレイヤーを並び替えて順位を出力する処理
		Map<Integer, String> ranking = new TreeMap<Integer, String>(new Comparator<Integer>() {
			public int compare(Integer m, Integer n) {
				return ((Integer) m).compareTo(n) * -1;
			}
		});

		for (int i = 0; i < players.size(); i++) {
			ranking.put(players.get(i).getPoint(), players.get(i).getName());
		}

		System.out.println("順位");
		for (Map.Entry<Integer, String> entry : ranking.entrySet()) {
			System.out.println(entry.getValue() + "さん：" + entry.getKey() + "点");
		}
	}
}
