
import java.util.*;
import java.io.*;
public class prob11 {
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(new File("input.txt"));
		while (in.hasNextInt()) {
			int num = in.nextInt();
		    String binary = Integer.toBinaryString(num);
		    int zero = 0;
		    for(int i = 0; i < binary.length(); i++) {
		    		if(binary.charAt(i) == '0') {
		    			zero++;
		    		}
		    }
		    if(zero != 1) {
		    		System.out.println(num + " no");
		    		continue;
		    }
		    if(binary.length() %2 == 0 ){
		    		System.out.println(num + " no");
		    }
		    else if(binary.charAt(binary.length()/2) == '0') {
		    		System.out.println(num + " yes");
		    }else {
		    		System.out.println(num + " no");
		    		continue;
		    }
		    
		}
		
	}
}
