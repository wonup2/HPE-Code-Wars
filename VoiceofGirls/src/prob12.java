import java.util.*;
import java.io.*;
public class prob12 {
	//static String file = "prob02";
	static Scanner in;
	//static PrintWriter out;
	static int[] a;
	public static void main(String[] args) throws IOException{
		in = new Scanner (new File("input.txt"));
		
		while(in.hasNext()){
			
			init();
			solve();
		}
	
		in.close(); 
			
	}
	static void init(){
		String[] temp = in.nextLine().split(" ");
		a = new int[temp.length];
		for(int i = 0; i < a.length; i++){
			a[i] = Integer.parseInt(temp[i]);
		}
		
	}
	static void solve(){
		double ans = 0.0;
		for(int i = 0; i < a.length; i++){
			if(i == 0){
				ans += a[i] * 91.44;
			}
			else if(i==1){
				ans += a[i] * 30.48;
			}
			else if(i==2){
				ans += a[i] * 2.54;
			}
		}
		double scale = Math.pow(10, 2);
		ans = (Math.round(ans*scale)/scale);
		
		String t = ""+ans;
		if(t.indexOf('.')!= t.length()-3){
			t+="0";
		}
		System.out.println(t);
	}

}
