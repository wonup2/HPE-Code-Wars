import java.util.*;
import java.io.*;
public class prob24 {
	public static void main(String[] args)throws IOException{
		Scanner in = new Scanner(new File("input.txt"));
		ArrayList<String> data = new ArrayList<String>();
		String line = in.nextLine();
		while(!line.equals("-------")) {
			data.add(line);
			line = in.nextLine();
		}
		line = in.nextLine();
		ArrayList<String> letter = new ArrayList<String>();
		while(!line.equals("-------")) {
			letter.add(line);
			line = in.nextLine();
		}
		
		ArrayList<String> words = new ArrayList<String>();
		

		
		while(in.hasNext()) {
			line = in.next();
			words.add(line);
		}
		//System.out.println(letter);
		ArrayList<String>[] c = new ArrayList[data.size()];
		for(int i = 0; i < data.size(); i++) {
			String[] temp = data.get(i).split(" ");
			int r = Integer.parseInt(temp[3]);
			int col = Integer.parseInt(temp[4]);
			int length = Integer.parseInt(temp[2]);
			c[i] = new ArrayList<String>();
			if(temp[1].charAt(0) == 'H') {
				for(int j = 0; j < letter.size(); j++) {
					String[] temp2 = letter.get(j).split(" ");
					int letC = Integer.parseInt(temp2[0]);
					if(Integer.parseInt(temp2[1]) == col) {
						if(letC >= r && letC < r + length) {
							c[i].add(letter.get(j));
						}
						
					}
				}
			}else {
				for(int j = 0; j < letter.size(); j++) {
					String[] temp2 = letter.get(j).split(" ");
					int letC = Integer.parseInt(temp2[1]);
					if(Integer.parseInt(temp2[0]) == r) {
						if(letC >= col && letC < col + length) {
							c[i].add(letter.get(j));
						}
						
					}
				}
			}
			//System.out.println(c[i]);
		}
		/*
		for(int i = 0 ; i < c.length; i++) {
			for(int j = 0; j < c[i].size(); j++) {
				System.out.print(c[i].get(j) + "    ");
			}
			System.out.println();
		}*/
		
		
		
		String[] ans = new String[data.size()];
		for(int i = 0; i < c.length; i++) {
			String[] tempdata = data.get(i).split(" ");
			
			int r = Integer.parseInt(tempdata[3]);
			int col = Integer.parseInt(tempdata[4]);
			char v = tempdata[1].charAt(0);
			for(int j = 0; j < words.size(); j++) {
				String w = words.get(j);
				
				if(w.length() != Integer.parseInt(tempdata[2])) {
					continue;
				}
				
				boolean check = true;
				for(int k = 0; k < c[i].size(); k++) {
					//System.out.println(data.get(i)+" : "+ w+" - "+c[i].get(k));
					if(v == 'H') {
						//System.out.println(c[i].get(k).charAt(0)-'0' - r);
						String[] tempc = c[i].get(k).split(" ");
						int index = Integer.parseInt(tempc[0]) - r;
						if(index<0||index>=w.length()||w.length() != Integer.parseInt(tempdata[2])||w.charAt(index) != tempc[2].charAt(0) ) {
							check = false;
							break;
						}
					}else {
						String[] tempc = c[i].get(k).split(" ");
						
						int index = Integer.parseInt(tempc[1])-col;
						if(index<0||index>=w.length()||w.length() !=  Integer.parseInt(tempdata[2])||w.charAt(index) != tempc[2].charAt(0) ) {
							check = false;
							break;
						}
					}
				}
				
				if(check == true) {
					ans[i] = w;
					break;
				}
			}//System.out.println();
		}
		//System.out.println(Arrays.toString(ans));
		for(int i=1;i<=ans.length;i++)
		{
			if(i<10)
			{
				System.out.println("0"+i+" is "+ans[i-1]);
			}
			else
			{
				System.out.println(i+" is "+ans[i-1]);
			}
		}
		
	}
}
