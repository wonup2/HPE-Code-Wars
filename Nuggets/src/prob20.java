import java.util.*;
import java.io.*;
public class prob20 {
	
	static Scanner in;
	static int number;
	static String[] order;
	static int pep = 0, redp = 0, pine = 0, olives = 0, sardines = 0, onion = 0, sausage = 0, ham = 0;
	
	public static void main(String[] args) throws IOException{
		in = new Scanner(new File("input.txt"));
		init();
		in.close();
	}
	
	static void init() {
		while(in.hasNext()) {
			number = in.nextInt();
			order = in.nextLine().split(" & ");
			for(int i = 0; i < order.length; i++)
				order[i] = order[i].trim();
			solve();
		}
		print();
	}
	
	static void solve() {
		for(int i = 0; i < order.length; i++) {
			if(isFraction(order[i])) { //boolean method returns true if has fraction
				double fraction = checkFraction(order[i]); //int method returns fraction
				//System.out.println(fraction + " " + order[i]);
				String topping = trimFraction(order[i]); //String method returns String w/o fraction
				addFraction(fraction, topping, number); //void method multiplies fraction by toppings needed (CHECK WHICH TOPPING)\
				//addFraction() also multiplies by THIS.NUMBER and adds the number to the variableS
			}else {
				addFraction(1, order[i], number);
			}
		}
	}
	
	static boolean isFraction(String s) {
		if(s.substring(0, 3).equals("1/2") || s.substring(0, 3).equals("1/4"))
			return true;
		return false;
	}
	
	static double checkFraction(String s) {
		String[] nums = s.substring(0,3).split("/");
		return Double.parseDouble(nums[0]) / Double.parseDouble(nums[1]);
	}
	
	static String trimFraction(String s) {
		return s.substring(4);
	}
	
	static void addFraction(double n, String s, int num) {
		if(s.equals("Pepperoni")) {
			pep += n * 32 * num;
		}else if(s.equals("Red Peppers")) {
			redp += n * 16 * num;
		}else if(s.equals("Pineapple")) {
			pine += n * 84 * num;
		}else if(s.equals("Olive")) {
			olives += n * 20 * num;
		}else if(s.equals("Sardines")) {
			sardines += n * 12 * num;
		}else if(s.equals("Onion")) {
			onion += n * 28 * num;
		}else if(s.equals("Sausage")) {
			sausage += n * 40 * num;
		}else if(s.equals("Ham")){
			ham += n * 36 * num;
		}else if(s.equals("Hawaiian")) {
			pine += num * n * 84;
			ham += n * 36 * num;
		}else if(s.contentEquals("Combo")) {
			redp += n * 16 * num;
			olives += n * 20 * num;
			onion += n * 28 * num;
			sausage += n * 40 * num;
		}else if(s.equals("Fishaster")) {
			sardines += n * 12 * num;
			onion += n * 28 * num;
		}else if(s.equals("Meat-Lovers")) {
			pep += n * 32 * num;
			sausage += n * 40 * num;
			ham += n * 36 * num;
		}
	}
	
	static void print() {
		System.out.println();
		System.out.println("Pepperoni: " + pep);
		System.out.println("Red Peppers: " + redp);
		System.out.println("Pineapple: " + pine);
		System.out.println("Olives: " + olives);
		System.out.println("Sardines: " + sardines);
		System.out.println("Onion: " + onion);
		System.out.println("Sausage: " + sausage);
		System.out.println("Ham: " + ham);
	}
	

}
