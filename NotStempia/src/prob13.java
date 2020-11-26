import java.util.*;
import java.io.*;

public class prob13 {

	public static void main(String[] args) throws IOException{

		BufferedReader in = new BufferedReader(new FileReader("input.txt"));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		int money = Integer.parseInt(st.nextToken());
		int ogm = money;
		int items = Integer.parseInt(st.nextToken());
		
		cart[] shop = new cart[items];
		
		for(int i = 0; i < items; i++) {
			st = new StringTokenizer(in.readLine());
			String temp1 = (st.nextToken()+"");
			int temp2 = Integer.parseInt(st.nextToken());
			shop[i] = new cart(temp1, temp2);
		}
		for(int i = 0; i < items; i++) {
			if(money-shop[i].cost>=0) {
				money = money-shop[i].cost;
				System.out.println("I can afford " + shop[i].item);
				
			}
			else {
				System.out.println("I can't afford " + shop[i].item);
			}
			
		}
		if(ogm==money) System.out.println("I need more Yen!");
		System.out.println(money);
		
		
	}
	
	static class cart implements Comparable<cart>{
		
		String item;
		int cost;
		
		cart(String i, int c){
			item = i;
			cost = c;
		}
		
		@Override
		public int compareTo(cart o) {
			return this.cost-o.cost;
		}
		
	}

}
