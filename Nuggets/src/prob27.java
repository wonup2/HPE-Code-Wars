import java.util.*;
import java.io.*;
public class prob27 {
	
	static Scanner in;
	static int num;
	static boolean onevowel;
	static String[] array;
	
	public static void main(String[] args) throws IOException{
		in = new Scanner(new File("input.txt"));
		num = in.nextInt();
		while(num != 0) {
			init();
			solve();
		}
		in.close();
	}
	
	static void init() {
		array = in.nextLine().trim().split(" ");
		num = in.nextInt();
	}
	
	static void solve() {
		onevowel = true;
		int vowels = numOfVowelsInARow(array);
		printWords();
		if(checkCopy()) {
			System.out.println("COPY");
			onevowel = false;
		}
		else if(checkshm()) {
			System.out.println("SHM");
			onevowel = false;
		}
		else if(checkRhyme()) {
			System.out.println("RHYMING");
			onevowel = false;
		}
		if(vowels == 1 && onevowel == true) {
			if(checkProgressive())
				System.out.println("PROGRESSIVE");
			else
				System.out.println("ABLAUT");;
		}
	}
	
	static int numOfVowelsInARow(String[] arr) {
		boolean plural = false;
		String str = arr[0];
		for(int i = 0; i < str.length() - 1; i++) {
			if(isVowel(str.charAt(i)) && isVowel(str.charAt(i + 1)))
				plural = true;
		}
		if(plural)
			return 2;
		else
			return 1;
	}
	
	static boolean checkCopy() {
		boolean different = false;
		for(int i = 0; i < array.length - 1; i++) {
			if(different)
				break;
			if(!array[i].equals(array[i + 1]))
				different = true;
		}
		if(!different)
			return true;
		return false;
	}
	
	static boolean checkshm() {
		String first = array[0];
		String second = array[1];
		if(isVowel(first.charAt(0))) {
			if(second.substring(0,3).equals("SHM") && second.substring(3).equals(first))
				return true;
		}else {
			if(second.substring(0,3).equals("SHM") && first.substring(1).equals(second.substring(3)))
				return true;
		}
		return false;
	}
	
	static boolean checkRhyme() {
		String common = "";
		String first = array[0], second = array[1];
		int firstindex = 0, secondindex = 0;
		for(int i = 0; i < first.length(); i++) {
			if(isVowel(first.charAt(i)) || first.charAt(i) == 'Y') {
				firstindex = i;
				break;
			}
		}
		for(int i = 0; i < second.length(); i++) {
			if(isVowel(second.charAt(i)) || second.charAt(i) == 'Y') {
				secondindex = i;
				break;
			}
		}
		if(first.substring(firstindex).equals(second.substring(secondindex)))
			return true;
		return false;
	}
	
	static boolean checkProgressive() {
		int sum1 = 0, sum2 = 0;
		String first = array[0], second = array[1];
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		map.put('I', 1);
		map.put('A', 2);
		map.put('E', 3);
		map.put('O', 4);
		map.put('U', 5);
		ArrayList<Character> firstlist = new ArrayList<Character>();
		ArrayList<Character> secondlist = new ArrayList<Character>();
		for(char c: first.toCharArray()) {
			if(isVowel(c))
				firstlist.add(c);
		}
		for(char c: second.toCharArray()) {
			if(isVowel(c))
				secondlist.add(c);
		}
		for(char c: firstlist)
			sum1 += map.get(c);
		for(char c: secondlist)
			sum2 += map.get(c);
		//System.out.println("" + sum1 + " " + sum2);
		if(sum1 < sum2)
			return true;
		return false;
	}
	
	static void printWords() {
		for(String s: array)
			System.out.print(s + " ");
	}
	
	static boolean isVowel(char c) {
		if(c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U')
			return true;
		return false;
	}
	
	static char getVowel(String s) {
		for(char c: s.toCharArray()) {
			if(c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U')
				return c;
		}
		return 'A';
	}

}
