/*
 numver is odd ----> num/2 + 1
 num is even && numbit is even ---> num/2+1
 num is even && numbit is odd ----> num/2
 */

import java.util.*;
public class prob05_ParityGap {

	public static void main(String[] args) {

		Scanner in=new Scanner(System.in);
		while(true){
			long s=in.nextLong();
			long e=in.nextLong();
			if(s==0 && e==0) break;
			System.out.println(bitCount(s) +" "+ bitCount(e));	
			System.out.println(getCount(e) - getCount(s-1));		
		}
		in.close();
	}

	static int bitCount(long num) {
		int n = Long.toBinaryString(num).replace("0", "").length();
		return n;
	}
	
	static long getCount(long num) {
		if(num<0) return 0;
        if (num % 2 == 0) {
            return (num / 2) + (bitCount(num) % 2 == 0 ? 1 : 0);
        }
        return (num / 2) + 1;  //  + 1 because of 0
    }
}

/*
0 4  
0 10  
0 17  
5 10  
9 9  
867 5309  
123 100000000000  
314 159265  
0 0
*/
