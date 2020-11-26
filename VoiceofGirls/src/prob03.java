import java.util.*;
import java.io.*;
public class prob03 {
	
	static Scanner in;
	static int x, y;
	static List<Integer>div;
	
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
		div = new ArrayList<Integer>();
	}
	
	public static void solve() {
		int min = Math.min(x, y);
		for(int i = 1; i <= min; i++) {
			if(x % i == 0 && y % i == 0)
				div.add(i);
		}
		System.out.println(div.get(div.size()-1));
	}

}
