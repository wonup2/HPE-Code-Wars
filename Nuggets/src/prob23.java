import java.util.*;
import java.io.*;

public class prob23 {
	
	final static int MAX = 1000000000;
	static Scanner in;
	
	public static void solve() {
		// TODO Auto-generated method stub
		int loop = in.nextInt();
		in.nextLine();
		for(int t = 0; t < loop; t++) {
			String inputtemp = in.nextLine();
			String inputcheck = inputtemp.toLowerCase();
			String result = "";
			String input = "";
			for(int i = 0; i < inputcheck.length(); i++) {
				if(Character.isLetter(inputcheck.charAt(i)) || inputcheck.charAt(i) == ' ') input +=inputcheck.charAt(i);
			}
			for(int i = input.length() - 1; i >= 0; i--) {
				char c = input.charAt(i);
				if(c == 'o' || c == 's' || c == 'x' || c == 'z') {
					result+=c;
				} else if(c == 'a') {
					result+='e';
				} else if(c == 'e') {
					result+='a';
				} else if(c == 'b') {
					result+='q';
				} else if(c == 'q') {
					result+='b';
				} else if(c == 'd') {
					result+='p';
				} else if(c == 'p') {
					result+='d';
				} else if(c == 'h') {
					result+='y';
				} else if(c == 'y') {
					result+='h';
				} else if(c == 'm') {
					result+='w';
				} else if(c == 'w') {
					result+='m';
				} else if(c == 'n') {
					result+='u';
				} else if(c == 'u') {
					result+='n';
				} else if(Character.isAlphabetic(c)) {
					result+=c;
				} else result+=" ";
			}
			String resulttemp = "";
			inputtemp = "";
			for(int i = 0; i < input.length(); i++) {
				if(input.charAt(i) != ' ') inputtemp+=input.charAt(i);
			}
			for(int i = 0; i < result.length(); i++) {
				if(result.charAt(i) != ' ') resulttemp += result.charAt(i);
			}
			boolean is = false;
			if(inputtemp.equals(resulttemp)) is = true;
			if(is) System.out.println(input + " (is) " + result);
			else System.out.println(input + " (not) " + result);
		}
	}
	
	static String printDecimals(double value, int digits, boolean round) {
		for(int i = 0; i < digits; i++) {
			value *= 10;
		}
		int point = (int) ((value * 10) % 10);
		int val = (int) value;
		if(round && point > 4) {
			val++;
		}
		String ret = val + "";
		if(ret.length() == digits) {
			return "0." + ret;
		}
		return ret.substring(0, ret.length() - digits) + "." + ret.substring(ret.length() - digits);
 	}
	
	public static boolean isPrime(int n) {
		if(!notPrime[0])runSieve();
		return !notPrime[n];
	}
	
	static boolean[] notPrime = new boolean[MAX];
	
	public static void runSieve() {
		notPrime[0] = true;
		notPrime[1] = true;
		for(int i = 2; i <= MAX / 2; i++)	{
			if(!notPrime[i]) {
				for(int j = i * 2; j < MAX; j += i) {
					notPrime[j] = true;
				}
			}
		}
	}
	
	
	public static void main(String[] args) throws IOException{
		in = new Scanner(new File("input.txt"));
		solve();
	}
}