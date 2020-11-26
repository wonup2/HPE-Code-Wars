import java.util.*;
import java.io.*;
public class prob14 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		Scanner in = new Scanner(new File("input.txt"));
		int n1 = in.nextInt();
		int n2 = in.nextInt();
		String res = "";
		for(int i = n1; i < n2; i++) {
			if(work(i+""))
				res += i + " ";
		}
		if(res.equals(""))
			System.out.println("No Numbers found with Equal Sum in the given range!!");
		else
			System.out.println(res);
	}
	
	public static boolean work(String n) {
		int suma = 0;
		int sumb = 0;
		for(int i = 0; i < n.length(); i++) {
			if(i % 2 == 0)
				suma += Integer.parseInt(n.charAt(i)+"");
			else
				sumb += Integer.parseInt(n.charAt(i)+"");
		}
		if(suma == sumb)
			return true;
		return false;
	}
}
