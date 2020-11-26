import java.io.*;
import java.util.*;
public class prob29 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		Scanner in = new Scanner(new FileReader(new File("input.txt")));
		TreeMap<String,Integer> variables = new TreeMap<String,Integer>();
		boolean comment = false;
		int linenum = 1;
		boolean FOR = false;
		boolean IF = false;
		boolean FUNC = false;
		ArrayList<pair> errors = new ArrayList<pair>();
		String prevline ="";
		while(in.hasNextLine())
		{
			String line = in.nextLine();
			if(line.equals(""))//maybe possible here for trailing or something
			{
				linenum++;
				continue;
			}
			String[] nospace = line.trim().split(" ");
			if(nospace[0].equals("NEXT"))
			{
				FOR = false;
			}
			else if(nospace[0].equals("ENDIF"))
			{
				IF = false;
			}
			else if(nospace[0].equals("ENDFUNC"))
			{
				FUNC = false;
			}
			if(FOR||IF||FUNC)
			{
				if(line.substring(0,4).equals("    "))
				{
					line= line.substring(4);
					if(line.charAt(0)==' ')
					{
						errors.add(new pair(":20 Unexpected indentation",linenum));
					}
					for(int i =0;i<line.length();i++)
					{
						if(line.charAt(i)!=' ')
						{
							line = line.substring(i);
							break;
						}
					}
					String nowhite = line.trim();
					if(!line.equals(nowhite))
					{
						errors.add(new pair(":30 Trailing whitespace",linenum));
					}
				}
				else
				{
					errors.add(new pair(":20 Unexpected indentation",linenum));
				}
			}
			else
			{
				
				if(line.charAt(0)==' ')
				{
					errors.add(new pair(":20 Unexpected indentation",linenum));
				}
				for(int i =0;i<line.length();i++)
				{
					if(line.charAt(i)!=' ')
					{
						line = line.substring(i);
						break;
					}
				}
				String nowhite = line.trim();
				if(!line.equals(nowhite))
				{
					errors.add(new pair(":30 Trailing whitespace",linenum));
				}
				
			}
			ArrayList<String> remove = new ArrayList<String>();
			for(String s:variables.keySet())
			{
				if(nospace[0].equals("#"))
					break;
				if(line.contains("$"+s))
				{
					remove.add(s);
				}
			}
			for(String s:remove)
				variables.remove(s);
			if(nospace[0].equals("FOR"))
			{
				FOR = true;
			}
			else if(nospace[0].equals("IF"))
			{
				IF = true;
			}
			else if(nospace[0].equals("FUNC"))
			{
				FUNC = true;
				String funcname = nospace[1].substring(0,nospace[1].length()-1);
				if(!comment||!prevline.trim().split(" ")[1].equals(funcname))
				{
					errors.add(new pair(":40 Func declaration without documentation",linenum));
				}
			}
			else if(nospace[0].equals("VAR"))
			{
				variables.put(nospace[1], linenum);
			}
			if(nospace[0].equals("#"))
			{
				comment = true;
			}
			else
			{
				comment = false;
			}
			prevline = line;
			linenum++;
		}
		for(String variable:variables.keySet())
		{
			errors.add(new pair(":10 Variable declared but not used",variables.get(variable)));
		}
		
		
		Collections.sort(errors);
		
		for(pair a:errors)
		{
			System.out.println(a);
		}
		
	}
	static class pair implements Comparable<pair>
	{
		String word;
		int ind;
		public pair(String word, int ind)
		{
			this.word = word;
			this.ind = ind;
		}
		public int compareTo(pair that)
		{
			if(this.ind==that.ind)
				return this.word.compareTo(that.word);
			return this.ind-that.ind;
		}
		public String toString()
		{
			return ind+word;
		}
	}

}
