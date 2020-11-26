import java.util.*;
import java.io.*;
public class prob13 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		Scanner in = new Scanner(new File("input.txt"));
		int total = in.nextInt();
		int n = in.nextInt();
		int[] values = new int[n];
		boolean[] check = new boolean[n];
		boolean end = true;
		HashMap<String, Integer> map = new HashMap<>();
		for(int z = 0; z < n; z++) {
			String item = in.next();
			int val = in.nextInt();
			values[z] = val;
			map.put(item, val);
		}
		Arrays.sort(values);
		for(int i = 0; i < n; i++) {
			if(values[i] <= total) {
				check[i] = true;
				end = false;
				total -= values[i];
			}
			else
				break;
		}
		for(String s : map.keySet()) {
			boolean print = true;
			for(int i = 0; i < n; i++) {
				if(check[i] == true && map.get(s) == values[i]) {
					System.out.println("I can afford " + s);
					print = false;
				}
			}
			if(print)
				System.out.println("I can't afford " + s);
		}
		if(end)
			System.out.println("I need more Yen!");
		System.out.println(total);
	}

}
