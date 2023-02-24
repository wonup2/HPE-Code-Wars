import java.util.*;
import java.io.*;
public class prob11 {
	static String file = "prob11";
	static Scanner in;
	static PrintWriter out;
	public static void main(String[] args) {
		in = new Scanner(file+"-"+1+"-in.txt");
		int col = in.nextInt();
		int row = in.nextInt(); in.nextLine();
		String a[] = new String[row];
		for(int i=0; i<row; i++) {
			int n= in.nextInt();
			a[n] = in.nextLine();
		}
		
		for(int i=row-1; i>=0; i--) {
			out.print(i+a[i]+"\n");
		}
		
		for(int i=0; i<=col; i++) {
			out.print(i%10);
		}
		
	}

}


/*
30 8
2 \| | | |   |/       \   |   |
0   +-------+           +-+---+
1  \ | | |   /         \  |   |
5   /\       |     |
7            +-----+
3  | | +-+   | ____|__    +---+
4  +-+       |     |
6            |     |

*/

/*
7            +-----+
6            |     |
5   /\       |     |
4  +-+       |     |
3  | | +-+   | ____|__    +---+
2 \| | | |   |/       \   |   |
1  \ | | |   /         \  |   |
0   +-------+           +-+---+
*/