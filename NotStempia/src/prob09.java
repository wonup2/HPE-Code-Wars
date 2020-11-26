import java.util.*;
import java.io.*;
import java.text.*;

public class prob09 {

	public static void main(String[] args) throws IOException, ParseException{

		BufferedReader in = new BufferedReader(new FileReader("input.txt"));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int maxhold = 3000;
		
		while(n!=0||m!=0) {
			int sum = n*60+m;
			int diff = maxhold-sum;
			if(sum>maxhold) {
				System.out.println("Time remaining " + (int)diff/60 + " minutes and " + (diff%3600)%60 + " seconds (we're gonna need a bigger record)");
			}
			else if(sum>maxhold/2) {
				System.out.println("Time remaining " + (diff%3600)/60 + " minutes and " + (diff%3600)%60 + " seconds (we'll need both sides)");
			}
			else {
				System.out.println("Time remaining " + (diff%3600)/60 + " minutes and " + (diff%3600)%60 + " seconds");
			}
			
			st = new StringTokenizer(in.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
		}
				
		
	}

}
