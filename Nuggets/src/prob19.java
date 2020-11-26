import java.util.*;
import java.io.*;
public class prob19 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		Scanner in = new Scanner(new File("input.txt"));
		String str = in.nextLine().replaceAll(" ", "");
		String res1 = "";
		for(int i = 0; i < str.length(); i++) {
			res1 += Integer.toHexString((int)str.charAt(i)) + " ";
		}
		System.out.println(res1);
		
		res1 = res1.replaceAll(" ", "");
		int count = 0;
		String res2 = res1.charAt(res1.length()-1)+"";
		for(int i = res1.length()-2; i >= 0; i--) {
			count++;
			if(count == 4) {
				res2 = res1.charAt(i) + res2;
				count = 0;
			}
		}
		System.out.println(res2);
		
		String res3 = "";
		for(int i = 0; i < res2.length()-1; i+=2) {
			String temp = "" + res2.charAt(i) + res2.charAt(i+1);
			int dec = Integer.parseInt(temp, 16);
			res3 += (char) dec;
		}
		System.out.println(res3);
	}

}
