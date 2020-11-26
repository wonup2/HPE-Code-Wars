import java.util.*;
import java.io.*;

public class prob02 {

	static Scanner in;
	static String num, ans;

	public static void main(String[] args) {
		try {
				in = new Scanner(new File("input.txt"));
				init();
				solve();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void init() {
		num = in.nextLine();
		ans = "";
	}
	
	public static void solve() {
		//System.out.println(num);
		for(int i = num.length()-1; i >= 0; i--) {
			ans+=num.charAt(i)+"";
		}
		System.out.println(ans);
	}

}
