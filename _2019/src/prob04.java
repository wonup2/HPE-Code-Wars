import java.util.*;
import java.io.*;

public class prob04 {
	static String file = "prob04";
	static Scanner in;
	static PrintWriter out;

	public static void main(String[] args) throws IOException {
		
		int n = 1;
		for(int i=1; i<=n; i++) {
			in = new Scanner(new File (file+"-"+i+"-in.txt"));
			out = new PrintWriter(new File("out.txt"));
			solve();
			in.close();
			out.close();
			Check.check(file+"-"+i+"-out.txt");
		}		
	}
	
	static void solve() {
		int n = in.nextInt();
		String s = "";
		for(int i=0; i<n; i++) {
			double d = 60*in.nextDouble()/in.nextInt();
			if((d+"").length()<12) out.println(d);
			else out.printf("%.9f\n", d);
		}
	}
}
