//Joseph
import java.util.*;
import java.io.*;

public class prob07_test {

	public static void main(String[] args) throws Exception {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String directory = in.readLine();
		String drone = in.readLine();
		
		File path = new File(System.getProperty("user.dir")+"\\files\\" + directory);
		
		File[] files = path.listFiles();
		for(File f: files) {
			Scanner i = new Scanner(f);
			while(i.hasNextLine()) {
				String line = i.nextLine();
				if(line.contains(drone)) {
					System.out.println(drone + " was found " + f.getName());
					return;
				}
			}
		}
		
	}

}