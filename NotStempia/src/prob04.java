import java.util.*;
import java.io.*;

public class prob04 {

	public static void main(String[] args) throws IOException{

		BufferedReader in = new BufferedReader(new FileReader("input.txt"));
		
		int a = Integer.parseInt(in.readLine());
		int b = Integer.parseInt(in.readLine());
		System.out.println(LCM(a, b));
		
	}
	public static int LCM(int a, int b) {
	    return (a * b) / GCF(a, b);
	  }
	
	public static int GCF(int a, int b) {
	    if (b == 0) {
	      return a;
	    } else {
	      return (GCF(b, a % b));
	    }
	  }


}
