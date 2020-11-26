import java.util.*;
import java.io.*;
public class prob29 {
	static ArrayList<String> arr = new ArrayList<String>();
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		Scanner in = new Scanner(new File("input.txt"));
		while(in.hasNextLine()) {
			arr.add(in.nextLine());
		}
		
		for(int i = 0; i < arr.size(); i++) {
			String s = arr.get(i);
			if(s.contains("VAR")) {
				boolean check = varIs(s);
				if(check)
					System.out.println((i+1) + ":10 Variable declared but not used");
			}
			if(s.contains("IF") || s.contains("FUNC") && !s.contains("ENDFUNC") || s.contains("FOR")) {
				boolean check = indentIs(i+1);
				if(check)
					System.out.println((i+2) + ":20 Unexpected indentation");
				if(s.charAt(0) == ' ')
					System.out.println((i+1) + ":20 Unexpected indentation");
			}
			if(trailIs(s)) {
				System.out.println((i+1) + ":30 Trailing whitespace");
			}
			if(s.contains("FUNC") && !s.contains("ENDFUNC")) {
				boolean check = docFunc(i);
				if(check == false)
					System.out.println((i+1) + ":40 Func declaration without documentation");
			}
		}
		
	}
	
	public static boolean varIs(String s) {
		String[] var = s.split(" ");
		for(String a : arr) {
			if(!a.contains("VAR") && a.contains(var[1]) && !a.contains("#"))
				return false;
		}
		return true;
	}

	public static boolean indentIs(int loc) {
		if(loc == arr.size())
			return false; 
		String s = arr.get(loc);
		if(s.length() == 0)
			return false;
		boolean check = false;
		for(int i = 0; i <= 4; i++) {
			if(i != 4 && s.charAt(i) != ' ')
				check = true;
			else if(i == 4 && s.charAt(i) == ' ')
				check = true;
		}
		return check;
	}

	public static boolean trailIs(String s) {
		if(s.length() == 0)
			return false;
		if(s.charAt(s.length()-1) == ' ')
			return true;
		return false;
	}

	public static boolean docFunc(int loc) {
		String s = arr.get(loc);
		s = s.trim();
		s = s.replace("FUNC ", "");
		s = s.replace("(", " ");
		String[] name = s.split(" ");
		//System.out.println(name[0]);
		for(int i = 0; i < arr.size(); i++) {
			String temp = arr.get(i);
			if(i != loc && temp.contains("#") && temp.contains(name[0]))
				return true;
		}
		return false;
	}
}
