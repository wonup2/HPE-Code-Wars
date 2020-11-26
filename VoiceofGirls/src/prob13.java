import java.io.*;
import java.util.*;
public class prob13 {
	static Scanner in;
	static int cash;
	static int N;
	static boolean[] b;
	static ArrayList<String> item;
	static ArrayList<Integer> cost;
	public static void main(String[] args) throws IOException {
		in = new Scanner (new File("input.txt"));
		cash = in.nextInt();
		N = in.nextInt();
		item = new ArrayList<String>();
		cost = new ArrayList<Integer>();
		for(int i = 0; i < N; i++){
			
			init();
			
		}
		solve();
		in.close(); 
	}
	static void init(){
		
		item.add(in.next());
		cost.add(in.nextInt());
		//System.out.println(item + " " + cost);
	}
	static void solve(){
		b = new boolean[N];
		int count = 0;
		//System.out.println(Arrays.toString(b));
		
		for(int i = 0; i < N; i++){
			
			if(cash - cost.get(i) >=0){
				b[i] = true;
				cash = cash-cost.get(i);
			}
			else b[i] = false;
		}
		
		for(int i = 0; i < N; i++){
			if(b[i] == true){
				System.out.println("I can afford " + item.get(i));
			}
			else{
				count++;
				System.out.println("I can't afford " + item.get(i));
			}
		}
		if(count == N){
			System.out.println("I need more Yen!");
		}
		System.out.println(cash);
	}
}
