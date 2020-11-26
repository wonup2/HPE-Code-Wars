
import java.util.*;
import java.io.*;
public class prob19 {
	public static void main(String[] args) throws IOException{
		Scanner in = new Scanner(new File("input.txt"));
		String input = in.nextLine();
		in.nextLine();
		input = input.replace(" ", "");
		String ans1 = "";
		for(int i = 0; i < input.length(); i++) {
			ans1 += Integer.toHexString((int)input.charAt(i)) + " ";
		}
		ans1 = ans1.substring(0,ans1.length()-1);
		System.out.println(ans1);
		ans1 = ans1.replace(" ", "");
		String ans2 = "";
		for(int i = ans1.length()-1; i >=0 ; i-=4) {
			ans2 = ans1.charAt(i) + ans2;
		}
		System.out.println(ans2);
		String ans3 = "";
		for(int i = 0; i < ans2.length(); i+=2) {
			 String temp = ans2.charAt(i)  + "" + ans2.charAt(i+1);
			 ans3 += (char)Integer.parseInt(temp,16);
		}
		System.out.println(ans3);
	}
}
