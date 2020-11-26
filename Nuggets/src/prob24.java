import java.util.*;
import java.io.*;
public class prob24 {
	static String[][] arr;
	static ArrayList<Integer> x = new ArrayList<Integer>();
	static ArrayList<Integer> y = new ArrayList<Integer>();
	static ArrayList<String> direction = new ArrayList<String>();
	static ArrayList<Integer> space = new ArrayList<Integer>();
	static ArrayList<String> words = new ArrayList<String>();
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		Scanner in = new Scanner(new File("input.txt"));
		arr = new String[11][11];
		while(in.hasNextLine()) {
			String temp = in.next();
			if(temp.equals("-------"))
				break;
			String dir = in.next();
			int spaces = in.nextInt();
			int ycoord = in.nextInt();
			int xcoord = in.nextInt();
			if(dir.equals("H")) {
				for(int i = 0; i < spaces; i++) {
					arr[xcoord][ycoord+i] = "";
				}
			}
			else {
				for(int i = 0; i < spaces; i++) {
					arr[xcoord+i][ycoord] = "";
				}
			}
			x.add(xcoord);
			y.add(ycoord);
			direction.add(dir);
			space.add(spaces);
		}
		in.nextLine();
		while(in.hasNextLine()) {
			String[] line = in.nextLine().split(" ");
			if(line[0].equals("-------"))
				break;
			arr[Integer.parseInt(line[1])][Integer.parseInt(line[0])] = line[2];
		}
		
		while(in.hasNext())
			words.add(in.next());
		
		for(int i = 0; i < x.size(); i++) {
			String temp = word(direction.get(i), space.get(i), x.get(i), y.get(i));
			if(i+1 < 10)
				System.out.println("0" + (i+1) + " is " + temp);
			else
				System.out.println((i+1) + " is " + temp);
		}
	}
	
	public static String word(String d, int s, int x, int y) {
		for(int i = 0; i < words.size(); i++) {
			if(words.get(i).length() != s)
				continue;
			else
				if(check(d, s, x, y, words.get(i)))
					return words.get(i);
		}
		return "";
	}
	
	public static boolean check(String d, int s, int x, int y, String word) {
		if(d.equals("H")) {
			for(int i = 0; i < s; i++) {
				String a = arr[x][y+i];
				if(!a.equals("") && !a.equals(word.charAt(i)+""))
					return false;
			}
			return true;
		}
		else {
			for(int i = 0; i < s; i++) {
				String a = arr[x+i][y];
				if(!a.equals("") && !a.equals(word.charAt(i)+""))
					return false;
			}
			return true;
		}
	}
}
