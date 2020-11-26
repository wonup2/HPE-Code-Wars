
import java.util.*;
import java.io.*;
public class prob18 {
	public static void main(String[] args) throws IOException{
		Scanner in = new Scanner(new File("input.txt"));
		while(in.hasNext()) {
			String line = in.nextLine();
			String[] arr= line.split(":");
			int hr = Integer.parseInt(arr[0]);
			int min = Integer.parseInt(arr[1]);
			double dh = (hr * 30 + min * 0.5) % 360;
			double dm = (min * 6) % 360;
			if(Math.abs(dh - dm) > 180) {
				System.out.printf("The angle between the Hour hand and Minute hand is %.2f degrees.\n",360.0 - Math.abs(dh - dm));
			}else
				System.out.printf("The angle between the Hour hand and Minute hand is %.2f degrees.\n",Math.abs(dh - dm));
			
		}
		
	}
	
}
