import java.util.*;
import java.io.*;
public class prob04 {
	
	static Scanner in;
	static int x, y, high, low, lcm;

	public static void main(String[] args) {
		try {
				in = new Scanner(new File("input.txt"));
				init();
				solve();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void init() {
		x = in.nextInt();
		y = in.nextInt();
		high = Math.max(x, y);
		low = Math.min(x, y);
		lcm = high;
	}
	
	public static void solve() {
		while(lcm % low != 0) {
			lcm += high;
		}
		System.out.println(lcm);
	}
}

