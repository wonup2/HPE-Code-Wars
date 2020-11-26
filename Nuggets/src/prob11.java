import java.util.*;
import java.io.*;
public class prob11 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		Scanner in = new Scanner(new File("input.txt"));
		while(in.hasNextLine()) {
			int n = in.nextInt();
			String temp = Integer.toBinaryString(n);
			int c = 0;
			for(int i = 0; i < temp.length(); i++) {
				if(temp.charAt(i) == '0')
					c++;
			}
			if(c != 1 || temp.length() % 2 == 0)
				System.out.println(n + " no");
			else {
				if(temp.charAt(temp.length()/2) == '0')
					System.out.println(n + " yes");
			}
		}
	}

}
