
import java.util.*;
import java.io.*;
import java.text.SimpleDateFormat;
public class prob26 {
	public static void main(String[] args) throws IOException, Exception{
		Scanner in = new Scanner(new File("input.txt"));
		ArrayList<String> ans = new ArrayList<String>();
		while(in.hasNext()) {
			SimpleDateFormat dtf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss"); 
			StringTokenizer st= new StringTokenizer(in.nextLine());
			String startDate = st.nextToken();
			startDate = startDate.replace('-', '/');
			String startTime = st.nextToken();
			String endDate = st.nextToken();
			endDate = endDate.replace('-', '/');
			String endTime = st.nextToken();
			Date d1 = dtf.parse(startDate + " " + startTime);
			Date d2 = dtf.parse(endDate + " " + endTime);
			String required = st.nextToken();
			boolean d = false;
			boolean h = false;
			boolean m = false;
			boolean s = false;
			for(int i =0; i < required.length(); i++) {
				if(required.charAt(i) == 'D') {
					d = true;
				}else if(required.charAt(i) == 'H') {
					h = true;
				}else if(required.charAt(i) == 'M') {
					m = true;
				}else if(required.charAt(i) == 'S') {
					s = true;
				}
			}
			int diffInDays = (int)( ((d2.getTime() - d1.getTime()) / (1000 * 60 * 60 * 24)) );
			int hours =  (int)( ((d2.getTime() - d1.getTime()) / (1000 * 60 * 60)) );
			if(d == true) {
				hours -= diffInDays*24;
			}
			int mins =  (int)(((d2.getTime() - d1.getTime()) / (1000 * 60)) );
			if(d == true) {
				mins -= diffInDays*24*60;
			}
			if(h == true) {
				mins -= hours*60;
			}
			int sec =  (int)( ((d2.getTime() - d1.getTime()) / (1000)) );
			if(d == true)
				sec -= diffInDays*24*60*60;
			if(h == true)
				sec -= hours*60*60;
			if(m == true)
				sec -= mins*60;
			
			String a = "there are ";
			if(d == true)
				a+= Integer.toString(diffInDays) + " days ";
			if(h == true)
				a+= Integer.toString(hours) + " hours ";
			if(m == true)
				a+= Integer.toString(mins) + " minutes ";
			if(s == true)
				a+= Integer.toString(sec) + " seconds ";
			endDate = endDate.replace('/', '-');
			a+="remaining until " + endDate + " "+ endTime;
			ans.add(a);
		}
		for(int i = 0; i< ans.size(); i++) {
			System.out.println(ans.get(i));
		}
	}
}
