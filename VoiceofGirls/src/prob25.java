import java.io.*;
import java.util.*;

public class prob25 {
	static Scanner in;
	static int N;
	static int M;
	static Map<String, String> planet;
	public static void main(String[] args) throws IOException{
		in = new Scanner (new File("input.txt"));
		init();
		for(int i = 0; i < M; i++){
			solve();
		}
		
		in.close();

	}
	static void init(){
		planet = new LinkedHashMap<String, String>();
		N = in.nextInt();
		M = in.nextInt();
		for(int i = 0; i < N; i++){
			String temp1 = in.next();
			String temp2 = in.next();
			planet.put(temp2, temp1);
		}
		//System.out.println(planet);
	}
	static void solve(){
		String start = in.next();
		String end =  in.next();
		//System.out.println(start + " " + end);
		int sx = Integer.parseInt(planet.get(start).substring(0,2));
		int sy = Integer.parseInt(planet.get(start).substring(2));
		int ex = Integer.parseInt(planet.get(end).substring(0,2));
		int ey = Integer.parseInt(planet.get(end).substring(2));
		//System.out.println(sx+" " + sy+" " + ex+ " " + ey);
		
		int count = 0;
		
		boolean check = true;
		while(true) {
            if(sx==ex && sy==ey) break;
            count++;
            if(sx%2==0) {
                if(sx < ex && sy < ey) {
                    sx++;
                    sy++;
                }
                else if(sx < ex && sy > ey) {
                    sx++;
                }
                else if(sx > ex && sy < ey) {
                    sx--;
                    sy++;
                }
                else if(sx > ex && sy > ey) {
                    sx--;
                }
                else if(sx == ex && sy > ey) {
                    sy--;
                }
                else if(sx == ex && sy < ey) {
                    sy++;
                }
                else if(sy == ey && sx > ex) {
                    sx--;
                }
                else if(sy == ey && sx < ex) {
                    sx++;
                }
            }
            else{
            	 if(sx < ex && sy < ey) {
                     sx++;
                 }
                 else if(sx < ex && sy > ey) {
                     sx++;
                     sy--;
                 }
                 else if(sx > ex && sy < ey) {
                     sx--;
                 }
                 else if(sx > ex && sy > ey) {
                     sx--;
                     sy--;
                 }
                 else if(sx == ex && sy > ey) {
                     sy--;
                 }
                 else if(sx == ex && sy < ey) {
                     sy++;
                 }
                 else if(sy == ey && sx > ex) {
                     sx--;
                 }
                 else if(sy == ey && sx < ex) {
                     sx++;
                 }
            }
        }
		
		System.out.println(start + " " + end + " " + count);
	}
}
