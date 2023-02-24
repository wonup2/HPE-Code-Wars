import java.util.*;
import java.io.*;
public class prob30 {

	public static void main(String[] args) throws IOException {

		Scanner in = new Scanner(new File("input.txt"));
		int count=0;
		while(in.hasNextLine()) {
			String s = in.nextLine();
			if(s==null) break;
			for(int i=0; i<s.length(); i++) {
				if(s.charAt(i)=='.') count++;
			}
		}
		System.out.println(count+" "+count*2);
	}

}