import java.io.*;
import java.util.*;
public class prob16 {
	
	static Scanner in;
	static String[] temp;
	static double a, b, c, ans;
	static String op;
	
	public static void main(String[] args) {
		
		try {
			in = new Scanner(new File("input.txt"));
			
			while(in.hasNextLine()) {
				init();
				solve();
			}
			
			
			in.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private static void init() {
		temp = in.nextLine().split(" ");
		a = Double.parseDouble(temp[0]);
		b = Double.parseDouble(temp[1]);
		op = temp[2];
		c = Double.parseDouble(temp[3]);
	}
	
	private static void solve() {
		if(op.equals("POWER")) {
			power();
		}else if(op.equals("MULTIPLY")) {
			mult();
		}else if(op.equals("DIVIDE")) {
			div();
		}else if(op.equals("ADD")){
			add();
		}else if(op.equals("SUBTRACT")) {
			sub();
		}
	}
	
	private static void power() {
		if(Math.pow(a, b) == c) {
			System.out.println(c + " is correct for " +  a + " ^ " + b);
		}else {
			ans = Math.pow(a,b);
			ans = Math.round(ans*10);
			ans = ans /10;
			System.out.println(a + " ^ " + b + " = " + ans + ", not " + c);
		}
	}
	
	private static void mult() {
		if(a * b == c) {
			System.out.println(c + " is correct for " +  a + " * " + b);
		}else {
			ans = a * b;
			ans = Math.round(ans*10);
			ans = ans/10;
			if(ans == c)
				System.out.println(c + " is correct for " +  a + " * " + b);
			System.out.println(a + " * " + b + " = " + ans + ", not " + c);
		}
	}
	
	private static void div() {
		if(a/b == c) {
			System.out.println(c + " is correct for " +  a + " / " + b);
		}else {
			ans = a/b;
			ans = Math.round(ans*10);
			ans = ans /10;
			if(ans == c)
				System.out.println(c + " is correct for " +  a + " / " + b);
			System.out.println(a + " / " + b + " = " + ans + ", not " + c);
		}
	}
	
	private static void add() {
		if(a + b == c) {
			System.out.println(c + " is correct for " +  a + " + " + b);
		}else {
			ans = a + b;
			ans = Math.round(ans*10);
			ans = ans /10;
			System.out.println(a + " + " + b + " = " + ans + ", not " + c);
		}
	}
	
	private static void sub() {
		if(a-b ==c) {
			System.out.println(c + " is correct for " +  a + " - " + b);
		}else {
			ans = a-b;
			ans = Math.round(ans*10);
			ans = ans /10;
			System.out.println(a + " - " + b + " = " + ans + ", not " + c);
		}
	}

}
