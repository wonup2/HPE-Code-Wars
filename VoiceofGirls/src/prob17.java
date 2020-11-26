import java.io.*;
import java.util.*;
public class prob17 {
	
	static Scanner in;
	static int n;
	static boolean[][] ary;
	static LinkedHashMap<String, Integer> map = new LinkedHashMap<String, Integer>();
	static LinkedHashMap<Integer, String> findX = new LinkedHashMap<Integer, String>();
	
	public static void main(String[] args) {
		
		try {
			in = new Scanner(new File("input.txt"));
			
			init();
			solve();
			
			in.close();
		}catch(Exception e) {
			e.printStackTrace();
		}

	}
	
	private static void init() {
		n = in.nextInt();
		in.nextLine();
		ary = new boolean[n][n];
		
		for(int i =0; i < n; i++) {
			String t = in.nextLine();
			map.put(t, i);
			findX.put(i, t);
		}
		
		while(in.hasNextLine()) {
			String[] temp = in.nextLine().split(" ");
			//System.out.println(Arrays.toString(temp));
			if(temp[8].equals("air"))
				continue;
			else {
				ary[map.get(temp[1])][map.get(temp[6])] = true;
				ary[map.get(temp[6])][map.get(temp[1])] = true;
			}
		}
		/*
		for(int i =0; i < n; i++) {
			System.out.println(Arrays.toString(ary[i]));
		}
		*/
	}
	
	private static void solve() {
		
		for(int i =0; i < n; i++) {
			for(int j =0; j < n; j++) {
				if(i==j) continue;
				if(ary[i][j] == true) continue;
				
				for(int k =0; k < n; k++) {
					if(ary[i][k] == true && ary[j][k]==true) {
						ary[i][j] = true;
						break;
					}
				}
				
			}
		}
		//City X is neighbour to Cities Y,Z,B
		//City A is remote and has no neighbours!
		for(int i =0; i < n; i++) {
			String ans = "City " + findX.get(i) + " is neighbour to Cities ";
			for(int j =0; j < n; j++) {
				if(ary[i][j] == true) {
					ans += findX.get(j) + ",";
				}
			}
			if(ans.length() == 30)
				System.out.println("City " + findX.get(i) + " is remote and has no neighbours!");
			else
				System.out.println(ans.substring(0,ans.length()-1));
		}
		
	
	}

}
