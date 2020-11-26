import java.util.*;
import java.io.*;
public class prob25 {
	
	static Scanner in;
	static int hexes, cases, ans;
	static int[][] odd = {{0, -1}, {1, -1}, {1, 0}, {0, 1}, {-1, 0}, {-1, -1}};
	static int[][] even = {{0, -1}, {1, 0}, {1, 1}, {0, 1}, {-1, 1}, {-1, 0}};
	static int startx, starty, endx, endy;
	static TreeMap<String, String> map = new TreeMap<String, String>();
	static String [][] grid;
	
	public static void main(String[] args) throws IOException{
		in = new Scanner(new File("input.txt"));
		init();
		in.close();
	}
	
	static void init() {
		hexes = in.nextInt();
		cases = in.nextInt(); in.nextLine();
		grid = new String[cases][2];
		for(int i = 0; i < hexes; i++) {
			String[] temp = in.nextLine().split(" ");
			map.put(temp[1], temp[0]);
		}
		for(int i = 0; i < cases; i++) {
			String[] temp = in.nextLine().split(" ");
			grid[i][0] = temp[0];
			grid[i][1] = temp[1];
			solve(temp);
		}
	}
	
	static int getx(String s) {
		return Integer.parseInt(s.substring(0, 2));
	}
	
	static int gety(String s) {
		return Integer.parseInt(s.substring(2));
	}
	
	static void solve(String[] arr) {
		ans = 0;
		String start = arr[0], end = arr[1];
		startx = getx(map.get(start)); starty = gety(map.get(start)); endx = getx(map.get(end)); endy = gety(map.get(end));
		while((startx != endx) || (starty != endy)) {
			if(startx == endx && endy < starty) { //case 1
				startx += odd[0][0];
				starty += odd[0][1];
				ans++;
			}else if(startx < endx) { //case 2 && 3
				if(startx % 2 == 0) {
					if(starty >= endy) {
						startx += even[1][0];
						starty += even[1][1];
					}else {
						startx += even[2][0];
						starty += even[2][1];
					}
				}else {
					if(starty > endy) {
						startx += odd[1][0];
						starty += odd[1][1];
					}else {
						startx += odd[2][0];
						starty += odd[2][1];
					}
				}
				ans++;
				//System.out.println(startx + " " + starty + " " + ans);
			}else if(endx > startx && endy >= starty) { //case 3
				if(startx % 2 == 0) {
					startx += even[2][0];
					starty += even[2][1];
				}else {
					startx += odd[2][0];
					starty += odd[2][1];
				}
				ans++;
			}else if(startx == endx && starty < endy) { //case 4
				startx += odd[3][0];
				starty += odd[3][1];
				ans++;
			}else { //case 5 && 6
				if(endx < startx) {
					if(startx % 2 == 0) {
						if(starty < endy) {
							startx += even[4][0];
							starty += even[4][1];
						}else {
							startx += even[5][0];
							starty += even[5][1];
						}
					}else {
						if(endy >= starty) {
							startx += odd[4][0];
							starty += odd[4][1];
						}else {
							startx += odd[5][0];
							starty += odd[5][1];
						}
					}
					ans++;
					//System.out.println(startx + " " + starty + " " + ans);
				}
			}
		}
		System.out.println(start + " " + end + " " + ans);
	}
	

}
