import java.util.*;
import java.io.*;

public class prob06 {

	static Scanner in;
	static Map<Integer, String> map;
	static List<Integer> list;
	static List<String> ans;

	public static void main(String[] args) {
		try {
				in = new Scanner(new File("input.txt"));
				init();
				solve();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void init() {
		list = new ArrayList<Integer>();
		ans = new ArrayList<String>();
		while (in.hasNextLine()) {
			list.add(Integer.parseInt(in.nextLine()));
		}
		map = new HashMap<Integer, String>();
		map.put(1, "B");
		map.put(2, "BB");
		map.put(3, "BBB");
		map.put(4, "BW");
		map.put(5, "W");
		map.put(6, "WB");
		map.put(7, "WBB");
		map.put(8, "WBBB");
		map.put(9, "BK");
		map.put(10, "Z");
		map.put(20, "ZZ");
		map.put(30, "ZZZ");
		map.put(40, "ZP");
		map.put(50, "P");
		map.put(60, "PZ");
		map.put(70, "PZZ");
		map.put(80, "PZZZ");
		map.put(90, "ZB");
		map.put(100, "B");
		map.put(200, "BB");
		map.put(300, "BBB");
		map.put(400, "BG");
		map.put(500, "G");
		map.put(600, "GB");
		map.put(700, "GBB");
		map.put(800, "GBBB");
		map.put(900, "BR");
		map.put(1000, "R");

		//System.out.println(list);
	}

	public static void solve() {
		String result = "";
		for (int i : list) {
			result = "";
			while (i != 0) {
				if (map.containsKey(i)) {
					result = map.get(i) + result;
					i -= i;
				} else if(i%10 != 0){
					result = map.get(i % 10) + result;
					i -= i % 10;
				}else if(i % 100 != 0){
					result = map.get(i % 100) + result;
					i -= i % 100;
				}else {
					result = map.get(i % 1000) + result;
					i -= i % 1000;
				}
			}
			System.out.println(result);
		}
	}

}
