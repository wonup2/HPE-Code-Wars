
import java.util.*;
import java.io.*;
public class prob17 {
	public static void main(String[] args)throws IOException {
		Scanner in = new Scanner (new File("input.txt"));
		String line = in.nextLine();
		int n = Integer.parseInt(line);
		String[] cities = new String[n];
		boolean[][] connected = new boolean[n][n];
		for(int i = 0; i < n; i++) {
			line = in.nextLine();
			cities[i] =line;

		} //System.out.println(Arrays.toString(cities));
		while(in.hasNext()) {
			StringTokenizer st = new StringTokenizer(in.nextLine());
			st.nextToken();
			String city1 = st.nextToken();
			st.nextToken();
			st.nextToken();
			st.nextToken();
			st.nextToken();
			String city2 = st.nextToken();
			st.nextToken();
			String type = st.nextToken();
			//System.out.println(city1+" "+city2);
			int cindex1 = 0;
			int cindex2 = 0;
			for(int i =0;i<n;i++)
			{
				if(city1.equals(cities[i]))
				{
					cindex1 = i;
				}
				if(city2.equals(cities[i]))
				{
					cindex2 = i;
				}
			}
			System.out.println(cindex1+" "+cindex2);
			if(!type.equals("air"))
			{
				connected[cindex1][cindex2]=true;
				connected[cindex2][cindex1] = true;
			}
			
		}
		System.out.println(Arrays.deepToString(connected));
		for(int k=0;k<n;k++)
		{
			for(int i=0;i<n;i++)
			{
				for(int j =0;j<n;j++)
				{
					connected[i][j] = connected[i][j]||(connected[i][k]&&connected[j][k]);
				}
			}
		}
		System.out.println(Arrays.deepToString(connected));

		for(int i =0;i<n;i++)
		{
			ArrayList<String> temp = new ArrayList<String>();
			for(int j =0;j<n;j++)
			{
				if(i!=j&&connected[i][j])
					temp.add(cities[j]);
			}
			if(temp.isEmpty())
			{
				System.out.println("City "+ cities[i]+" is remote and has no neighbours!");
			}
			else
			{
				System.out.print("City " +cities[i] +" is neighbour to Cities ");
				for(int k=0;k<temp.size()-1;k++)
					System.out.print(temp.get(k)+",");
				System.out.println(temp.get(temp.size()-1));
			}
		}
		
	}

}
