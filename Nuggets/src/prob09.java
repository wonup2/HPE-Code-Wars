import java.util.*;
import java.io.*;
public class prob09 {
	
	static Scanner in;
	static int min, sec;
	static boolean bothSides = false, biggerRecord = false;
	
	public static void main(String[] args) throws IOException{
		in = new Scanner(new File("input.txt"));
		init();
		solve();
		in.close();
	}
	
	static void init() {
		min = in.nextInt(); sec = in.nextInt();
	}
	
	static void solve() {
		int minL, secL;
		if(min > 25 || (min == 25 && sec > 0)){
			if(min > 50 || (min == 50 && sec > 0))
				biggerRecord = true;
			else
				bothSides = true;
		}
		int total = (min * 60) + sec;
		total -= 3000;
		if(total <= 0) {
			minL = Math.abs(total / 60);
			secL = Math.abs(total % 60);
		}else {
			minL = 0 - (total / 60);
			secL = 0 - (total % 60);
		}
		if(bothSides)
			System.out.println("Time remaining " + minL + " minutes and " + secL + " seconds (we'll need both sides)");
		else if(biggerRecord)
			System.out.println("Time remaining " + minL + " minutes and " + secL + " seconds (we're gonna need a bigger record)");
		else
			System.out.println("Time remaining " + minL + " minutes and " + secL + " seconds");

	}

}
