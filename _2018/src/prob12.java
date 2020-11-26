import java.util.*;
import java.io.*;

public class prob12{

    static String file = "prob12";
    static Scanner in;
    static PrintWriter out;
    static int pastNum, currNum;
    static int[][] pastCases, currCases; 
    static String[] pastOg, currOg;
    
    public static void main(String[] args)throws IOException{
        for(int i = 1; i <= 2; i++) {
            in = new Scanner(System.in);
            out = new PrintWriter(new File("out.txt"));
            
            init();
            solve();
            
            in.close();
            out.close();
            
            System.out.println(i);
            //Check.check("out.txt", file+"-"+i+"-out.txt");
        }
    }
    
    public static void init() {
    	
        pastNum = Integer.parseInt(in.nextLine());
        pastCases = new int[pastNum][26];
        pastOg = new String[pastNum];
        
        for (int i = 0; i < pastNum; i++) {
        	pastCases[i] = new int[26];
        }
        
        for (int i = 0; i < pastNum; i++) {
        	pastOg[i] = in.nextLine();
        }
        
        for (int i = 0; i < pastNum; i++) {
        	String temp = pastOg[i];
        	for (int j = 0; j < temp.length(); j++) {
        		if (temp.charAt(j) == ' ')
        			continue;
        		int pos = temp.charAt(j) - 'A';
        		pastCases[i][pos]++;
        	}
        }
        
        currNum = Integer.parseInt(in.nextLine());
        currCases = new int[currNum][26];
        currOg = new String[currNum];
        
        for (int i = 0; i < currNum; i++) {
        	currCases[i] = new int[26];
        }
        
        for (int i = 0; i < currNum; i++) {
        	currOg[i] = in.nextLine();
        }
        
        for (int i = 0; i < currNum; i++) {
        	String temp = currOg[i];
        	for (int j = 0; j < temp.length(); j++) {
        		if (temp.charAt(j) == ' ')
        			continue;
        		int pos = temp.charAt(j) - 'A';
        		currCases[i][pos]++;
        	}
        }

    }
    
    public static void solve() {
    	ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < currNum; i++) {
        	boolean anagram = false;
        	for (int j = 0; j < pastNum; j++) {
        		if (checkSame(currCases[i], pastCases[j])) {
        			anagram = true;
        			list.add(pastOg[j]);
        		}
        	}
        	if (!anagram)
        		System.out.println("No: No matching case");
        	else {
        		Collections.sort(list);
        		System.out.println("Yes: " + list.get(0));
        	}
        	list.clear();
        }
    }
    
    public static boolean checkSame(int[] x, int[] y) {
    	for (int i = 0; i < x.length; i++) {
    		if (x[i] == y[i])
    			continue;
    		else
    			return false;
    	}
    	return true;
    }
}