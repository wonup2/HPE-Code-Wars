import java.util.*;
import java.io.*;
public class prob23 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		Scanner in = new Scanner(new FileReader(new File("input.txt")));
		int t = in.nextInt();in.nextLine();
		char[] convert = new char[26];
		for(int i=0;i<26;i++)
			convert[i] = (char) ('a'+i);
		convert[0] = 'e';
		convert['b'-'a'] = 'q'; 
		convert['e'-'a'] = 'a';
		convert['q'-'a'] = 'b';
		convert['d'-'a'] = 'p';
		convert['p'-'a']='d';
		convert['h'-'a']='y';
		convert['y'-'a']='h';
		convert['m'-'a']='w';
		convert['w'-'a']='m';
		convert['n'-'a']='u';
		convert['u'-'a']='n';
		convert['o'-'a']='o';
		convert['s'-'a']='s';
		convert['x'-'a']='x';
		convert['z'-'a']='z';
		while(t-->0)
		{
			String line = in.nextLine().toLowerCase();
			String rotate = "";
			String letline ="";
			for(int i =line.length()-1;i>=0;i--)
			{
				if(line.charAt(i)>='a'&&line.charAt(i)<='z')
				{
					rotate+=""+convert[line.charAt(i)-'a'];
					letline = line.charAt(i)+letline;
				}
				else if(line.charAt(i)==' ')
				{
					rotate+=" ";
					letline= " " +letline;
				}
			}
			String nospacerot = rotate.replaceAll(" ", "");
			String nospaceline = letline.replace(" ", "");
			if(nospaceline.equals(nospacerot))
			{
				System.out.println(letline+" (is) "+rotate);
			}
			else
			{
				System.out.println(letline+" (not) "+rotate);
			}
		}
		
	}

}
