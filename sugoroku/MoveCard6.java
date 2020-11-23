package sugoroku;

public class MoveCard6 extends GamePlay implements Useable{
	String name = "6進めるカード";

	@Override
	public String toString() {
		return name;
	}

	public int use(Player player) {
		return 5;
	}
}
