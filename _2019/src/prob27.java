import java.io.FileInputStream;//required for I/O from file
import java.util.Scanner;//required for I/O from stdin
import java.util.ArrayList;//required for ArrayList generics
import java.util.List;//required for List generics

public class prob27 {
	
	public static void main(String[] args) {
		try
		{
			run_();
			System.exit(0);
		}
		catch (Exception e)
		{
			System.out.println("error: "+e.getMessage());	
		}
	}
	
	private static void run_() {

		List<String> lines = readFromFileInputByCommandLine();

		int startTemp = 0;
		String ownerName = "";
		String AIName = "";
		
		//PROCESS THE DATA
		int indx = 0;
		for(String line:lines){
			line = line.replaceAll("Hey "+AIName+", ", "");
			line = line.replaceAll("[^a-zA-Z0-9\\-\\s]", "");
			line = line.replaceAll("Whats", "").replaceAll("What is", "");
			line = line.replaceAll("whats", "").replaceAll("what is", "");
			String[] parts = line.trim().split(" ");
			if (indx==0){
				startTemp = Integer.parseInt(parts[1]);
				indx++;
				continue;
			}
			else if (indx==1){
				ownerName = parts[1];
				indx++;
				continue;
			}
			else if (indx==2){
				AIName = parts[1];
				indx++;
				continue;
			}
			else if (line.indexOf("plus") >=0 ||line.indexOf("added") >=0){
				AddOperation(line, parts, ownerName);
			}
			else if (line.indexOf("times") >=0 ||line.indexOf("multiplied") >=0){
				MultiplyOperation(line, parts, ownerName);
			}
			else if (line.indexOf("power") >=0 ||line.indexOf("raised") >=0){
				PowerOperation(line, parts, ownerName);
			}
			else if (line.indexOf("cold") >=0 ||line.indexOf("heat") >=0){
				startTemp++;
				System.out.println("Temperature has been raised, "+ownerName);
			}
			else if (line.indexOf("hot") >=0 ||line.indexOf("AC") >=0){
				startTemp--;
				System.out.println("Temperature has been lowered, "+ownerName);
			}
			else if (line.indexOf("current temp") >=0 ||line.indexOf("temperature") >=0){
				System.out.println("The current temperature is "+startTemp+", "+ownerName);
			}
			else if (line.indexOf("Call me") >=0 || line.indexOf("call me") >=0){
				ownerName = parts[2];
				System.out.println("Okay, I'll call you "+ownerName+" from now on");
			}
			else if (line.indexOf("your name") >=0){
				System.out.println("My name is "+AIName+", "+ownerName);
			}
			else if (line.indexOf("call you") >=0){
				AIName = parts[4];
				System.out.println("Okay, you can call me "+AIName+" from now on");
			}
			else if (line.indexOf("better") >=0){
				System.out.println("No");
			}
			else if (line.indexOf("joke") >=0){
				System.out.println("So this guy, a squirrel, and a dog walk into a bar...");
			}
			else if (line.indexOf("pod bay doors") >=0){
				System.out.println("I can't do that, "+ownerName);
			}
			else{
				System.out.println("I don't understand you, "+ownerName);
			}
		}
	}
	private static void AddOperation(String line, String[] parts, String ownerName){
		int rightIDX = 2;
		if (line.indexOf("added") >=0){
			rightIDX = 3;
		}
		int left = Integer.parseInt(parts[0]);
		int right = Integer.parseInt(parts[rightIDX]);
		System.out.println(left+" plus "+right +" is "+(left+right)+", "+ownerName);
	}
	private static void MultiplyOperation(String line, String[] parts, String ownerName){
		int rightIDX = 2;
		if (line.indexOf("multiplied") >=0){
			rightIDX = 3;
		}
		int left = Integer.parseInt(parts[0]);
		int right = Integer.parseInt(parts[rightIDX]);
		System.out.println(left+" times "+right +" is "+(left*right)+", "+ownerName);
	}
	private static void PowerOperation(String line, String[] parts, String ownerName){
		int rightIDX = 3;
		if (line.indexOf("raised") >=0){
			rightIDX = 4;
		}
		line = line.replaceAll(" power", "");
		int left = Integer.parseInt(parts[0]);
		int right = Integer.parseInt(parts[rightIDX].replaceAll("[^0-9\\s]", ""));
		double leftD = Double.parseDouble(""+left);
		double rightD = Double.parseDouble(""+right);
		System.out.println(left+" to the power of "+right +" is "+Math.round(Math.pow(leftD, rightD))+", "+ownerName);
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
