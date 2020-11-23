package sugoroku;

public class MoveCard4 extends GamePlay implements Useable{
	String name = "4進めるカード";

	@Override
	public String toString() {
		return name;
	}

	public int use(Player player) {
		return 3;
	}
}
