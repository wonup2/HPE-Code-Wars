import java.util.*;
import java.io.*;

public class prob06 {
	
	static String ans;
	
	public static void main(String[] args) throws IOException{

		BufferedReader in = new BufferedReader(new FileReader("input.txt"));
		
		String input;
		while((input=in.readLine())!=null) {
			ans = "";
			if(input.length()==4) {
				ans+="R";
				hundreds(input, 1);
				tens(input, 2);
				ones(input, 3);
			}
			else if(input.length()==3) {
				hundreds(input, 0);
				tens(input, 1);
				ones(input, 2);
			}
			else if(input.length()==2) {
				tens(input, 0);
				ones(input, 1);
			}
			else if(input.length()==1) {
				ones(input, 0);
			}
			System.out.println(ans);
			
		}
		
	}
	
	public static void hundreds(String n, int ind) {
		if((n.charAt(ind)+"").equals("1")) {
			ans+="B";
		}
		else if((n.charAt(ind)+"").equals("2")) {
			ans+="BB";
		}
		else if((n.charAt(ind)+"").equals("3")) {
			ans+="BBB";
		}
		else if((n.charAt(ind)+"").equals("4")) {
			ans+="BG";
		}
		else if((n.charAt(ind)+"").equals("5")) {
			ans+="G";
		}
		else if((n.charAt(ind)+"").equals("6")) {
			ans+="GB";
		}
		else if((n.charAt(ind)+"").equals("7")) {
			ans+="GBB";
		}
		else if((n.charAt(ind)+"").equals("8")) {
			ans+="GBBB";
		}
		else if((n.charAt(ind)+"").equals("9")) {
			ans+="BR";
		}
	}
	public static void tens(String n, int ind) {
		if((n.charAt(ind)+"").equals("1")) {
			ans+="Z";
		}
		else if((n.charAt(ind)+"").equals("2")) {
			ans+="ZZ";
		}
		else if((n.charAt(ind)+"").equals("3")) {
			ans+="ZZZ";
		}
		else if((n.charAt(ind)+"").equals("4")) {
			ans+="ZP";
		}
		else if((n.charAt(ind)+"").equals("5")) {
			ans+="P";
		}
		else if((n.charAt(ind)+"").equals("6")) {
			ans+="PZ";
		}
		else if((n.charAt(ind)+"").equals("7")) {
			ans+="PZZ";
		}
		else if((n.charAt(ind)+"").equals("8")) {
			ans+="PZZZ";
		}
		else if((n.charAt(ind)+"").equals("9")) {
			ans+="ZB";
		}
	}
	public static void ones(String n, int ind) {
		if((n.charAt(ind)+"").equals("1")) {
			ans+="B";
		}
		else if((n.charAt(ind)+"").equals("2")) {
			ans+="BB";
		}
		else if((n.charAt(ind)+"").equals("3")) {
			ans+="BBB";
		}
		else if((n.charAt(ind)+"").equals("4")) {
			ans+="BW";
		}
		else if((n.charAt(ind)+"").equals("5")) {
			ans+="W";
		}
		else if((n.charAt(ind)+"").equals("6")) {
			ans+="WB";
		}
		else if((n.charAt(ind)+"").equals("7")) {
			ans+="WBB";
		}
		else if((n.charAt(ind)+"").equals("8")) {
			ans+="WBBB";
		}
		else if((n.charAt(ind)+"").equals("9")) {
			ans+="BK";
		}
	}

}
