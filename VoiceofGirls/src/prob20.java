import java.io.*;
import java.util.*;
public class prob20 {

	static Scanner in;
	static int num;
	static String[] order;
	static LinkedHashMap <String, Integer> map = new LinkedHashMap<String, Integer>();
	static LinkedHashMap <String, Integer> menu = new LinkedHashMap<String, Integer>();
	
	public static void main(String[] args) {
		menu.put("Pepperoni", 32);
		menu.put("Red Peppers", 16);
		menu.put("Pineapple", 84);
		menu.put("Olives", 20);
		menu.put("Sardines", 12);
		menu.put("Onion", 28);
		menu.put("Sausage", 40);
		menu.put("Ham", 36);
		
		map.put("Pepperoni", 0);
		map.put("Red Peppers", 0);
		map.put("Pineapple", 0);
		map.put("Olives", 0);
		map.put("Sardines", 0);
		map.put("Onion", 0);
		map.put("Sausage", 0);
		map.put("Ham", 0);
		
		try {
			in = new Scanner (new File("input.txt"));
			
			while(in.hasNextLine()) {
				
				init();
				solve();
				
				//System.out.println(map.get("Red Peppers"));
			}
			
			//print answer here:
			
			for(String key : map.keySet()) {
				
				System.out.println(key + ": " + map.get(key));
			}
			
			in.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private static void init() {
		
		
		String temp = in.nextLine();
		String n = "";
		int index = 0;
		for(int i =0; i < temp.length(); i++) {
			if(Character.isDigit(temp.charAt(i))) {
				n = n + temp.charAt(i) + "";
			}else {
				index = i+1;
				break;
			}
		}
		num = Integer.parseInt(n);
		temp = temp.substring(index);
		
		//System.out.println(num);
		
		order = temp.split(" & ");
		//System.out.println(Arrays.toString(order));
	}
	
	private static void solve() {
		if(order.length == 1) {
			if(order[0].equals("Cheese")) {
				
			}else if(map.containsKey(order[0])) { //not special
				map.put(order[0], map.get(order[0])+ (menu.get(order[0])*num));
			}else {
				special(num, order[0]);
			}
			return;
		}
		//System.out.println(Arrays.toString(order));
		for(String str : order) {
			String[] temp = str.split(" ");
			//System.out.println(Arrays.toString(temp));
			String type = temp[1];
			if(type.equals("Cheese")) {
				continue;
			}if(type.equals("Red"))
				type = "Red Peppers";
			
			String[] t = temp[0].split("/");
			double port = Double.parseDouble(t[0]) / Double.parseDouble(t[1]);
			
			
			if(map.containsKey(type)) {
				map.put(type, map.get(type) + (int)(menu.get(type) * port * num));
			}else {//special
				special(num*port, type);
			}
		}
		
		
	}
	
	private static void special(double n, String s) {
		if(s.equals("Hawaiian")) {
			map.put("Pineapple", map.get("Pineapple") + (int)(n*84));
			map.put("Ham", map.get("Ham") + (int)(n*36));
		}else if(s.equals("Combo")) {
			map.put("Red Peppers", map.get("Red Peppers") + (int)(n*16));
			map.put("Olives", map.get("Olives") + (int)(n*20));
			map.put("Onion", map.get("Onion") + (int)(n*28));
			map.put("Sausage", map.get("Sausage") + (int)(n*40));
		}else if(s.equals("Fishaster")) {
			map.put("Onion", map.get("Onion") + (int)(n*28));
			map.put("Sardines", map.get("Sardines") + (int)(n*12));
		}else if(s.equals("Meat-Lovers")) {
			map.put("Pepperoni", map.get("Pepperoni") + (int)(n*32));
			map.put("Sausage", map.get("Sausage") + (int)(n*40));
			map.put("Ham", map.get("Ham") + (int)(n*36));
		}
	}
	
}


