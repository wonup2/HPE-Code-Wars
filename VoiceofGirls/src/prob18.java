import java.io.*;
import java.util.*;
import java.text.DecimalFormat;
public class prob18 {
	
	static Scanner in;
	static String[] temp;
	static int H, M;
	

	public static void main(String[] args) {
		try {
			in = new Scanner(new File("input.txt"));

			while(in.hasNextLine()) {
				init();
				solve();
			}
			
			in.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private static void init() {
		temp = in.nextLine().split(":");
		H = Integer.parseInt(temp[0]);
		M = Integer.parseInt(temp[1]);
		
		while(H > 12) {
			H -= 12;
		}
	}
	
	private static void solve() {
		double hd = H * 30 + M * 0.5;
		double md = M * 6;
		
		double ans = Math.abs(hd-md);
		
		if(ans > 180.0) {
			ans = 360 - ans;
		}
		
		DecimalFormat df = new DecimalFormat("0.00");
		
		if(ans == 360.00) {
			ans = 0.00;
		}
		
		
		System.out.print("The angle between the Hour hand and Minute hand is ");
		System.out.println(df.format(ans) + " degrees.");
	}
}
