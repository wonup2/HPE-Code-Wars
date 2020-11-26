
import java.util.*;
import java.io.*;
import java.text.SimpleDateFormat;
public class prob26 {
	public static void main(String[] args) throws IOException, Exception{
		Scanner in = new Scanner(new File("input.txt"));
		StringBuilder sb = new StringBuilder();

		while(in.hasNext()) {
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
			String sDate = in.next();
			String sTime = in.next();
			String eDate = in.next();
			String eTime = in.next();
			Date d1 = format.parse(sDate + " " + sTime);
			Date d2 = format.parse(eDate + " " + eTime);
			String required = in.next();
			boolean d = false, h = false, m = false, s = false;

			for(int i =0; i < required.length(); i++) {
				if(required.charAt(i) == 'D') d = true;				
				else if(required.charAt(i) == 'H') h = true;				
				else if(required.charAt(i) == 'M') m = true;				
				else if(required.charAt(i) == 'S') s = true;			
			}			
			
			long temp = d2.getTime() - d1.getTime();
			long dif = temp / 1000 / 60 / 60 / 24;
			long hours =  temp / 1000 / 60 / 60;
			if(d) hours -= dif*24;			
			long mins =  temp / 1000 / 60;
			if(d) mins -= dif*24*60;			
			if(h) mins -= hours*60;			
			long sec =  temp / 1000;
			if(d) sec -= dif*24*60*60;
			if(h) sec -= hours*60*60;
			if(m) sec -= mins*60;
			
			sb.append("there are ");
			if(d) sb.append(dif+"").append(" days ");
			if(h) sb.append(hours+"").append(" hours ");
			if(m) sb.append(mins+"").append(" minutes "); 
			if(s) sb.append(sec+"").append(" seconds "); 
			sb.append("remaining until ").append(eDate+" ").append(eTime); 
			sb.append("\n");
		}
		System.out.print(sb.toString());	
	}
}
