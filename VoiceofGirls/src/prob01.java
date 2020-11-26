import java.util.*;
import java.io.*;
public class prob01 {
	
	static Scanner in;
	static String name;
	
	public static void main(String[] args) {
		try {
			in = new Scanner(new File("input.txt"));
			name = in.nextLine();
			System.out.println("Welcome to CodeWars, " + name + "!");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
