import java.util.*;
import java.io.*;

public class prob05 {

	public static void main(String[] args) throws IOException{

		BufferedReader in = new BufferedReader(new FileReader("input.txt"));
		
		int n = Integer.parseInt(in.readLine());
		boolean notprime = false;
		
		if(n==1){
			System.out.println(n+ " is NOT Prime");
		}
		else{
			
			for(int i = 2; i*i <= n; i++) {
				if(n%i==0) {
					notprime = true;
					break;
				}
			
			}
			if(!notprime) System.out.println(n+ " is PRIME");
			else if(notprime) System.out.println(n+ " is NOT Prime");
		}
	}

}
