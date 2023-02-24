import java.io.FileInputStream;//required for I/O from file
import java.util.Scanner;//required for I/O from stdin
import java.util.ArrayList;//required for ArrayList generics
import java.util.List;//required for List generics
/**
 * PROBLEM: More things in heaven & earth, than poor ratios
 * DIFFICULTY LEVEL: LOW
 * ESTIMATED COMPLETION TIME NEEDED: 5-8 minutes
 * PROBLEM AUTHOR: Ken Duisenberg, ken.duisenberg@hpe.com  
 * SOLUTION AUTHOR: Robert McAdams, mcadams@hpe.com, 1-916-240-0615
 * LAST MODIFIED: 2019-02-20
 * WHAT IT TESTS: 
 * 	1.) Ability to create a mathematical operation to check for prime numbers (this will be the sticking point) 
 * 	2.) Ability to create a square root and cube root (X^1/y) function that checks if a number itself IS a square or cube root, slightly different thinking than what high school students normally encounter, could trip some students up
 * 	3.) Ability to create a "next even number" math function -- I seriously doubt ANY of the teams will miss this one ;) 
 *  4.) Ability to understand and program solutions for intermediate programming concepts such as order of operations, keeping track of data, splitting a string, formatting output, implementing algorithms.
 *  
 * PROBLEM DESCRIPTION: 
 * 
 * You gotta know how to do math to get through CodeWars.  So, show your style!
 * 
 * ## Input
 * 
 * 	Each line of input has 2 positive integers N and M, separated by one space. 
 *  The first integer (N) is between 0 and 1 million.  
 *  The second (M) will be a 0, 1, 2, or 3.  
 *  Your program must find the next integer that is Even (M=0), a Prime (M=1), a Square (M=2) or a Cube (M=3).
 * 	
 * 	12 3
 * 	20 2
 * 	999999 3
 * 	3 3
 * 	12 0
 * 	0 0
 * 
 * ## Output
 * 
 * 	For each line, your program must output the next positive integer greater than N that is Even (0), Prime (1), a Square (2), or a Cube (3).  If both N and M equal 0, your program should end (and not print).
 * 	
 * 	27
 * 	25
 * 	1000000
 * 	8
 * 	14
 * 	
 * */
public class prob07 {
	/** SOLUTION:
	 * -----------------------------------------------------------------------------------------
	 * STUDENT DATA:
	 * -----------------------------------------------------------------------------------------
	 * 1.) Tests Prime, Square and Cube operations, all with fairly high(ish) numbers
	 * 2.) Same as 1, just different numbers
	 * 3.) Tests all operations 
	 * -----------------------------------------------------------------------------------------
	 * JUDGE DATA:
	 * -----------------------------------------------------------------------------------------
	 * 1.) Tests all operations with random large and small numbers
	 * 2.) Tests all operations with random large and small numbers
	 * 3.) Tests all operations with random large and small numbers
	 * -----------------------------------------------------------------------------------------
	 * NOTES:
	 * 
	 * Biggest problem for this one will be for students to implement a "is this number prime"
	 * check, as there are no built-in libraries in the standard Java Developer Kit which 
	 * they can call to do that for them. Also checking for if a number itself is a square
	 * or a cube root number will be backwards from the logic they usually use in school
	 * which would be to simply find a square or cube root. 
	 * 
	 * Other than that, everything else should be fairly standard boilerplate
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
		//List<String> lines = readFromFileToArrayList("C:\\CodeWars2019\\probBE-Its-CodeWars-MathTime-McAdams\\probBE-student-3-in.txt");
		//PROCESS THE DATA
		for(String line:lines){
			parseOperation(line);
		}
	}
	private static void parseOperation(String line){
		String[] parts = line.split(" ");
		if (parts.length > 1 && !line.trim().equals("0 0"))
		{
			//Even (M=0), a Prime (M=1), a Square (M=2) or a Cube (M=3).
			if (parts[1].trim().equals("0")){
				mathOpNextEven(parts[0].trim());
			}
			else if (parts[1].trim().equals("1")){
				mathOpNextPrime(parts[0].trim());
			}
			else if (parts[1].trim().equals("2")){
				mathOpNextSquare(parts[0].trim());
			}
			else if (parts[1].trim().equals("3")){
				mathOpNextCube(parts[0].trim());
			}
		}
	}
	private static void mathOpNextEven(String input){
		int num = Integer.parseInt(input);
		if (num % 2 == 0){
			num +=2;
		}
		else{
			num +=1;
		}
		System.out.println(""+num);
	}
	/**
	 * A prime number (or a prime) is a natural number greater than 1 that cannot be formed 
	 * by multiplying two smaller natural numbers. A natural number greater than 1 that is 
	 * not prime is called a composite number. For example, 5 is prime because the only ways 
	 * of writing it as a product, 1 × 5 or 5 × 1, involve 5 itself.
	 * 
	 * There is no built-in library to check this in Java, so we'll have to write one
	 * (and by we, I mean "me" ^_-)
	 * */
	private static void mathOpNextPrime(String input){
		int num = Integer.parseInt(input);
		boolean found = false;
		while (!found){
			num +=1;
			if (isPrime(num)){
				found = true;
			}
		}
		System.out.println(""+num);
	}
	private static boolean isPrime(int n){
	    if(n < 2) return false;//zero and 1 are not considered prime
	    if(n < 4) return true;//1,2 and 3 are not considered prime
	    if(n % 2 == 0) return false;//if it can be evenly divided by 2, then it has 2 as a factor, so not prime
	    double sqrt = Math.sqrt(n);//using square root as a ceiling for division check, after that point, we would simply be checking factors of the same base numbers. High school students most likely wouldn't know about this shortcut, but that's okay, the numbers they will be using won't run into performance issues that are measurable anyway :D
	    int sqrtCeiling = (int)Math.ceil(sqrt);//taking the ceiling of the square root because for loops require ints
	    for(int i = 3; i <= sqrtCeiling; i+=2){//starting with 3, and incrementing by 2 so all checks will be on odd numbers
	    	if(n % i == 0) return false;//if we ever find a number that we can divide into the number evenly, it isn't prime
	    }
	    return true;//if we get here, nothing failed the test, so it is prime
	}
	private static void mathOpNextSquare(String input){
		int num = Integer.parseInt(input);
		boolean found = false;
		while (!found){
			num +=1;
			double result = Math.sqrt(num);//using implicit conversion to double from int
			double floor = Math.floor(result);
			double ceil = Math.ceil(result);
			if (result == floor && result == ceil){
				found = true;
			}
		}
		System.out.println(""+num);
	}
	private static void mathOpNextCube(String input){
		//this is literally just a copy/paste from mathOpNextSquare with an operation change
		//to Math.cbrt. Ideally, a better implementation would be a power ^ 1/x implementation
		//and simply supply the x factor to use, but this works for a simple problem
		int num = Integer.parseInt(input);
		boolean found = false;
		while (!found){
			num +=1;
			double result = Math.cbrt(num);//using implicit conversion to double from int
			double floor = Math.floor(result);
			double ceil = Math.ceil(result);
			if (result == floor && result == ceil){
				found = true;
			}
		}
		System.out.println(""+num);
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
