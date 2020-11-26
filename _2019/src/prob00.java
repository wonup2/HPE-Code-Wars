import java.util.*;
import java.io.*;

public class prob00 {
	static String file = "prob00";
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
		
	}
}
