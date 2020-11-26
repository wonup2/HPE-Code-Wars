import java.util.*;
import java.io.*;
public class prob03 {
	
	static Scanner in;
	static int ans = 0, x, y;
	
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
		int max = Math.max(x,  y);
		for(int i = 1; i <= min; i++) {
			if(min % i == 0 && max % i == 0)
				ans = i;
		}
		System.out.println(ans);
	}

}
