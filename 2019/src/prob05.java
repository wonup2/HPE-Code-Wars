import java.util.*;
import java.io.*;
import java.text.DecimalFormat;

public class prob05 {
	static String file = "prob05";
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
		
		String pattern = "##.#########";
		DecimalFormat decimalFormat = new DecimalFormat(pattern);
		int n = in.nextInt();
		String a[] = new String[n];
		
		for(int i=0; i<n; i++) {
			a[i] = in.next();
			a[i] = decimalFormat.format(in.nextDouble()/in.nextDouble()) + " " + a[i];
		}
		Arrays.sort(a);
		
		String s[] = a[0].split(" ");
		out.println(s[1]+" "+s[0]);
	}
}
