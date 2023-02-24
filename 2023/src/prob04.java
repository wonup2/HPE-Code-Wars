//Sean
import java.util.*;

public class prob04 {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		double o = in.nextDouble();
		double k = in.nextDouble();
		double total = 0.0;
		
		while(o != 0 && k != 0) {
			double diff = k - o;
			int t = (int)(diff*10);
			diff = t/10.0;
			System.out.println("DIFF: " + diff);
			total += diff;
			o = in.nextDouble();
			k = in.nextDouble();
		}
		System.out.println("TOTAL: " + total);
	}
}