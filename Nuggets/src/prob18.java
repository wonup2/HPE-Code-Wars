import java.util.*;
import java.io.*;
public class prob18 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		Scanner in = new Scanner(new File("input.txt"));
		while(in.hasNext()) {
			String[] clock = in.nextLine().split(":");
			if(clock[0].charAt(0) == '0' && clock[0].length() > 1)
				clock[0] = clock[0].charAt(1)+"";
			if(clock[1].charAt(0) == '0')
				clock[1] = clock[1].charAt(1)+"";
			double first = Integer.parseInt(clock[0])*30.0 + Integer.parseInt(clock[1])*0.5;
			double second = Integer.parseInt(clock[1])*6;
			double ans = Math.abs(first-second);
			if(ans > 180)
				ans = 360-ans;
			if(ans < 0)
				ans = ans + 360;
			if(ans > 180)
				ans = 360 - ans;
			System.out.print("The angle between the Hour hand and Minute hand is ");
			System.out.printf("%.2f", ans);
			System.out.println(" degrees.");
		}
	}

}
