import java.util.*;
import java.io.*;
public class Q30_data {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		PrintWriter out = new PrintWriter(new File("prob30.out"));

		for(int i=1; i<=8; i++) {
			Scanner in = new Scanner(new File("prob30-"+i+"-in.txt"));
			while(in.hasNextLine()) {
				String s = in.nextLine();
				String result = s.charAt(0)=='?'? " ":s.charAt(0)+"";

				for(int k=1; k<s.length(); k++) {
					char c= s.charAt(k)=='?'? ' ':s.charAt(k);
					result+=","+ c;
				}
				out.println(result+"\n");
			}
			in.close();
		}	
		out.close();

	}

}
