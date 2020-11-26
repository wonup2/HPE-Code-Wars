import java.io.*;
import java.util.*;
public class prob19 {
	
	static Scanner in;
	static String str1, str2;
	static String hex1, hex2;
	static String ans;
	
	public static void main(String[] args) {
		try {
			in = new Scanner(new File("input.txt"));
			
			init();
			solve();
			
			in.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private static void init() {
		str1 = in.nextLine();
		str2 = in.nextLine();
		hex1 = "";
		
		for(int i =0; i < str1.length(); i++) {
			if(str1.charAt(i) == ' ') {
				continue;
			}
			int temp = 0;
			if(Character.isUpperCase(str1.charAt(i))) {
				temp = str1.charAt(i)-0;
				hex1 += Integer.toHexString(temp) + " ";
				
			}else {
				temp = str1.charAt(i)-0;
				hex1 += Integer.toHexString(temp) + " ";
				
			}
		}
		System.out.println(hex1);
	}
	
	private static void solve() {
		
		hex2 = "";
		int count = -1;
		for(int i = hex1.length()-1; i >=0; i--) {
			if(hex1.charAt(i) != ' ') {
				count+= 1;
			}else {
				continue;
			}
			
			if(count % 4 == 0) {
				hex2 = hex1.charAt(i) + hex2;
			}
		}
		
		System.out.println(hex2);
		
		ans = "";
		for(int i =0 ;i < hex2.length();) {
			String t = hex2.substring(i, i+2);
			int dec = Integer.parseInt(t, 16);
			
			ans += "" + (char)dec;
			
			i= i+2;
		}
		
		System.out.print(ans);
	}

	
}
//62 75 6d 70 6f 77 66 75 6e 77 61 70 73 77 65 70 74 67 75 79 
//5075707079