package sugoroku;

public class MoveCard1 extends GamePlay implements Useable{
	String name = "1進めるカード";

	@Override
	public String toString() {
		return name;
	}

	public int use(Player player) {
		return 0;
	}
}
