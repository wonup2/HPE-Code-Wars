import java.util.*;
import java.io.*;
import java.text.DecimalFormat;

public class prob16 {

	public static void main(String[] args) throws IOException{

		BufferedReader in = new BufferedReader(new FileReader("input.txt"));
		
		String input = "";
		StringTokenizer st;
		DecimalFormat df = new DecimalFormat("0.0");
		while((input=in.readLine())!=null) {
			st = new StringTokenizer(input);
			double n1 = Double.parseDouble(st.nextToken());
			double n2 = Double.parseDouble(st.nextToken());
			String op = (st.nextToken()+"");
			double ans = Double.parseDouble(st.nextToken());
			String answer = df.format(ans);
			
			if(op.equals("POWER")) {
				double tempans = Math.pow(n1, n2);
				if(answer.equals(df.format(tempans))) {
					System.out.println(df.format(ans)+ " is correct for "+n1+" ^ "+n2);
				}
				else {
					System.out.println(n1+" ^ " + n2+" = "+df.format(tempans)+", not " + df.format(ans));
				}
			}
			
			
			else if(op.equals("MULTIPLY")) {
				double tempans = n1*n2;
				if(answer.equals(df.format(tempans))) {
					System.out.println(df.format(ans)+ " is correct for "+n1+" * "+n2);
				}
				else {
					System.out.println(n1+" * " + n2+" = "+df.format(tempans)+", not " + df.format(ans));
				}
			}
			
			
			else if(op.equals("DIVIDE")) {
				double tempans = n1/n2;
				if(answer.equals(df.format(tempans))) {
					System.out.println(df.format(ans)+ " is correct for "+n1+" / "+n2);
				}
				else {
					System.out.println(n1+" / " + n2+" = "+df.format(tempans)+", not " + df.format(ans));
				}
			}
			
			
			else if(op.equals("ADD")) {
				double tempans = n1+n2;
				if(answer.equals(df.format(tempans))) {
					System.out.println(df.format(ans)+ " is correct for "+n1+" + "+n2);
				}
				else {
					System.out.println(n1+" + " + n2+" = "+df.format(tempans)+", not " + df.format(ans));
				}
			}
			
			
			else if(op.equals("SUBTRACT")) {
				double tempans = n1-n2;
				if(answer.equals(df.format(tempans))) {
					System.out.println(df.format(ans)+ " is correct for "+n1+" - "+n2);
				}
				else {
					System.out.println(n1+" - " + n2+" = "+df.format(tempans)+", not " + df.format(ans));
				}
			}
			
			
		}
		
	}

}
