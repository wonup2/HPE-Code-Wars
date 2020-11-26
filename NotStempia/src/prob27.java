
import java.util.*;
import java.io.*;
public class prob27 {
	public static void main(String[] args) throws IOException{
		Scanner in = new Scanner(new File("input.txt"));
		String line = in.nextLine();
		StringTokenizer l =  new StringTokenizer(line);
		ArrayList<String> ans= new ArrayList<String>();
		while (!line.equals("0")) {
			int n = Integer.parseInt(l.nextToken());
			String[] words = new String[n];
			for(int i = 0; i < n; i++) {
				words[i] = l.nextToken();
			}
			
			String temp1= words[0];
			boolean copy = true;
			for(int i = 0; i < n; i++) {
				if(!words[i].equals(temp1)) {
					copy = false;
				}
			}
			if(copy == true) {
				String a = "";
				for(int i = 0; i < n; i++) {
					a += words[i] + " ";
				}
				a += " COPY"; 
				ans.add(a);
				line = in.nextLine();
				l =  new StringTokenizer(line);
				continue;
			}
			
			if(n == 2) {
				if(words[1].substring(0,3).equals("SHM") && !words[0].substring(0,3).equals("SHM")) {
					String a = words[0] + " " + words[1] + "  " + "SHM";
					ans.add(a);
					line = in.nextLine();
					l =  new StringTokenizer(line);
					continue;
				}
			}
			
			String[] tempArr = new String[n];
			for(int i = 0; i < n; i++) {
				tempArr[i] = words[i];
				
			}
			for(int i = 0; i < n; i++) {
				
				while(tempArr[i].charAt(0) != 'A' &&tempArr[i].charAt(0) != 'E'&&tempArr[i].charAt(0) != 'I'&&tempArr[i].charAt(0) != 'O'&&tempArr[i].charAt(0) != 'U'&&tempArr[i].charAt(0) != 'Y') {
					tempArr[i] = tempArr[i].substring(1);
				}
			}
			String r = tempArr[0];
			boolean rhyme = true;
			for(int i = 0; i < n; i++) {
				if(!tempArr[i].equals(r)) {
					rhyme = false;
				}
			}
			if(rhyme == true) {
				String a = "";
				for(int i = 0;i < n ;i++) {
					a+= words[i] + " ";
				}
				a += " RHYMING";
				ans.add(a);
				line = in.nextLine();
				l =  new StringTokenizer(line);
				continue;
			}
			
			int index = 0;
			for(int i = 0; i < words[0].length(); i++) {
				if(words[0].charAt(i) != words[1].charAt(i)){
					index = i;
				}
			}
			
			int[] change = new int[n];
			
			for(int i = 0; i < n; i++) {
				if(words[i].charAt(index) == 'I') 
					change[i] = 1;
				else if(words[i].charAt(index) == 'A') 
					change[i] = 2;
				else if(words[i].charAt(index) == 'E') 
					change[i] = 3;
				else if(words[i].charAt(index) == 'O') 
					change[i] = 4;
				else if(words[i].charAt(index) == 'U') 
					change[i] = 5;
			}
			boolean check = true;
			for(int i = 0; i < n-1; i++) {
				if(change[i]> change[i+1] ) {
					check = false;
					break;
				}
			}
			
			if(check == true) {
				String a = "";
				for(int i = 0;i < n ;i++) {
					a+= words[i] + " ";
				}
				a += " PROGRESSIVE";
				ans.add(a);
				line = in.nextLine();
				l =  new StringTokenizer(line);
				continue;
			}else {
				String a = "";
				for(int i = 0;i < n ;i++) {
					a+= words[i] + " ";
				}
				a += " ABLAUT";
				ans.add(a);
			}
			
			
			line = in.nextLine();
			l =  new StringTokenizer(line);
		}
		for(int i = 0; i < ans.size(); i++) {
			System.out.println(ans.get(i));
		}
	}
}
