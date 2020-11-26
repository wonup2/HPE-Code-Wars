
import java.util.*;
import java.io.*;
public class prob25 {
	public static void main(String[] args)throws IOException{
		Scanner in = new Scanner(new File("input.txt"));
		StringTokenizer st= new StringTokenizer(in.nextLine());
		int n = Integer.parseInt(st.nextToken());
		int q = Integer.parseInt(st.nextToken());
		 HashMap<String, String> map  = new HashMap<String,String>(); 
		 for(int i = 0; i < n; i++) {
			 st= new StringTokenizer(in.nextLine());
			 String num = st.nextToken();
			 String name = st.nextToken();
			 map.put(name, num);
		 }
		 queries[] loc = new queries[q];
		 for(int i = 0; i < q; i++) {
			 st= new StringTokenizer(in.nextLine());
			 loc[i] = new queries(st.nextToken(), st.nextToken());
		 }
		 int[] ans = new int[q];
		 for(int i = 0; i < q; i++) {
			 int xs = Integer.parseInt(map.get(loc[i].start).substring(0,2));
			 int ys = Integer.parseInt(map.get(loc[i].start).substring(2));
			 
			 int xd = Integer.parseInt(map.get(loc[i].dest).substring(0,2));
			 int yd = Integer.parseInt(map.get(loc[i].dest).substring(2));
			 
			 if(xs == xd) {
				 ans[i] = Math.abs(ys-yd);
				 continue;
			 }
			 int d = Math.abs(xs-xd);
			 if(d%2 == 0) {
				 int r1 = ys - (d/2);
				 int r2 = ys + (d/2);
				 if(yd <= r2 && yd >= r1) {
					 ans[i] = d;
					 continue;
				 }
				 if(yd > r2) {
					 ans[i] = yd -r2 + d;
				 }else
					 ans[i] = r1-yd + d;
			 }else {
				 int r1;
				 int r2;
				 if(xs %2 ==0) {
					 r1 = ys - (d/2);
					 r2 = ys + (d/2) + 1;
				 }else {
					 r1 = ys - (d/2) -1;
					 r2 = ys + (d/2);
				 }
				 if(yd <= r2 && yd >= r1) {
					 ans[i] = d;
					 continue;
				 }
				 if(yd > r2) {
					 ans[i] = yd -r2 + d;
				 }else
					 ans[i] = r1-yd + d;
			 }
			 
			 
		 }
		 for(int i = 0;i < ans.length; i++) {
			 System.out.println(loc[i].start + " " + loc[i].dest + " " + ans[i]);
		 }
	}
	static class queries{
		String start;
		String dest;
		public queries(String s, String d) {
			start = s;
			dest = d;
		}
	}
}
