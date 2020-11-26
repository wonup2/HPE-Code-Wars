import java.util.*;
import java.io.*;

public class prob17 {
	
	final static int MAX = 1000000000;
	static Scanner in;
	
	public static void solve() {
		// TODO Auto-generated method stub
		int size = Integer.parseInt(in.nextLine());
		boolean[][] grid = new boolean[size][size];
		HashMap<Character, Integer> chartoint = new HashMap<Character, Integer>();
		HashMap<Integer, Character> inttochar = new HashMap<Integer, Character>();
		for(int i = 0; i < size; i++) {
			String temp = in.nextLine();
			char c = temp.charAt(0);
			chartoint.put(c, i);
			inttochar.put(i, c);
		}
		while(in.hasNextLine()) {
			if(in.next().length() == 0) break;
			char start = in.next().charAt(0);
			in.next();
			in.next();
			in.next();
			in.next();
			char end = in.next().charAt(0);
			in.next();
			String mode = in.next();
			in.nextLine();
			if(!mode.equals("air")) {
				grid[chartoint.get(start)][chartoint.get(end)] = true;
				grid[chartoint.get(end)][chartoint.get(start)] = true;
			}
		}
		ArrayList<Integer>[] a = new ArrayList[size];
		for(int i = 0; i < size; i++) {
			a[i] = new ArrayList<Integer>();
		}
		for(int i = 0; i < size; i++) {
			for(int j = 0; j < size; j++) {
				if(grid[i][j]) a[i].add(j);
				else {
					for(int k = 0; k < size; k++) {
						if(grid[i][k] && grid[j][k]) a[i].add(j);
					}
				}
			}
		}
		String result = "";
		for(int i = 0; i < size; i++) {
			if(a[i].size() == 0) result+="City " + inttochar.get(i) + " is remote and has no neighbours!\n";
			else {
				result+="City " + inttochar.get(i) + " is neighbour to Cities ";
				String temp = "";
				for(int j = 0; j < a[i].size(); j++) {
					if(i != a[i].get(j)) temp+="," + inttochar.get(a[i].get(j));
				}
				result+=temp.substring(1) + "\n";
			}
		}
		System.out.println(result);
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