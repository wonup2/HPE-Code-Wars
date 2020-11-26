import java.util.*;
import java.util.concurrent.TimeUnit;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
public class prob21 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		Scanner in = new Scanner(new File("input.txt"));
		while(in.hasNextLine()) {
			in.next(); String name = in.next();
			in.next(); double rate = in.nextDouble();
			in.next(); String in1 = in.next();
			in.next(); String out1 = in.next();
			in.next(); String in2 = in.next();
			in.next(); String out2 = in.next();
			
			double a = timeDiff(in1, out1);
			double b = timeDiff(in2, out2);
			double total = ((a+b)/60)*rate;
			System.out.print(name + " earned $");
			System.out.printf("%.2f", total);
			System.out.println();
		}
	}
	
	public static double timeDiff(String a, String b) throws Exception {
		SimpleDateFormat format = new SimpleDateFormat("HH:mm");
		a = a.substring(0, 2) + ":" + a.substring(2);
		b = b.substring(0, 2) + ":" + b.substring(2);
		Date date1 = format.parse(a);
		Date date2 = format.parse(b);
		long difference = date2.getTime() - date1.getTime();
		long hours = TimeUnit.MILLISECONDS.toMinutes(difference);
		return hours;
	}

}
