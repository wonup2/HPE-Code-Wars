
import java.util.*;
import java.io.*;
public class prob20 {
	public static void main(String[] args) throws IOException{
		Scanner in = new Scanner(new File("input.txt"));
		Map<String, Integer> ans = new HashMap<String, Integer>();
		ans.put("Pepperoni",0);
		ans.put("Red",0);
		ans.put("Pineapple",0);
		ans.put("Olives",0);
		ans.put("Sardines",0);
		ans.put("Onion",0);
		ans.put("Sausage",0);
		ans.put("Ham",0);
		Map<String, Integer> toppings = new HashMap<String, Integer>();
		toppings.put("Pepperoni", 32);
		toppings.put("Red", 16);
		toppings.put("Pineapple", 84);
		toppings.put("Olives", 20);
		toppings.put("Sardines", 12);
		toppings.put("Onion", 28);
		toppings.put("Sausage", 40);
		toppings.put("Ham", 36);
		pizza[] set = new pizza[5];
		ArrayList<String> temp = new ArrayList<String>();
		temp.add("Pineapple");
		temp.add("Ham");
		set[0] = new pizza("Hawaiian",temp );
		ArrayList<String> temp2 = new ArrayList<String>();
		temp2.add("Red");
		temp2.add("Olives");
		temp2.add("Onion");
		temp2.add("Sausage");
		set[1] = new pizza("Combo",temp2 );
		ArrayList<String> temp3 = new ArrayList<String>();
		temp3.add("Sardines");
		temp3.add("Onion");
		set[2] = new pizza("Fishaster",temp3 );
		ArrayList<String> temp4 = new ArrayList<String>();
		temp4.add("Pepperoni");
		temp4.add("Sausage");
		temp4.add("Ham");
		set[3] = new pizza("Meat-Lovers",temp4 );
		ArrayList<String> temp5 = new ArrayList<String>();
		set[4] = new pizza("Cheese",temp5 );
		while(in.hasNext()) {
			StringTokenizer st= new StringTokenizer(in.nextLine());
			int numOfPizzas = Integer.parseInt(st.nextToken());
			String next = st.nextToken();
			if(next.equals("Red")) {
				st.nextToken();
			}
			if(next.charAt(0)!= '1') {
				if(toppings.containsKey(next)) {
					ans.replace(next, ans.get(next)+ (numOfPizzas *toppings.get(next)));
				}else {
					ArrayList<String> list=  new ArrayList<String>();
					for(int j = 0; j < set.length; j++) {
						if(next.equals(set[j].name)) {
							list = set[j].top;
						}
					}
					for(int j = 0; j < list.size(); j++) {
						ans.replace(list.get(j), ans.get(list.get(j)) + (numOfPizzas *toppings.get(list.get(j))));
					}
				}
			}else {
				String name= st.nextToken();
				if(name.equals("Red")) {
					st.nextToken();
				}
				if(st.hasMoreElements()) {
					st.nextToken();
				}
				int numerator= next.charAt(0)-'0';
				int denom = next.charAt(2) - '0';
				if(toppings.containsKey(name)) {
					ans.replace(name, ans.get(name)+ (numOfPizzas *toppings.get(name) / denom));
				}else {
					ArrayList<String> list=  new ArrayList<String>();
					for(int j = 0; j < set.length; j++) {
						if(name.equals(set[j].name)) {
							list = set[j].top;
						}
					}
					for(int j = 0; j < list.size(); j++) {
						ans.replace(list.get(j), ans.get(list.get(j)) + (numOfPizzas *toppings.get(list.get(j))/ denom));
					}
				}
				while(st.hasMoreElements()) {
					next = st.nextToken();
					denom = next.charAt(2)-'0';
					name = st.nextToken();
					if(name.equals("Red")) {
						st.nextToken();
					}
					if(st.hasMoreElements()) {
						st.nextToken();
					}
					if(toppings.containsKey(name)) {
						ans.replace(name, ans.get(name)+ (numOfPizzas *toppings.get(name) / denom));
					}else {
						ArrayList<String> list=  new ArrayList<String>();
						for(int j = 0; j < set.length; j++) {
							if(name.equals(set[j].name)) {
								list = set[j].top;
							}
						}
						for(int j = 0; j < list.size(); j++) {
							ans.replace(list.get(j), ans.get(list.get(j)) + (numOfPizzas *toppings.get(list.get(j))/ denom));
						}
					}
				}
			}
		}
		System.out.println("Pepperoni: " + ans.get("Pepperoni"));
		System.out.println("Red Peppers: " + ans.get("Red"));
		System.out.println("Pineapple: " + ans.get("Pineapple"));
		System.out.println("Olives: " + ans.get("Olives"));
		System.out.println("Sardines: " + ans.get("Sardines"));
		System.out.println("Onion: " + ans.get("Onion"));
		System.out.println("Sausage: " + ans.get("Sausage"));
		System.out.println("Ham: " + ans.get("Ham"));
	
	}
	static class top{
		String topName;
		int num;
		public top(String t, int n) {
			topName = t;
			num = n;
		}
	}
	static class pizza{
		String name;
		ArrayList<String> top;
		public pizza(String n, ArrayList<String>t) {
			name = n;
			top = t;
		}
	}
}

