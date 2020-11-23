package sugoroku;

public class MoveCard2 extends GamePlay implements Useable{
	String name = "2進めるカード";

	@Override
	public String toString() {
		return name;
	}

	public int use(Player player) {
		return 1;
	}
}
