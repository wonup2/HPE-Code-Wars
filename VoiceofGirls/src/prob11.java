import java.io.*;
import java.util.*;

public class prob11 {
	//static String file = "prob02";
	static Scanner in;
	//static PrintWriter out;
	static int N;
	static String bin;
	
	
	public static void main(String[] args) throws IOException {
			in = new Scanner (new File("input.txt"));
			
			while(in.hasNext()){
				
				init();
				//System.out.print(j+1 + ": ");
				System.out.print(N+" ");
				solve();
			}
		
			in.close(); 
				
	}
	static void init(){
		N = in.nextInt();
		bin = Integer.toBinaryString(N);
		//System.out.println(bin);
	}
	static void solve(){
		int count = 0;
		int index = 0;
		String ans = "";
		for(int i = 0; i < bin.length(); i++){
			if(bin.charAt(i) == '0') count++;
		}
		if(count>1){
			ans = "no";
		}
		else if(count==1){
			int temp = bin.length()/2;
			index = bin.indexOf('0');
			if(temp == index){
				ans = "yes";
			}
			//System.out.println(temp +  " " + index);
		}
		System.out.println(ans);
	}

}
/*
304
90211
27
730193
130815
119
987654321
*/
