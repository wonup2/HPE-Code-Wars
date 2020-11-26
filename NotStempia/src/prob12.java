
import java.util.*;
import java.io.*;
import java.text.DecimalFormat;
public class prob12 {
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(new File("input.txt"));
		ArrayList<Double> list=  new ArrayList<Double>();
		while(in.hasNext()) {
			StringTokenizer st = new StringTokenizer(in.nextLine());
			int x = 0;
			double feet = 0.0;
			double yards = 0.0;
			double inch = 0.0;
			while(st.hasMoreElements()) {
				if(x == 0) {
					yards = Double.parseDouble(st.nextToken());
				}else if(x == 1) {
					feet = Double.parseDouble(st.nextToken());
				}else {
					inch = Double.parseDouble(st.nextToken());
				}
				x++;
			}
			feet = yards * 3.0  + feet;
			inch = feet * 12.0+ inch;
			double ans = inch * 2.54;
			list.add(ans);
		}
		DecimalFormat f = new DecimalFormat("0.00");
		for(int i = 0; i < list.size(); i++) {
		System.out.println(f.format(list.get(i)));
		}
	   
	}
}

