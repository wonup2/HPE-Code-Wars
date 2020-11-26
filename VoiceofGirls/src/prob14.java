import java.util.*;
import java.io.*;

public class prob14 {
	static Scanner in;
	static int n1, n2;
	public static void main(String[] args) throws IOException{
		in = new Scanner (new File("input.txt"));
			
			init();
			solve();
		
	
		in.close(); 
	}
	static void init(){
		n1 = in.nextInt();
		n2 = in.nextInt();
		//System.out.println(n1);
		//System.out.println(n2);
	}
	static void solve(){
		String ans = "";
		for(int i = n1; i < n2; i++){
			//4System.out.println(i);
			if(check(i)){
				ans += " "+i;
			}
		}
		if(ans.equals("")) System.out.println("No Numbers found with Equal Sum in the given range!!");
		else
		System.out.println(ans.substring(1));
	}
	static boolean check(int n)
	{
		String temp = "" + n;
		int even = 0;
		int odd = 0;
		int num = 0;
		for(int i = temp.length()-1; i >=0; i--){
			if(num%2 == 0) even+= Integer.parseInt(""+temp.charAt(i));
			else odd+=Integer.parseInt(""+temp.charAt(i));
			num++;
		}
		if(odd == even) return true;
		else return false;
	}
}
