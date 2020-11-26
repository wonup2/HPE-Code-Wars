import java.util.*;
import java.io.*;
public class prob16 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		Scanner in = new Scanner(new File("input.txt"));
		while(in.hasNextLine()) {
			double a = in.nextDouble();
			double b = in.nextDouble();
			String op = in.next();
			double myans = 0;
			String sign = "";
			double ans = in.nextDouble();
			if(op.equals("ADD")) {
				myans = a+b;
				sign = "+";
			}
			else if(op.equals("SUBTRACT")) {
				myans = a-b;
				sign = "-";
			}
			else if(op.equals("MULTIPLY")) {
				myans = a*b;
				sign = "*";
			}
			else if(op.equals("DIVIDE")) {
				myans = a/b;
				sign = "/";
			}
			else {
				myans = Math.pow(a, b);
				sign = "^";
			}
				
			myans = Math.round(myans*10)/10.0;
			if(myans == ans)
				System.out.println(ans + " is correct for " + a + " " + sign + " " + b);
			else
				System.out.println(a + " " + sign + " " + b + " = " + myans + ", not " + ans);
		}
	}

}
