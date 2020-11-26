import java.util.*;
import java.io.*;

public class wevegotyoucovered {

	public static void main(String[] args) throws IOException{
		
		Scanner in = new Scanner(System.in);
		
		int t = in.nextInt();
		int[] sites = new int[t];
		for(int q = 0; q < t; q++) {
			int rou = in.nextInt();
			Routers[] rlist = new Routers[rou];
			for(int i = 0; i < rou; i++) {
				int x = in.nextInt();
				int y = in.nextInt();
				int rad = in.nextInt();
				rlist[i] = new Routers(x, y, rad);
			}
			int r = in.nextInt();
			int c = in.nextInt();
			//System.out.println(c);
			in.nextLine();
			//String[][] room = new String[r][c];
			ArrayList<Routers> students = new ArrayList<Routers>();
			for(int i = 0; i < r; i++) {
				String line = in.nextLine();
				for(int j = 0; j < c; j++) {
					char temp = line.charAt(j);
					if(temp=='#') {
						students.add(new Routers(i, j, 0));
					}
				}
			}
			//System.out.println(Arrays.toString(rlist));
			int count = 0;
			for(int i = 0; i < rou; i++) {
				Routers curr = rlist[i];
				for(int j = 0; j < students.size(); j++) {
					Routers currstud = students.get(j);
					double dis = Math.sqrt(Math.pow((curr.x-currstud.x), 2)+ Math.pow((curr.y-currstud.y), 2));
					if(dis<curr.rad) { 
						count++;
						students.remove(j);
						j--;
						
					}
					//System.out.println(students.toString());
				}
			}
			sites[q] = count;
		}
		for(int i = 1; i < t+1; i++) {
			System.out.println("Site " + i + ": " + sites[i-1] + " students get coverage");
		}
		
	}
	
	static class Routers{
		
		int x;
		int y;
		int rad;
		Routers (int x, int y, int rad){
			this.x = x;
			this.y = y;
			this.rad = rad;
		}
		
		public String toString() {
			return x + " " + y + " " + rad;
		}
		
	}
	
}
