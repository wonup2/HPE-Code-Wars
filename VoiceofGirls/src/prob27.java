import java.io.*;
import java.util.*;

public class prob27 {
	static Scanner in;
	static int n;
	static String[] s;
	public static void main(String[] args) throws IOException{
		in = new Scanner (new File("input.txt"));
		
		while(in.hasNextLine()){
			init();
			if(n==0) break;
			solve();
			System.out.println("");
		}
		
		in.close();
	}
	static void init(){
		n = in.nextInt();
		if(n==0) return;
		String temp=in.nextLine();
		temp = temp.substring(1);
		s = temp.split(" ");
		//System.out.println(n+" " + Arrays.toString(s));
	}
	static void solve(){
		System.out.print(s[0]);
		for(int i = 1; i < n; i++){
			System.out.print(" " + s[i]);
		}
		// COPY, RHYMING, SHM, ABLAUT, or PROGRESSIVE.
		
		//copy
		int copy = 0;
		for(int i = 0; i < n-1; i++){
			if(s[i].equals(s[i+1])) copy++;
		}
		if(copy==n-1){
			System.out.print(" COPY");
			return;
		}
		//SMH
				if(s[0].length()!=s[1].length()){
					char temp = s[0].charAt(0);
					if(temp!='A'&&temp!='E'&&temp!='I'&&temp!='O'&&temp!='U'){
						s[0] = s[0].substring(1);
					}
					if(("SHM"+s[0]).equals(s[1])){
						System.out.print(" SHM");
						return;
					}
				}
		//rhyming
		ArrayList<String> vowels = new ArrayList<String>();
		int[] cons = new int[26];
		for(int i = 0; i < n; i++){
			for(int j = 0; j < s[i].length(); j++){
				char temp = s[i].charAt(j);
				//System.out.println(temp-'A');
				//System.out.println(temp);
				if(temp=='A'||temp=='E'||temp=='I'||temp=='O'||temp=='U'){
					//System.out.println(temp);
					vowels.add(""+temp);
				}
				else{
					cons[temp-'A']++;
				}
			}
			
		}
		boolean check = false;
		//System.out.println((vowels));
		for(int i = 0; i < vowels.size()-1; i++){
			if(vowels.get(i).equals(vowels.get(i+1))) check = true;
			else {
				check = false;
				break;
			}
			
		}
		for(int i = 0; i < vowels.size()-(vowels.size()/2); i++){
			if(vowels.get(i).equals(vowels.get(i+(vowels.size()/2)))) check = true;
			else{
				check = false;
				break;
			}
		}
		boolean checks = false;
		for(int i = 0; i < cons.length-1; i++){
			if(cons[i]==cons[i+1] || cons[i]==0 || cons[i+1]==0){
				checks = true;
			}
			else checks = false;
		}
		if(check == true && checks == true){
			System.out.print(" RHYMING");
			return;
		}
		//rhyming2
		if(Math.abs(s[0].length()-s[1].length())==1){
			int t = 0;
			if(Math.max(s[0].length(), s[1].length())==s[0].length()){
				if(s[0].substring(1).equals(s[1])){
					System.out.print(" RHYMING");
					return;
				}
				else{
					System.out.print(" RHYMING");
					return;
				}
			}
		}
		//rhyming3
		if(s[0].length()==s[1].length()){
			if(s[0].substring(1).equals(s[1].substring(1))){
				System.out.print(" RHYIMG");
				return;
			}
			
		}
		//rhyming5
		
		
		
		//PROGRESSIVE & ABLAUT  I, A, E, O, U
		boolean checked = false;
		String[] order = {"I","A","E","O","U"};
		if(s[0].length()==s[1].length()){
			int len = s[0].length();
			int diff = 0;
			for(int i = 0; i < len; i++){
				if(s[0].charAt(i)!=s[1].charAt(i)){
					diff++;
					for(int j = 0; j < order.length; j++){
						for(int k = 0; k < order.length; k++){
							if((""+s[0].charAt(i)).equals(order[j])&&(""+s[1].charAt(i)).equals(order[k])&&j<k){
								//System.out.print(" "+diff);
								checked=true;
							}
						}
					}
				}
			}
			if(diff == 1){
				if(checked == true){
					System.out.print(" PROGRESSIVE");
					return;
				}
				else{
					System.out.print(" ABLAUT");
					return;
				}
			}
		}
		//rhyming4
		boolean check4 = false;
		for(int i = 0; i < n-1; i++){
			if(s[i].charAt(s[i].length()-1)==s[i+1].charAt(s[i+1].length()-1)){
				check4 = true;
			}
			else{
				check4 = false;
				break;
			}
		}
		if(check4 = true){
			System.out.print(" RHYMING");
			return;
		}
	}

}
