import java.util.*;
import java.io.*;
import java.math.BigInteger;

public class prob28 {
	static Scanner in;
	static BigInteger[] num;
	static String ss;
	static double g = 0.0;
	public static void main(String[] args) throws IOException{
		in = new Scanner (new File("input.txt"));
		
		while(in.hasNextLine()){
			init();
			solve();
			//System.out.println("");
		}
		in.close();
	}
	static void init(){
		ss = in.nextLine().replace("-", "");
		String[] temp = ss.split(" ");
		
		num = new BigInteger[temp.length];
		Arrays.sort(temp);
		for(int i = 0; i < temp.length; i++){
			BigInteger reallyBig = new BigInteger(temp[i]);
			num[i] = reallyBig;
		}
		Arrays.sort(num);
		//System.out.println(Arrays.toString(num));
	}
	static void solve(){
		double gg = 10000000000.0;
		for(int i = 0; i < num.length-1; i++){
			if(num[i+1].intValue() >= num[i].intValue()) {
				g = (num[i+1].divide(num[i])).intValue();
			}
			if(g < gg) gg = g;
		}
		
		//System.out.println(gg);
		String gap = "";
		
		int geometric = 0;
		int exponential2 = 0;
		int exponential3 = 0;
		int fibonacci = 0;
		
		for(int i = 0; i < num.length; i++){
			//fibonacci
			if(i>=2&&num[i-2].add(num[i-1]).equals(num[i])){
				//System.out.println(num[i-2].intValue()+ "+"+num[i-1].intValue()+"="+num[i].intValue());
				fibonacci++;
			}
		}
		
		for(int i=0; i < num.length-1; i++){	
			
			//exponential
			if(num[i].multiply(num[i]).equals(num[i+1])){
				exponential2++;
			}
			if(num[i].pow(3).equals(num[i+1])){
				exponential3++;
			}
				
			//geometric
			//(num[i].doubleValue()/num[i+1].doubleValue())%g==0.0
			else if(num[i+1].doubleValue()/num[i].doubleValue()%gg==0.0){
				if(num[i+1].doubleValue()/num[i].doubleValue()==gg){
					geometric++;
					//System.out.println(num[i+1] + "/" + num[i] + "= " +gg);
				}
				else if(num[i].doubleValue()/num[i+1].doubleValue()==g){
					geometric++;
					//System.out.println(num[i+1] + "/" + num[i] + "= " +gg);
				}
				else{
					geometric++;
					gap= "(with Gaps)";
					//System.out.println("gap "+num[i+1] + "/" + num[i] + "= " +num[i+1].doubleValue()/num[i].doubleValue());
				}
			}
			
			
		}
		//System.out.println(geometric + " " + exponential2 + " " + exponential3+ " " +fibonacci);
		if(exponential2 == num.length-1) System.out.println("X^2");
		else if(exponential3 == num.length-1) System.out.println("X^3");
		else if(geometric == num.length-1) {
			if(gap.length()!=0){
				System.out.println("Geometric (with Gaps)");
			}
			else
			System.out.println("Geometric");
		}
		
		else if(fibonacci == num.length-2) System.out.println("Fibonacci");
		else System.out.println(ss+ " is an unknown series");
	}
}
