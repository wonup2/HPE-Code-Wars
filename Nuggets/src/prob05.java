import java.util.*;
import java.io.*;
public class prob05 {
	
	static Scanner in;
	static int n;
	static boolean ans = true;
	
	public static void main(String[] args) throws IOException{
		in = new Scanner(new File("input.txt"));
		init();
		solve();
		in.close();
	}
	
	static void init() {
		n = in.nextInt();
	}
	
	static void solve() {
		if(n == 1)
			System.out.println(n + " is NOT prime");
		else{
			for(int i = 2; i <= Math.sqrt(n); i++) {
				if(n % i == 0)	ans = false;
			}
			if(ans)
				System.out.println(n + " is PRIME");
			else
				System.out.println(n + " is NOT Prime");
		}
	}

}
