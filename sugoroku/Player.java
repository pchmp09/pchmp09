package sugoroku;

import java.util.ArrayList;
import java.util.List;

public class Player extends GamePlay {
	private String name;
	private int masu = 0;
	private int point = 0;
	List<Useable> cards = new ArrayList<>();

	public Player(String name) {
		this.name = name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public int getMasu() {
		return masu;
	}

	public void setMasu(int dice) {
		masu += (dice + 1);
	}

	//ゴールを超過した時の処理
	public void setMasu() {
		masu = GOAL - (getMasu() - GOAL);
	}

	//戻るマスで0を下回った時の処理
	public void clearMasu() {
		masu = 0;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point += point;
	}

	//ポイント入れ替えカード使用時の処理
	public void exchangePoint(Player other) {
		int myPoint = getPoint();
		int otherPoint = other.getPoint();

		setPoint(otherPoint - myPoint);
		other.setPoint(myPoint - otherPoint);
	}

	@Override
	public String toString() {
		return name + "さん　　現在" + masu + "マス目, ポイントは" + point + "点";
	}

	public void showCards() {
		System.out.println("所持カード");
		if (cards.size() < 1) {
			System.out.println("なし");
		}
		for (int i = 0; i < cards.size(); i++) {
			System.out.println(cards.get(i) + "[" + (i + 1) + "]");
		}
	}

	public void showInformation() {
		System.out.println("----------------------------------------");
		System.out.println(this);
		showCards();
	}

	public static void main(String[] args) {
		Player player = new Player("aa");
		player.showInformation();
	}

}
