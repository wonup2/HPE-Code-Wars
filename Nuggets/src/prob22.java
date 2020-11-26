import java.util.*;
import java.io.*;
public class prob22 {
	
	static Scanner in;
	static String[] input;
	static TreeMap<Integer, Character> efs = new TreeMap<Integer, Character>(), afs = new TreeMap<Integer, Character>();
	static LinkedHashMap<Character, Integer> enote = new LinkedHashMap<Character, Integer>(), anote = new LinkedHashMap<Character, Integer>();
	
	public static void main(String[] args) throws IOException{
		in = new Scanner(new File("input.txt"));
		setup();
		while(in.hasNextLine()) {
			init();
		}
		in.close();
	}
	
	static void init() {
		input = in.nextLine().split(" ");
		if(input.length == 2)
			solvefs();
		else
			solvenote();
	}
	
	static void solvefs() {
		int fret = Integer.parseInt(input[0]);
		String note = input[1];
		if(note.equals("E"))
			System.out.println(efs.get(fret));
		else
			System.out.println(afs.get(fret));
	}
	
	static void solvenote() {
		String ans = "";
		char c = input[0].charAt(0);
		if(c == 'E')
			ans += "0 E 12 E 7 A";
		else if(c == 'A')
			ans += "5 E 0 A 12 A";
		else
			ans += enote.get(c) + " E " + anote.get(c) + " A";
		System.out.println(ans);
	}
	
	static void setup() {
		efs.put(0, 'F');
		efs.put(1, 'G');
		efs.put(3, 'A');
		efs.put(5, 'B');
		efs.put(7, 'C');
		efs.put(8, 'D');
		efs.put(10, 'E');
		efs.put(12, 'E');
		afs.put(0, 'B');
		afs.put(2, 'C');
		afs.put(3, 'D');
		afs.put(5, 'E');
		afs.put(7, 'F');
		afs.put(8, 'G');
		afs.put(10, 'A');
		afs.put(12, 'A');
		enote.put('F', 1); //IF 'E': ITS 0 AND 12!
		enote.put('G', 3);
		enote.put('A', 5);
		enote.put('B', 7);
		enote.put('C', 8);
		enote.put('D', 10);
		anote.put('B', 2); //IF 'A': ITS 0 AND 12!
		anote.put('C', 3);
		anote.put('D', 5);
		anote.put('E', 7);
		anote.put('F', 8);
		anote.put('G', 10);

	}

}
