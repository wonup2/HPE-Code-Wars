import java.util.*;
import java.io.*;
public class prob05 {
	
	static Scanner in;
	static int n;

	public static void main(String[] args) {
		try {
				in = new Scanner(new File("input.txt"));
				init();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void init() {
		n = in.nextInt();
		System.out.println(solve());
	}
	
	public static String solve() {
		if(n == 1)
			return n + " is NOT Prime";
		if(n == 2)
			return n + " is PRIME";
		for(int i = 2; i < Math.sqrt(n)+1; i++) {
			if(n % i == 0) {
				return n + " is NOT Prime";
			}
		}
		return n + " is PRIME";
	}
}
