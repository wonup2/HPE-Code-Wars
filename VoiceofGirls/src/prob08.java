import java.util.*;
import java.io.*;
public class prob08 {
	
	static Scanner in;
	static String[] words;
	static String result;
	static int cnt;
	
	public static void main(String[] args) {
		try {
				in = new Scanner(new File("input.txt"));
				System.out.println(init());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static String init() {
		result = "";
		cnt = 0;
		words = new String[0];
		while(in.hasNextLine()) {
			if(words.length != 0) {
				result += "\n";
				cnt = 0;
			}
			words = in.nextLine().split(" ");
			//System.out.println(Arrays.toString(words));
			solve();
		}
		return result;
	}
	
	public static void solve() {
		for(int i = 0; i < words.length; i++) {
			if(words[i].length()+cnt > 80) {
				if(i == words.length-1)
					result = result.substring(0, result.length()-1) + "\n" + words[i];
				else
					result = result.substring(0, result.length()-1) + "\n" + words[i]+" ";
				cnt = words[i].length()+1;
			}
			else if(words[i].length()+cnt == 80) {
				if(i == words.length-1)
					result += words[i];
				else
					result += words[i]+"\n";
				cnt = 0;
			}
			else {
				if(i == words.length-1)
					result += words[i];
				else
					result += words[i]+" ";
				cnt += words[i].length()+1;
			}
		}
	}

}
