import java.util.*;
import java.io.*;
public class prob08 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		Scanner in= new Scanner(new FileReader(new File("input.txt")));
		while(in.hasNextLine())
		{
			String cur = in.nextLine();
			while(cur.length()>80)
			{
				//System.out.println(cur);
				for(int i=80;i>=0;i--)
				{
					if(cur.charAt(i)==' ')
					{
						System.out.println(cur.substring(0,i).trim());
						cur = cur.substring(i).trim();
						break;
					}
				}
			}
			System.out.println(cur);
		}
		
	}

}
