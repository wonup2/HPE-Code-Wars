import java.util.*;
import java.io.*;

public class prob15 {

	public static void main(String[] args) throws IOException{

		BufferedReader in = new BufferedReader(new FileReader("input.txt"));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		while(n!=0||m!=0) {
			String[] sent1 = new String[n];
			String[] sent2 = new String[m];
			String[] og1 = new String[n];
			String[] og2 = new String[m];
			st = new StringTokenizer(in.readLine());
			for(int i = 0; i < n; i++) {
				String temp = (st.nextToken()+"");
				sent1[i] = temp.toLowerCase();
				og1[i] = temp;
			}
			st = new StringTokenizer(in.readLine());
			for(int i = 0; i < m; i++) {
				String temp = (st.nextToken()+"");
				sent2[i] = temp.toLowerCase();
				og2[i] = temp;
			}
			for(int i = 0; i < n; i++) {
				System.out.print(og1[i]+ " ");
			}
			System.out.println();
			for(int i = 0; i < m; i++) {
				System.out.print(og2[i]+ " ");
			}
			Set<String> dupes = new HashSet<String>();
			for(int i = 0; i < n; i++) {
				String curr1 = sent1[i];
				for(int j = 0; j < m; j++) {
					String curr2 = sent2[j];
					if(curr1.equals(curr2)) {
						sent1[i] = "%";
						sent2[j] = "(";
						dupes.add(curr1);
						curr1="%";
						curr2="(";
					}
				}
			}
			
			System.out.println();
			System.out.print(dupes.size()+" ");
			for(String str:dupes) {
				System.out.print(str+" ");
			}
			System.out.println();
			
			
			st = new StringTokenizer(in.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
		}
		
	}

}
