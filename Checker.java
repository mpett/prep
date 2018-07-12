package test;
import java.util.Comparator;

public class Checker implements Comparator<Player> {

	@Override
	public int compare(Player x, Player y) {
		// TODO Auto-generated method stub
		if (x.score > y.score) {
			return -1;
		}
		if (x.score < y.score) {
			return 1;
		}
		if (x.score == y.score) {
			return x.name.compareTo(y.name);
		}
		return 0;
	}
}
