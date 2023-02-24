import java.text.DecimalFormat;//required for rounding
import java.io.FileInputStream;//required for I/O from file
import java.util.Scanner;//required for I/O from stdin
import java.util.ArrayList;//required for ArrayList generics
import java.util.List;//required for List generics
/**
 * PROBLEM: At the end of your rope
 * DIFFICULTY LEVEL: LOW
 * ESTIMATED COMPLETION TIME NEEDED: 3-5 minutes
 * PROBLEM AUTHOR: Ken Duisenberg, ken.duisenberg@hpe.com  
 * SOLUTION AUTHOR: Robert McAdams, mcadams@hpe.com, 1-916-240-0615
 * LAST MODIFIED: 2019-02-26
 * WHAT IT TESTS: 
 * 1.  Ability to work with floating point decimal data types
 * 2.  Ability to read in a line of text and parse it
 * 3.  Ability to correctly multiply and divide correctly
 * 4.  Ability to implement an algorithm.
 *  
 * PROBLEM DESCRIPTION: 
 * 
 * The latest consideration for a CodeWars mascot has been put out to pasture, literally. The dejected goat has been tied to the corner of a barn in the middle of a grass field. At least he gets to eat!
 * 
 * ## Input
 * 
 * 	Read 1 positive integer, the length in feet of the rope. Maximum of 100 feet.
 * 	
 * 	20
 * 
 * ## Output
 * 
 * 	Print the area (in square feet of grass) the goat can reach. The rope is shorter than the walls of the barn. The area of a circle with radius r is A = Pi * r * r. Use Pi=3.14159.
 * 	
 * 	942.48
 * 
 * */
public class prob03 {
	/** SOLUTION:
	 * -----------------------------------------------------------------------------------------
	 * STUDENT DATA:
	 * -----------------------------------------------------------------------------------------
	 * 1.) Simple data set
	 * 2.) Simple data set
	 * 3.) Simple data set
	 * -----------------------------------------------------------------------------------------
	 * JUDGE DATA:
	 * -----------------------------------------------------------------------------------------
	 * 1.) Simple data set
	 * 2.) Simple data set
	 * 3.) Simple data set
	 * -----------------------------------------------------------------------------------------
	 * NOTES:
	 * 
	 * Aside from the students figuring out that they will need to take only 3/4 of the computed 
	 * area as the final answer, I cannot see any other possible difficulties with this problem.
	 * 
	 * The solution provided only uses libraries found in the standard Java Developer Kit (JDK), 
	 * no external modules or 3rd party libraries are used.
	 * */
	public static void main(String[] args) {
		try
		{
			run_();
		}
		catch (Exception e)
		{
			System.out.println("error: "+e.getMessage());	
		}
	}
	/**
	 * Parses all the data, implements the program logic, and calls the functions
	 * to output the results.
	 * */
	private static void run_() {
		//PARSE THE DATA IN
		//production
		List<String> lines = readFromFileInputByCommandLine();
		//debugging
		//List<String> lines = readFromFileToArrayList("C:\\CodeWars2019\\probBM-The Hungry Goat-2pts-McAdams\\probBL-judge-1-in.txt");
		//PROCESS THE DATA
		if (lines.size() > 0){
			int rope = Integer.parseInt(lines.get(0));
			double pi = 3.14159;
			double barnInWay = 0.75;//only can reach 3/4 of the area of the circle
			double area = (Math.pow(rope, 2)*pi)*barnInWay;
			DecimalFormat df = new DecimalFormat("0.00");
			System.out.println(df.format(area));
		}
	}
	private static List<String> readFromFileInputByCommandLine() {
		List<String> lines = new ArrayList<String>();//requires java.util.*
		Scanner input = new Scanner(System.in);
		try
		{
			while (input.hasNext())
			{
				String line = input.nextLine();
				lines.add(line);
			}
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			input.close();			
		}
		return lines;
	}
	private static List<String> readFromFileToArrayList(String filePath) {
		List<String> lines = new ArrayList<String>();// requires java.util.*
		FileInputStream fis = null;
		int i = 0;// holds the remaining bytes to read
		char c;// placeholder character holder
		char CR = (char) 13;// -> \r
		char LF = (char) 10;// -> \n
		try {
			fis = new FileInputStream(filePath);
			String line = "";
			while ((i = fis.read()) != -1) {
				c = (char) i;
				if (c != CR) {// if the character is the \r character, we are at the end of the line
					if (c != LF) {// non-Linux based file systems (like Windows) will add the new line (line feed)
								  // character as well, ignoring this
						line += c;
					}
				} else {
					lines.add(line);
					line = "";
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (fis != null) {
				try
				{
					fis.close();
				}
				catch (Exception ex)
				{
					ex.printStackTrace();
				}
			}
		}
		return lines;
	}
}
