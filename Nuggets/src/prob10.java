import java.util.*;
import java.io.*;

public class prob10 {
	
	final static int MAX = 1000000000;
	static Scanner in;
	
	public static void solve() {
		// TODO Auto-generated method stub
		String sentence = in.nextLine();
		in.nextLine();
		ArrayList<String> nouns = new ArrayList<String>();
		while(true) {
			String temp = in.next();
			if(temp.equals("ADVERBS")) break;
			nouns.add(temp);
		}
		in.nextLine();
		ArrayList<String> adverbs = new ArrayList<String>();
		while(true) {
			String temp = in.next();
			if(temp.equals("VERBS")) break;
			adverbs.add(temp);
		}
		in.nextLine();
		ArrayList<String> verbs = new ArrayList<String>();
		while(true) {
			String temp = in.next();
			if(temp.equals("ADJECTIVES")) break;
			verbs.add(temp);
		}
		in.nextLine();
		ArrayList<String> adjectives = new ArrayList<String>();
		while(true) {
			String temp = in.next();
			if(temp.equals("END")) break;
			adjectives.add(temp);
		}
		for(int loop = 0; loop < 2; loop++) {
			String result = "";
			for(int i = 0; i < sentence.length(); i++) {
				if(sentence.charAt(i) == '[') {
					i++;
					if(sentence.charAt(i) == 'N') {
						result+=nouns.get(0) + " ";
						nouns.remove(0);
						i+=2;
					} else if(sentence.charAt(i) == 'V') {
						result+=verbs.get(0) + " ";
						verbs.remove(0);
						i+=2;
					} else {
						i++;
						if(sentence.charAt(i) == 'J') {
							result+=adjectives.get(0) + " ";
							adjectives.remove(0);
							i+=2;
						} else {
							result+=adverbs.get(0) + " ";
							adverbs.remove(0);
							i+=2;
						}
					}
				} else {
					result+=sentence.charAt(i);
				}
			}
			System.out.println(result);
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
	
	
	public static void main(String[] args) throws IOException {
		in = new Scanner(new File("input.txt"));
		solve();
	}

}