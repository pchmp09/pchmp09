package sugoroku;
import java.util.Random;

public class GetPointsCard  extends GamePlay implements Useable{
	String name = "ポイントゲットカード";

	@Override
	public String toString() {
		return name;
	}

	public int use(Player player) {
		Random r = new Random();
		int point = r.nextInt(10);
		System.out.println((point + 1) + "点獲得！");
		player.setPoint(point + 1);
		System.out.println("現在 " + player.getPoint() + " 点");
		return -1;

	}

}
