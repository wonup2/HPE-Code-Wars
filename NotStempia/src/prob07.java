import java.util.*;
import java.io.*;

public class prob07 {

	public static void main(String[] args) throws IOException{

		BufferedReader in = new BufferedReader(new FileReader("input.txt"));
		
		String input;
		StringTokenizer st;
		while((input=in.readLine())!=null) {
			st = new StringTokenizer(input);
			String c1 = (st.nextToken()+"");
			String c2 = (st.nextToken()+"");
			String result = "";
			
			if(c1.equals("RED")) {
				if(c2.equals("YELLOW")) {
					result = "ORANGE";
				}
				else if(c2.equals("RED")) {
					result = "RED";
				}
				else if(c2.equals("BLUE")) {
					result = "PURPLE";
				}
				else if(c2.equals("BLACK")) {
					result = "DARK RED";
				}
				else if(c2.equals("WHITE")) {
					result = "LIGHT RED";
				}
			}
			else if(c1.equals("BLUE")) {
				if(c2.equals("RED")) {
					result = "PURPLE";
				}
				else if(c2.equals("BLUE")) {
					result = "BLUE";
				}
				else if(c2.equals("YELLOW")) {
					result = "GREEN";
				}
				else if(c2.equals("BLACK")) {
					result = "DARK BLUE";
				}
				else if(c2.equals("WHITE")) {
					result = "LIGHT BLUE";
				}
			}
			else if(c1.equals("YELLOW")) {
				if(c2.equals("RED")) {
					result = "ORANGE";
				}
				else if(c2.equals("BLUE")) {
					result = "GREEN";
				}
				else if(c2.equals("YELLOW")) {
					result = "YELLOW";
				}
				else if(c2.equals("BLACK")) {
					result = "DARK YELLOW";
				}
				else if(c2.equals("WHITE")) {
					result = "LIGHT YELLOW";
				}
			}
			else if(c1.equals("PURPLE")) {
				
				if(c2.equals("BLACK")) {
					result = "DARK PURPLE";
				}
				else if(c2.equals("WHITE")) {
					result = "LIGHT PURPLE";
				}
			}
			else if(c1.equals("GREEN")) {
				
				if(c2.equals("BLACK")) {
					result = "DARK GREEN";
				}
				else if(c2.equals("WHITE")) {
					result = "LIGHT GREEN";
				}
			}
			else if(c1.equals("ORANGE")) {
				
				if(c2.equals("BLACK")) {
					result = "DARK ORANGE";
				}
				else if(c2.equals("WHITE")) {
					result = "LIGHT ORANGE";
				}
			}
			else if(c1.equals("WHITE")) {
				
				if(c2.equals("RED")) {
					result = "LIGHT RED";
				}
				else if(c2.equals("PURPLE")) {
					result = "LIGHT PURPLE";
				}
				else if(c2.equals("BLUE")) {
					result = "LIGHT BLUE";
				}
				else if(c2.equals("GREEN")) {
					result = "LIGHT GREEN";
				}
				else if(c2.equals("YELLOW")) {
					result = "LIGHT YELLOW";
				}
				else if(c2.equals("ORANGE")) {
					result = "LIGHT ORANGE";
				}
				else if(c2.equals("WHITE")) {
					result = "WHITE";
				}
			}
			else if(c1.equals("BLACK")) {
				
				if(c2.equals("RED")) {
					result = "DARK RED";
				}
				else if(c2.equals("PURPLE")) {
					result = "DARK PURPLE";
				}
				else if(c2.equals("BLUE")) {
					result = "DARK BLUE";
				}
				else if(c2.equals("GREEN")) {
					result = "DARK GREEN";
				}
				else if(c2.equals("YELLOW")) {
					result = "DARK YELLOW";
				}
				else if(c2.equals("ORANGE")) {
					result = "DARK ORANGE";
				}
				else if(c2.equals("BLACK")) {
					result = "BLACK";
				}
			}
			System.out.println(result);
			
		}
		
	}

}
