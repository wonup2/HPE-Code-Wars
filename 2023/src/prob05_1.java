//Joseph

import java.util.*;
import java.io.*;

public class prob05_1 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String line = in.readLine();
		int count = 0;
		while(!line.equals("END")) {
			if(line.equals("END"))
				break;
			StringTokenizer str = new StringTokenizer(line);
			ArrayList<Integer> values = new ArrayList<Integer>();
			ArrayList<Character> oper = new ArrayList<>();
			int index = 0;
			values.add(Integer.parseInt(str.nextToken()));
			String fin = values.get(0) + " ";
			int equals = -1;
			while(true) {
				char operator = str.nextToken().charAt(0);
				if(operator == '=') {
					equals = Integer.parseInt(str.nextToken());
					break;
				}
				else {
					int next = Integer.parseInt(str.nextToken());
					fin += operator + " " + next + " ";
					if(operator == '*') {
						int prev = values.remove(values.size() - 1);
						values.add(prev * next);
					}
					else {
						values.add(next);
						oper.add(operator);
					}
				}
			}
			int total = values.get(0);
			for(int i = 0; i < oper.size(); i ++) {
				if(oper.get(i) == '+') {
					total += values.get(i + 1);
				}
				else {
					total -= values.get(i + 1);
				}
			}
			if(total != equals) {
				count ++;
				System.out.println("DIRECTIVE: " + fin + "!= " + equals + "; CORRECT TO VALUE: " + total);
			}
			line = in.readLine();
		}
		if(count == 0) {
			System.out.println("ALL DATASETS WERE CORRECT");
		}

	}

}