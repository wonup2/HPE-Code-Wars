
import java.util.*;
import java.io.*;
public class prob28 {
	static boolean same = true;
	public static void main(String[] args) throws IOException{
		Scanner in = new Scanner(new File("input.txt"));
		while(in.hasNext()) {
			String line = in.nextLine();
			String[] temp = line.split(" ");
			long[] num = new long[temp.length];
			for(int i = 0; i < temp.length;i++) {
				num[i] = Long.parseLong(temp[i]);
			}
			if(fib(num)) {
				System.out.println("Fibonacci");
			}else if(ex2(num)) {
				System.out.println("X^2");
			}else if(ex3(num)){
				System.out.println("X^3");
			}else if(geo(num)) {
				if(same == false) {
					System.out.println("Geometric (With Gaps)");
				}else
					System.out.println("Geometric");
			}else {
				for(int i = 0; i < num.length; i++) {
					System.out.print(num[i] + " ");
				}
				System.out.println("is an Unknown series");
			}
		}
	}
	public static boolean fib(long[] num) {
		long a= num[0];
		long b = num[1];
		for(int i = 2; i < num.length; i++) {
			if(a+b != num[i]) {
				return false;
			}
			a = num[i-1];
			b = num[i];
		}
		return true;
	}
	public static boolean ex2(long[] num) {
		for(int i = 1; i < num.length; i++) {
			if(num[i] % num[i-1] != 0 || num[i] / num[i-1]!= num[i-1]) {
				return false;
			}
		}
		return true;
	}
	public static boolean ex3(long[] num) {
		for(int i = 1; i < num.length; i++) {
			if(num[i] % num[i-1] != 0 || num[i] / num[i-1]!= num[i-1]*num[i-1]) {
				return false;
			}
		}
		return true;
	}
	public static boolean geo(long[]num) {
		boolean increase = false;
		boolean decrease = false;
		for(int i = 1; i < num.length; i++) {
			if(num[i] < num[i-1]) {
				decrease = true;
			}else if(num[i] > num[i-1]){
				increase = true;
			}else if(num[i] == num[i-1]) {
				if(increase == true || decrease == true) {
					return false;
				}
			}
		}
		if((increase && decrease)) {
			return false;
		}
		if(increase == false && decrease == false) {
			return true;
		}
		long[] div = new long[num.length-1];
		for(int i = 0; i < num.length-1; i++) {
			if(decrease == true) {
				if(num[i]%num[i+1] !=0) {
					return false;
				}
				div[i] = num[i]/num[i+1];
			}
			else {
				if(num[i+1]% num[i] !=0) {
					return false;
				}
				div[i] = num[i+1]/num[i];
			}
				
		}
		Arrays.sort(div);
		for(int i = div.length-1 ; i>0; i--) {
			if(div[i]%div[i-1] != 0) {
				return false;
			}
		}
		same = true;
		for(int i = 0; i < div.length-1; i++) {
			if(div[i] != div[i+1]) {
				same = false;
			}
		}
		
		// prime factorization is wrong 1 18 5832
		if(!primeFactors(div)) {
			return false;
		}
		return true;
		
	}
	public static boolean primeFactors(long[] div) 
    { 
		
        Map<Long, Integer> counts = new HashMap<Long,Integer>();
		ArrayList<p>[] prime = new ArrayList[div.length];
		long gcf = 0;
        for(int i = 0; i < div.length; i++) {
        		prime[i] = new ArrayList<p>();
        		long n = div[i];
        		long temp = n;
        		ArrayList<Long> num = new ArrayList<Long>();
        		int count = 0;
        		
            while (n%2==0) 
            {  
                n /= 2; 
                count++;
            } 
            if(count > 0) {
            		prime[i].add(new p (2,count));
            		if(i ==0)
            			counts.put(2L, count);
            		if(i == 0) {
            			gcf = count;
            		}
            		
            }
            for (int j = 3; j <= (temp); j+= 2) 
            { 
            	 	int count2= 0;
                while (n%j == 0) 
                { 
                    n /= j; 
                    count2++;
                } 
               if(count2 > 0) {
            	   		prime[i].add(new p(j,count2));
            	   		if(i == 0)
            	   			counts.put((long)j, count2);
            	   		if(gcf>0) {
            	   			if( i == 0) {
            	   				gcf = gcd(gcf,(long)count2);
            	   			}
            	   			
            	   		}else {
            	   			if(i == 0)
            	   				gcf = count2;
            	   		}
               }
            } 
        }
        for(Long key: counts.keySet()) {
        		counts.replace(key, (int)(counts.get(key) / gcf));
        }
        for(int i = 0; i < div.length; i++) {
        		if(!counts.containsKey(prime[i].get(0).factor)) {
        			System.out.println(prime[i].get(0).factor);
        			return false;
        		}
        		if(prime[i].get(0).count % counts.get(prime[i].get(0).factor) != 0) {
        			return false;
        		}
        		long mul =prime[i].get(0).count /counts.get(prime[i].get(0).factor);
        		for(int j = 1; j < prime[i].size(); j++) {
        			if(!counts.containsKey(prime[i].get(j).factor)) {
            			return false;
            		}
        			if(counts.get(prime[i].get(j).factor) * mul != prime[i].get(j).count) {
        				return false;
        			}
        		}
        }
        
		
        return true;
    } 
	public static long gcd(long a, long b) 
    { 
        // Everything divides 0  
        if (a == 0) 
          return b; 
        if (b == 0) 
          return a; 
       
        // base case 
        if (a == b) 
            return a; 
       
        // a is greater 
        if (a > b) 
            return gcd(a-b, b); 
        return gcd(a, b-a); 
    } 
	static class p{
		long factor;
		long count;
		public p(int f, int c) {
			factor= f;
			count = c;
		}
	}
}
