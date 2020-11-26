import java.util.*;
import java.io.*;
public class prob04 {
	
	static Scanner in;
	static int ans, x, y;
	
	public static void main(String[] args) throws IOException{
		in = new Scanner(new File("input.txt"));
		init();
		solve();
		in.close();
	}
	
	static void init() {
		x = in.nextInt();
		y = in.nextInt();
	}
	
	static void solve() {
		int min = Math.min(x, y);
		int max = Math.max(x, y);
		int i = 1;
		while((max * i) % min != 0)
			i++;
		ans = max * i;
		System.out.println(ans);
	}

}
