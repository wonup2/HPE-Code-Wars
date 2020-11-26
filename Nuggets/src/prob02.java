import java.util.*;
import java.io.*;
public class prob02 {
	
	static Scanner in;
	static String temp, ans = "";
	
	public static void main(String[] args) throws IOException{
		in = new Scanner(new File("input.txt"));
		init();
		solve();
		in.close();
	}
	
	static void init() {
		temp = in.nextLine();
	}
	
	static void solve() {
		for(int i = temp.length() - 1; i >= 0; i--)
			ans += temp.charAt(i);
		System.out.println(ans);
	}

}
