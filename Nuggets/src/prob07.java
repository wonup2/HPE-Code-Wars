import java.util.*;
import java.io.*;
public class prob07 {
	
	static Scanner in;
	static ArrayList<String> list = new ArrayList<String>();
	static ArrayList<String> ans = new ArrayList<String>();
	
	public static void main(String[] args) throws IOException{
		in = new Scanner(new File("input.txt"));
		init();
		solve();
		in.close();
	}
	
	static void init() {
		while(in.hasNext())
			list.add(in.next());
		
	}
	
	static void solve() {
		while(list.size() > 0) {
			String x = list.get(0);
			String y = list.get(1);
			if(x.equals(y)) {
				ans.add(x);
			}else if(x.equals("BLACK") || x.equals("WHITE") || y.equals("BLACK") || y.equals("WHITE")) {
				if(x.equals("BLACK"))
					ans.add("DARK " + y);
				else if(x.equals("WHITE"))
					ans.add("LIGHT " + y);
				else if(y.equals("BLACK"))
					ans.add("DARK " + x);
				else
					ans.add("LIGHT " + x);
			}else {
				if(x.equals("RED")) {
					if(y.equals("YELLOW"))
						ans.add("ORANGE");
					else
						ans.add("PURPLE");
				}else if(x.equals("BLUE")) {
					if(y.equals("YELLOW"))
						ans.add("GREEN");
					else
						ans.add("PURPLE");
				}else {
					if(y.equals("YELLOW"))
						ans.add("ORANGE");
					else
						ans.add("GREEN");
				}
			}
			list.remove(0);
			list.remove(0);
		}
		for(String s: ans)
			System.out.println(s);
	}

}
