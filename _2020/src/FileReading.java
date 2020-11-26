import java.util.*;
import java.io.*;
public class FileReading {

	public static void main(String[] args) throws IOException {

		//Scanner in = new Scanner(new File("input.txt"));
		Scanner in = new Scanner(System.in);
		while(true) {
			String s = in.nextLine();
			System.out.println(s);
			if(s==null) break;
		}
	}

}
