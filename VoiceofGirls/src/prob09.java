import java.util.*;
import java.io.*;
public class prob09 {
	
	static Scanner in;
	static int totmin, totsec, min, sec;
	
	public static void main(String[] args) {
		try {
				in = new Scanner(new File("input.txt"));
				init();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void init() {
		totmin = 50;
		totsec = 0;
		min = -1;
		sec = -1;
		while(min != 0 && sec != 0) {
			min = in.nextInt();
			sec = in.nextInt();
			if(min == 0 && sec == 0)
				break;
			solve();
		}
	}
	
	public static void solve() {
		String remaining = "";
		totmin -= min;
		if(totmin < 1) 
			totsec -= sec;
		else {
			totmin -= 1;
			totsec = 60 - sec;
		}
		if(totsec < -60) {
			totmin += totsec/60;
			totsec += 60;
		}
		remaining = "Time remaining " + totmin + " minutes and " + totsec + " seconds";
		if(totmin < 0 || totsec < 0)
			remaining += " (we're gonna need a bigger record)";
		else if(totmin < 25)
			remaining += " (we'll need both sides)";
		System.out.println(remaining);
	}

}
