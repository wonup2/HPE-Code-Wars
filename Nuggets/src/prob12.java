import java.util.*;
import java.io.*;
public class prob12 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		Scanner in = new Scanner(new File("input.txt"));
		while(in.hasNextLine()) {
			String[] a = in.nextLine().split(" ");
			double total = 0;
			total += Integer.parseInt(a[0])*3*.3048*100;
			if(a.length >= 2) 
				total += Integer.parseInt(a[1])*.3048*100;
			if(a.length == 3)
				total += Integer.parseInt(a[2])*2.54;
			System.out.printf("%.2f", total);
			System.out.println();
		}
	}

}
