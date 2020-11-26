import java.util.*;
import java.io.*;
public class prob06 {
	
	static Scanner in;
	static ArrayList<Integer> list = new ArrayList<Integer>();
	static ArrayList<String> ans = new ArrayList<String>();
	
	public static void main(String[] args) throws IOException{
		in = new Scanner(new File("input.txt"));
		init();
		solve();
		in.close();
	}
	
	static void init() {
		while(in.hasNext()) {
			list.add(in.nextInt());
		}
	}
	
	static void solve() {
		for(int x = 0; x < list.size(); x++) {
			
			String s = "";
			int num = list.get(x);
			int len = list.get(x).toString().length();
			
			if(len == 1)
				s = convertSingle(num);
			else if(len == 2)
				s = convertDouble(num);
			else if(len == 3)
				s = convertTriple(num);
			else
				s = "R";
			
			ans.add(s);
		}
		System.out.println(ans);
	}
	
	static String convertSingle(int n) {
		String temp = "";
		if(n <= 3) {
			for(int i = 0; i < n; i++)
				temp += "B";
		}else if(n == 4)
			temp = "BW";
		else if(n == 5)
			temp = "W";
		else if(n >= 6 && n <= 8) {
			temp = "W";
			for(int i = 0; i < n - 5; i++)
				temp += "B";
		}else
			temp = "BK";
		return temp;
	}
	
	static String convertDouble(int n) {
		String ones = convertSingle(n % 10);
		String temp = "";
		if(n < 40) {
			for(int i = 0; i < n / 10; i++)
				temp += "Z";
		}else if(n >= 40 && n < 50)
			temp = "ZP";
		else if(n >= 50 && n < 60)
			temp = "P";
		else if(n >= 60 && n < 90) {
			temp = "P";
			for(int i = 0; i < (n / 10) - 5; i++)
				temp += "Z";
		}else
			temp = "ZB";
		return temp + ones;
	}
	
	static String convertTriple(int n) {
		String tens = convertDouble(n % 100);
		String temp = "";
		if(n < 400) {
			for(int i = 0; i < n / 100; i++)
				temp += "B";
		}else if(n >= 400 && n < 500)
			temp = "BG";
		else if(n >= 500 && n < 600)
			temp = "G";
		else if(n >= 600 && n < 900) {
			temp = "G";
			for(int i = 0; i < (n / 100) - 5; i++)
				temp += "B";
		}else
			temp = "BR";
		return temp + temp + tens;
	}

}
