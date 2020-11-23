package sugoroku;

public class MoveCard5 extends GamePlay implements Useable{
	String name = "5進めるカード";

	@Override
	public String toString() {
		return name;
	}
	
	public int use(Player player) {
		return 4;
	}
}
