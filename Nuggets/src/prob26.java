import java.util.*;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class prob26 {
	
	final static int MAX = 1000000000;
	static Scanner in;
	
	public static void solve() {
		// TODO Auto-generated method stub
		while(in.hasNextLine()) {
		String input = in.nextLine();
		int startyear = Integer.parseInt(input.substring(0, 4));
		int startmonth = Integer.parseInt(input.substring(5, 7));
		int startday = Integer.parseInt(input.substring(8, 10));
		int starthr = Integer.parseInt(input.substring(11, 13));
		int startmin = Integer.parseInt(input.substring(14, 16));
		int startsec = Integer.parseInt(input.substring(17, 19));
		int endyear = Integer.parseInt(input.substring(20, 24));
		int endmonth = Integer.parseInt(input.substring(25, 27));
		int endday = Integer.parseInt(input.substring(28, 30));
		int endhr = Integer.parseInt(input.substring(31, 33));
		int endmin = Integer.parseInt(input.substring(34, 36));
		int endsec = Integer.parseInt(input.substring(37, 39));
		Date date1 = new Date(startyear, (startmonth - 1), startday, starthr, startmin, startsec);
		Date date2 = new Date(endyear, (endmonth - 1), endday, endhr, endmin, endsec);
		String target = input.substring(40, input.length());
		long seconddiff = getDateDiff(date1, date2, TimeUnit.SECONDS);
		long minutediff = getDateDiff(date1, date2, TimeUnit.MINUTES);
		long hourdiff = getDateDiff(date1, date2, TimeUnit.HOURS);
		long daydiff = getDateDiff(date1, date2, TimeUnit.DAYS);
		long secondtemp = seconddiff - (minutediff * 60);
		long minutetemp = minutediff - (hourdiff * 60);
		long hourtemp = hourdiff - (daydiff * 24);
		String result = "there are ";
		if(target.equals("D")) {
			result+=daydiff + " days ";
		} else if(target.equals("H")) {
			result+=hourdiff + " hours ";
		} else if(target.equals("M")) {
			result+=minutediff + " minutes ";
		} else if(target.equals("S")) {
			result+=seconddiff + " seconds ";
		} else if(target.equals("DHMS")) {
			result+=daydiff + " days " + hourtemp + " hours " + minutetemp + " minutes " + secondtemp + " seconds ";
		} else if(target.equals("HMS")) {
			result+=hourdiff + " hours " + minutetemp + " minutes " + secondtemp + " seconds ";
		} else if(target.equals("MS")) {
			result+=minutediff + " minutes " + secondtemp + " seconds ";
		} else if(target.equals("DH")) {
			result+=daydiff + " days " + hourtemp + " hours ";
		} else if(target.equals("DM")) {
			minutetemp = minutediff - (daydiff * 24 * 60);
			result+=daydiff + " days " + minutetemp + " minutes ";
		} else if(target.equals("DS")) {
			secondtemp = seconddiff - (daydiff * 24 * 60 * 60);
			result+=daydiff + " days " + secondtemp + " seconds ";
		} else if(target.equals("HM")) {
			result+=hourdiff + " hours " + minutetemp + " minutes ";
		} else if(target.equals("HS")) {
			secondtemp = seconddiff - (hourdiff * 60 * 60);
			result+=hourdiff + " hours " + secondtemp + " seconds ";
		}
		result+="remaining until " + input.substring(20, 39);
		System.out.println(result);
		}
	}
	
	public static long getDateDiff(Date date1, Date date2, TimeUnit timeUnit) {
	    long diffInMillies = date2.getTime() - date1.getTime();
	    return timeUnit.convert(diffInMillies,TimeUnit.MILLISECONDS);
	}
	
	static String printDecimals(double value, int digits, boolean round) {
		for(int i = 0; i < digits; i++) {
			value *= 10;
		}
		int point = (int) ((value * 10) % 10);
		int val = (int) value;
		if(round && point > 4) {
			val++;
		}
		String ret = val + "";
		if(ret.length() == digits) {
			return "0." + ret;
		}
		return ret.substring(0, ret.length() - digits) + "." + ret.substring(ret.length() - digits);
 	}
	
	public static boolean isPrime(int n) {
		if(!notPrime[0])runSieve();
		return !notPrime[n];
	}
	
	static boolean[] notPrime = new boolean[MAX];
	
	public static void runSieve() {
		notPrime[0] = true;
		notPrime[1] = true;
		for(int i = 2; i <= MAX / 2; i++)	{
			if(!notPrime[i]) {
				for(int j = i * 2; j < MAX; j += i) {
					notPrime[j] = true;
				}
			}
		}
	}
	
	
	public static void main(String[] args) throws IOException{
		in = new Scanner(new File("input.txt"));
		solve();
	}

}