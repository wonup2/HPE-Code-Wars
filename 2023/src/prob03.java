//Joseph

import java.util.*;

public class prob03 {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		String[] trans = {
				"Start song",
				"Restart song",
				"Tempo up",
				"Tempo down",
				"Pause someone tripped",
				"Drop the bass",
				"Drop it lower!",
				"Pitch higher",
				"Pitch too high, shattering glass!",
				"Get my agent on the phone"
		};
		System.out.println(trans[n]);

	}

}