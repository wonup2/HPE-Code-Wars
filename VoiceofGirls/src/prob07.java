import java.util.*;
import java.io.*;

public class prob07 {

	static Scanner in;
	static List<String> first;
	static List<String> second;

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
		first = new ArrayList<String>();
		second = new ArrayList<String>();
		while (in.hasNextLine()) {
			first.add(in.next());
			second.add(in.next());
			in.nextLine();
		}
		// System.out.println(first);
		// System.out.println(second);
	}

	public static void solve() {
		String color = "";
		for (int i = 0; i < first.size(); i++) {
			color = "";
			if (first.get(i).equals(second.get(i)))
				color = first.get(i);
			else if (first.get(i).equals("WHITE") || second.get(i).equals("WHITE")) {
				color += "LIGHT ";
				if (first.get(i).equals("WHITE"))
					color += second.get(i);
				else
					color += first.get(i);
			} else if (first.get(i).equals("BLACK") || second.get(i).equals("BLACK")) {
				color += "DARK ";
				if (first.get(i).equals("BLACK"))
					color += second.get(i);
				else
					color += first.get(i);
			} else if ((first.get(i).equals("RED") && second.get(i).equals("BLUE"))
					|| (first.get(i).equals("BLUE") && second.get(i).equals("RED")))
				color = "PURPLE";
			else if ((first.get(i).equals("RED") && second.get(i).equals("YELLOW"))
					|| (first.get(i).equals("YELLOW") && second.get(i).equals("RED")))
				color = "ORANGE";
			else
				color = "GREEN";
			System.out.println(color);
		}
	}

}
