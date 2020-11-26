import java.io.*;
import java.util.*;
public class prob23 {
	static Scanner in;
	static int N;
	static String[] s;
	static int[] len;
	public static void main(String[] args) throws IOException{
		in = new Scanner (new File("input.txt"));
		N = in.nextInt();in.nextLine();
		
		for(int i = 0; i < N; i++){
			init();
			solve();
			//System.out.println();
		}
		in.close();
	}
	static void init(){
		String temp = in.nextLine().toLowerCase();
		String a = "";
		for(int i = 0; i < temp.length(); i++){
			if((temp.charAt(i)-'a' <=26 && temp.charAt(i)-'a'>=0)||temp.charAt(i)==' '){
				a+=""+temp.charAt(i);
			}
		}
		s = a.split(" ");
		int[] len = new int[s.length];
		for(int i = 0; i < s.length; i++){
			len[i] = s[i].length();
		}
		//System.out.println(Arrays.toString(s));
	}
	static void solve(){
		for(int i = 0; i < s.length; i++){
			System.out.print(s[i]+" ");
		}
		String temp = "";
		for(int i = 0; i < s.length; i++){
			temp+=s[i];
		}
		boolean check = true;
		String hold = "";
		for(int i = 0; i < temp.length(); i++){
				char c = temp.charAt(i);
				//a/e, b/q, d/p, h/y, m/w, and n/u o, s, x, and z
				if(c=='a'||c=='e'||c=='b'||c=='q'||c=='d'||c=='p'||c=='h'||c=='y'||c=='m'||c=='w'||c=='n'||c=='u'||c=='o'||c=='s'||c=='x'||c=='z'){
					if(c=='a') hold = "e"+hold;
					else if(c=='e') hold = "a"+hold;
					else if(c=='b') hold="q"+hold;
					else if(c=='q') hold="b"+hold;
					else if(c=='d') hold="p"+hold;
					else if(c=='p') hold="d"+hold;
					else if(c=='y') hold="h"+hold;
					else if(c=='h') hold="y"+hold;
					else if(c=='m') hold="w"+hold;
					else if(c=='w') hold= "m"+hold;
					else if(c=='n') hold="u"+hold;
					else if(c=='u') hold="n"+hold;
					else{
						hold = c+hold;
					}
				}
				else{
					check = false;
					//System.out.println(" " + c);
					
				}
				//System.out.println(" " + hold);
		}
		//System.out.println(temp + " " + hold);
		
		
		if(check = false) System.out.println("(not)");
		
		else if(temp.equals(hold)) System.out.println("(is)");
		
		else System.out.println("(not)");
	}
}
