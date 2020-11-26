import java.util.*;
import java.io.*;

public class prob08{

	static String file = "prob08";
	static Scanner in;
	static PrintWriter out;
	static String[] a= {"ZERO", "ONE", "TWO", "THREE", "FOUR", "FIVE", "SIX", 
			            "SEVEN", "EIGHT", "NINE", "TEN", "ELEVEN", "TWELVE"};
	static int n, x[], y[];
	static String _input, input[];
	
	public static void main(String[] args)throws IOException{
		for(int i=1; i<=1; i++) {
			in = new Scanner(new File(file+"-"+i+"-in.txt"));
			out = new PrintWriter(new File("out.txt"));
			
			
			x=new int[26];
			_input = in.nextLine();
			String[] input = _input.split(" ");
			for(int j=0; j<input.length-1; j++) {
				n=Integer.parseInt(input[j]);
				solve();
			}			
			output();			
			
			
			in.close();out.close();
			System.out.println(i);
			Check.check(file+"-"+i+"-out.txt");
		}
	}
	
	private static void solve() {
		y = new int[26];
		String s = a[n];
		for(int i=0; i<s.length(); i++) {
			int index = s.charAt(i)-'A';
			y[index]++;
		}		
		for(int i=0; i<26; i++) x[i] = Math.max(x[i], y[i]);			
	}
	
	private static void output() {
		String temp = _input.substring(0,_input.length()-4)+". ";
	
		for(int k=0; k<26; k++) 
			for(int j=0; j<x[k]; j++) 
				temp+=(char)(k+'A')+" ";
		
		out.println(temp.trim());
	}
}
