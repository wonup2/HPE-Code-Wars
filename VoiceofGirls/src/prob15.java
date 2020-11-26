import java.util.*;
import java.io.*;

public class prob15 {
	static Scanner in;
	static int N;
	static int M;
	static String[] s1;
	static String[]s2;
	
	public static void main(String[] args) throws IOException{
		in = new Scanner (new File("input.txt"));
		N=1;
		M=1;
		
	
		while(in.hasNextLine()){
			init();
			solve();
		}
	
		in.close(); 

	}
	static void init(){
		N = in.nextInt();
		M = in.nextInt();in.nextLine();
		if(N==0 && M==0) return;
		s1 = in.nextLine().toLowerCase().split(" ");
		s2 = in.nextLine().toLowerCase().split(" ");
		
		
		
		//System.out.println(N+" " + M);
		//System.out.println(Arrays.toString(s1));
		//System.out.println(Arrays.toString(s2));
		
		
	}
	static void solve(){
		if(N==0 && M==0) return;
		String temp = "";
		String ans = "";
		int count = 0;
		
		System.out.print(s1[0]);
		for(int i = 1; i < N;i++){
			System.out.print(" "+s1[i]);
		}
		System.out.println("");
		System.out.print(s2[0]);
		for(int i = 1; i < M; i++){
			System.out.print(" " + s2[i]);
		}
		System.out.println("");
		
		ArrayList<String> check = new ArrayList<String>();
		
		if(N<=M){
			for(int i = 0; i < N; i++){
				temp = s1[i].toLowerCase();
				for(int j = 0; j < M; j++){
					if(temp.equals(s2[j].toLowerCase())){
						if(!check.contains(temp)){
							count++;
							ans += temp+ " ";
							check.add(temp);
							//System.out.println(temp);
						}
						
						
					}
				}
			}
			
		}
		else if(M<N){
			for(int i = 0; i < M; i++){
				temp = s2[i].toLowerCase();
				for(int j = 0; j < N; j++){
					if(temp.equals(s1[j].toLowerCase())){
						if(!check.contains(temp)){
							count++;
							ans += temp+ " ";
							check.add(temp);
							//System.out.println(temp);
						}
						
					}
				}
			}
		}
		
		System.out.println(count + " " + ans.substring(0,ans.length()-1));
		
	}

}
