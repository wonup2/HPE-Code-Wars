import java.util.*;
import java.io.*;

public class prob24 {

	static Scanner in;
	static String[][] grid;
	static List<Integer> x, y, len;
	static List<String> or, words;

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
		grid = new String[11][11];
		x = new ArrayList<Integer>();
		y = new ArrayList<Integer>();
		len = new ArrayList<Integer>();
		or = new ArrayList<String>();
		words = new ArrayList<String>();

		// organize inputs
		String temp = in.nextLine();
		while (in.hasNextLine()) {
			String[] tem = temp.split(" ");
			if (tem.length < 2)
				break;
			or.add(tem[1]);
			len.add(Integer.parseInt(tem[2]));
			x.add(Integer.parseInt(tem[3]));
			y.add(Integer.parseInt(tem[4]));
			temp = in.nextLine();
		}

		// System.out.println(or);
		// System.out.println(len);
		// System.out.println(x);
		// System.out.println(y);

		// assign letters in grid
		temp = in.nextLine();
		while (in.hasNextLine()) {
			String[] tem = temp.split(" ");
			if (tem.length < 2)
				break;
			grid[Integer.parseInt(tem[0])][Integer.parseInt(tem[1])] = tem[2];
			temp = in.nextLine();
		}

		// see how the grid looks like
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid.length; j++) {
				if (grid[j][i] == null)
					grid[j][i] = ".";
				// System.out.print(grid[j][i]);
			}
			// System.out.println();
		}

		// putting words in list
		while (in.hasNextLine()) {
			words.add(in.nextLine());
		}

		// System.out.println(words);
	}

	public static void solve() {
		List<String>used = new ArrayList<String>();
		String word = "";
		for (int i = 0; i < x.size(); i++) {
			int X = x.get(i);
			int Y = y.get(i);
			int start = 0;
			word = "";
			for (int j = 0; j < len.get(i); j++) {
				if (or.get(i).equals("H")) {
					word += grid[x.get(i) + start][y.get(i)];
					start++;
				} else {
					word += grid[x.get(i)][y.get(i) + start];
					start++;
				}
			}
			boolean chk = false;
			for (String s : words) {
				if (word.length() == s.length()) {
					for (int j = 0; j < word.length(); j++) {
						if (word.charAt(j) == s.charAt(j) && !used.contains(s)) {
							int num = i+1;
							if (i < 9) {
								System.out.println("0" + num + " is " + s);
							} else
								System.out.println(num + " is " + s);
							used.add(s);
							chk = true;
							break;
						}
					}
				}
				if(chk)
					break;
			}
		}
	}
}
