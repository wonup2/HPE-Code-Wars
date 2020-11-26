import java.io.*;
import java.util.*;

public class prob21 {
	static Scanner in;
	static String name;
	static String rate;
	static String in1;
	static String out1;
	static String in2;
	static String out2;
	static String temp;
	
	public static void main(String[] args) throws IOException{
		in = new Scanner (new File("input.txt"));
		while(in.hasNextLine()){
			init();
			solve();
		}
		in.close();
	}
	static void init(){
		if(!in.hasNextLine())return;
		temp = in.next();
		name = in.nextLine().replace(" ","");
		temp = in.next();
		rate = in.nextLine().replace(" ","");
		temp = in.next();
		in1 = in.nextLine().replace(" ","");
		temp = in.next();
		out1 = in.nextLine().replace(" ","");
		temp = in.next();
		in2 = in.nextLine().replace(" ","");
		temp=in.next();
		out2 = in.nextLine().replace(" ","");
		
		/*
		System.out.println(name);
		System.out.println(rate);
		System.out.println(in1);
		System.out.println(out1);
		System.out.println(in2);
		System.out.println(out2);
		*/
	}
	static void solve(){
		double ans = 0.0;
		double time1 = 0.0;
		double time2 = 0.0;
		
		if(out1.substring(2).equals("00")){
			time1 = Integer.parseInt(out1.substring(0,2))-Integer.parseInt(in1.substring(0,2))-1;
			time2 = 60-Integer.parseInt(in1.substring(2));
			//System.out.println(time1 + " " + time2);
		}
		else{
			time1 = Integer.parseInt(out1.substring(0,2))-Integer.parseInt(in1.substring(0,2));
			time2 = Integer.parseInt(out1.substring(2))-Integer.parseInt(in1.substring(2));
			//System.out.println(time1 + " " + time2);
		}
		if(in2.equals("0000")&&out2.equals("0000")){
			time1+=0;
			time2 +=0;
		}
		else if(out2.substring(2).equals("00")&&!in2.equals("0000")){
			time1 += Integer.parseInt(out2.substring(0,2))-Integer.parseInt(in2.substring(0,2))-1;
			time2 += 60-Integer.parseInt(in2.substring(2));
			//System.out.println(time1 + " " + time2);
		}
		else{
			time1 += Integer.parseInt(out2.substring(0,2))-Integer.parseInt(in2.substring(0,2));
			time2 += Integer.parseInt(out2.substring(2))-Integer.parseInt(in2.substring(2));
			//System.out.println(time1 + " " + time2);
		}
		time2 = time2/60;
		
		double r = Double.parseDouble(rate);
		
	
		
		ans = r*(time1+time2);
		
		double scale = Math.pow(10, 2);
		ans = (Math.round(ans*scale)/scale);
		
		String t = ""+ans;
		if(t.indexOf('.')!= t.length()-3){
			t+="0";
		}
		
		System.out.println(name + " earned $"+t);
		
		
	}

}
