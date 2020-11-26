import java.util.*;
import java.io.*;
public class prob15 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		Scanner in = new Scanner(new File("input.txt"));
		 while(true) {
			 int a = in.nextInt();
			 int b = in.nextInt();
			 if(a == 0 && b == 0)
				 break;
			 in.nextLine();
			 String first = in.nextLine();
			 String second = in.nextLine();
			 String[] x = first.toLowerCase().split(" ");
			 String[] y = second.toLowerCase().split(" ");
			 String check = " ";
			 int count = 0;
			 for(int i = 0; i < x.length; i++) {
				 for(int j = 0; j < y.length; j++) {
					 if(!check.contains(x[i]) && x[i].equals(y[j])) {
						 count++;
						 check += x[i] + " ";
					 }
				 }
			 }
			 System.out.println(first);
			 System.out.println(second);
			 System.out.println(count + check);
		 }
	}

}
