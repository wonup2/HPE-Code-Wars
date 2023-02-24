import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class prob07 {
	static Scanner in;
	static File folder, listOfFiles[];
	static String directory, drone, data;
	
	public static void main(String[] args) throws IOException {
		in = new Scanner(System.in);
		
		directory = in.nextLine();
		drone = in.nextLine();
		
		folder = new File(System.getProperty("user.dir")+"\\files\\" +directory);
		listOfFiles = folder.listFiles();

		for (File file : listOfFiles) {
		    if (file.isFile()) {
		        Scanner readfile = new Scanner(file);
		        while (readfile.hasNextLine()) {
		          data = readfile.nextLine();
		          if (data.contains(drone)) {
		        	  System.out.println(drone+" was found "+file.getName().substring(0,file.getName().indexOf(".txt")));
		          }
		        }
		        readfile.close();
		    }
		}
	}
}