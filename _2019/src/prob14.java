import java.util.*;
import java.io.*;
public class prob14 {
	static String file = "prob14";
	static Scanner in;
	static PrintWriter out;
	public static void main(String[] args) {
		in = new Scanner(System.in);
		int a = in.nextInt();
		int b = in.nextInt();
		int c = in.nextInt();
		System.out.print(a+","+b);

		int result = 0;
		for(int i=0; i<c-2; i++) {
			result = a+b;
			System.out.print(","+result);
			a=b;
			b=result;
		}
	}
}