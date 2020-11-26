import java.util.*;
import java.io.*;
public class prob01 {
	
	static Scanner in;
	static String temp;
	
	public static void main(String[] args) throws IOException{
		in = new Scanner(new File("input.txt"));
		init();
		solve();
		in.close();
	}
	
	static void init() {
		temp = in.nextLine();
	}
	
	static void solve() {
		System.out.println("Welcome to CodeWars, " + temp + "!");
	}

}
