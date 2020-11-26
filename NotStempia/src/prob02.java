import java.util.*;
import java.io.*;

public class prob02 {

	public static void main(String[] args) throws IOException{

		BufferedReader in = new BufferedReader(new FileReader("input.txt"));
		
		String num = in.readLine();
		num = new StringBuilder(num).reverse().toString();
		System.out.println(num);
		
	}

}
