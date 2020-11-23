package sugoroku;

public class MoveCard3 extends GamePlay implements Useable{
	String name = "3進めるカード";

	@Override
	public String toString() {
		return name;
	}

	public int use(Player player) {
		return 2;
	}
}
