import java.util.*;
import java.io.*;

public class Prob02 {

	static Scanner in;
	
	public static void main(String[] args) throws IOException {
		
		File path = new File(System.getProperty("user.dir"));
		
		in = new Scanner(new File(path+"\\files\\prob02-1-in.txt"));
		
		String s = in.nextLine();
		
		System.out.println(s);
		

	}

}
