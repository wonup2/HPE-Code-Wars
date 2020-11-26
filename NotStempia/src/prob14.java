import java.util.*;
import java.io.*;

public class prob14 {

	public static void main(String[] args) throws IOException{

		BufferedReader in = new BufferedReader(new FileReader("input.txt"));
		
		int n1 = Integer.parseInt(in.readLine());
		int n2 = Integer.parseInt(in.readLine());
		ArrayList<Integer> nums = new ArrayList<Integer>();
		
		for(int i = n1; i < n2; i++) {
			if((i+"").length()<2) continue;
			int evensum = 0;
			int oddsum = 0;
			String num = new StringBuilder(i+"").reverse().toString();
			for(int j = 0; j < num.length(); j++) {
				if(j%2==0) evensum+=num.charAt(j)-'0';
				else if(j%2==1) oddsum+=num.charAt(j)-'0';
			}
			if(evensum==oddsum) nums.add(i);
		}
		if(nums.size()==0) System.out.println("No Numbers found with Equal Sum in the given range!!");
		for(int i = 0; i < nums.size(); i++) {
			System.out.print(nums.get(i)+" ");
		}
		
	}

}
