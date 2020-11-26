import java.util.*;
import java.io.*;
public class prob28 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		Scanner in = new Scanner(new File("input.txt"));
		while(in.hasNextLine()) {
			String s = in.nextLine();
			String[] inp = s.split(" ");
			long[] num = new long[inp.length];
			for(int i = 0; i < inp.length; i++) {
				num[i] = Long.parseLong(inp[i]);
			}
			if(isExp(num) == 2)
				System.out.println("X^2");
			else if(isExp(num) == 3)
				System.out.println("X^3");
			else if(isGeo(num) == 1)
				System.out.println("Geometric (With Gaps)");
			else if(isGeo(num) == 2)
				System.out.println("Geometric");
			else if(isFib(num))
				System.out.println("Fibonacci");
			else
				System.out.println(s + " is an Unknown series");
		}
	}
	
	public static int isGeo(long[] num) {
		int good = 0;
		int nogood = 0;
		boolean check = true;
		long[] a = Arrays.copyOf(num, num.length);
		Arrays.sort(a);
		for(int i = 0; i < a.length-1; i++) {
			if(a[i+1] % a[i] != 0)
				return 0;
		}
		long constant = a[1]/a[0];
		for(int i = 0; i < a.length-1; i++) {
			if(a[i+1] / a[i] == constant)
				good++;
			else
				nogood++;
		}
		if(good == 0 || nogood == 0)
			return 2;
		else
			return 1;
		
	}
	
	public static int isExp(long[] num) {
		int two = 0;
		int three = 0;
		int eh = 0;
		for(int i = 0; i < num.length-1; i++) {
			if(num[i+1] == Math.pow(num[i], 2))
				two++;
			else if(num[i+1] == Math.pow(num[i], 3))
				three++;
			else 
				eh++;
		}
		if(two > three && eh == 0)
			return 2;
		else if(three > two && eh == 0)
			return 3;
		else
			return 1;
	}
	
	public static boolean isFib(long[] num) {
		for(int i = 0; i < num.length-2; i++) {
			if(num[i] + num[i+1] != num[i+2])
				return false;
		}
		return true;
	}
	
	
}
