import java.io.*;
import java.util.*;
public class prob22 {
	
	static Scanner in;
	static char note, string;
	static int fret;
	static char[][] ary = {{'E', 'F', ' ', 'G', ' ', 'A', ' ', 'B', 'C', ' ', 'D', ' ', 'E'},{'A', ' ', 'B', 'C', ' ', 'D', ' ', 'E', 'F', ' ', 'G', ' ', 'A'}};
	
	
	public static void main (String [] args) {
		//E = 0 A = 1
		
		
		try {
			in = new Scanner(new File("input.txt"));
			
			while(in.hasNextLine()) {
				init();
			}
			
			in.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	private static void init() {
		fret = 0;
		string = ' ';
		note = ' ';
		String [] temp = in.nextLine().split(" ");
		//System.out.println(Arrays.toString(temp));
		if(temp.length == 1) {
			note = temp[0].charAt(0);
			System.out.println(canPlay(note));
		}else {
			fret = Integer.parseInt(temp[0]);
			string = temp[1].charAt(0);
			System.out.println(nextNote(fret, string));
		}
		
	}
	
	private static String canPlay(char c) {
		String ans = "";
		
		for(int i =0; i < 13; i++) {
			if(ary[0][i] == c) {
				ans +=  i + " E ";
			}
		}
		
		for(int i =0; i < 13; i++) {
			if(ary[1][i] == c) {
				ans +=  i + " A ";
			}
		}
	
		return ans.substring(0, ans.length()-1).trim();
	}
	
	private static char nextNote(int n, char c) {
		if(n == 12) {
			return c;
		}
		
		if(c == 'E') {
			char temp = ary[0][n];
			temp = (char)(temp+1);
			if(temp > 70) {
				temp = 'A';
			}
			return temp;
		}else {//A
			char temp = ary[1][n];
			temp = (char)(temp+1);
			if(temp > 70) {
				temp = 'A';
			}
			return temp;
		}
	}

}
