import java.util.*;
import java.io.*;
public class prob22 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		Scanner in = new Scanner(new FileReader(new File("input.txt")));
		TreeMap<Integer, Character> Estring = new TreeMap<Integer,Character>();
		TreeMap<Integer, Character> Astring = new TreeMap<Integer,Character>();
		Astring.put(0, 'A');
		Astring.put(2, 'B');
		Astring.put(3, 'C');
		Astring.put(5, 'D');
		Astring.put(7, 'E');
		Astring.put(8, 'F');
		Astring.put(10, 'G');
		Astring.put(12, 'A');
		Estring.put(0,'E');
		Estring.put(1,'F');
		Estring.put(3,'G');
		Estring.put(5,'A');
		Estring.put(7,'B');
		Estring.put(8,'C');
		Estring.put(10,'D');
		Estring.put(12,'E');
		while(in.hasNextLine())
		{
			String[] line = in.nextLine().split(" ");
			if(line.length==2)
			{
				int fret = (Integer.parseInt(line[0])+1)%13;
				Character note = line[1].charAt(0);
				if(note=='E')
				{
					System.out.println(Estring.ceilingEntry(fret).getValue());
				}
				else
				{
					System.out.println(Astring.ceilingEntry(fret).getValue());
				}
			}
			else
			{
				if(line[0].length()==0)
					break;
				Character note = line[0].charAt(0);
				String ret = "";
				for(int i:Estring.keySet())
				{
					if(Estring.get(i)==note)
					{
						ret+=i+" E ";
					}
				}
				for(int i:Astring.keySet())
				{
					if(Astring.get(i)==note)
					{
						ret+=i+" A ";
					}
				}
				System.out.println(ret.substring(0,ret.length()-1));
			}
		}
		
	}

}
