import java.util.*;
import java.io.*;
public class prob30 {

	public static int n;
	public static int[][][] possible = {
			{{2,2},{2,1}},
			{{2,2},{1,2}},
			{{1,2},{2,2}},
			{{2,1},{2,2}},
			{{1,2},{1,2}},
			{{2,1},{2,1}},
			{{1,1},{2,2}},
			{{2,2},{1,1}},
			{{1,1},{1,2}},
			{{1,1},{2,1}},
			{{2,1},{1,1}},
			{{1,2},{1,1}}
	};
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new FileReader(new File("input.txt")));
		n =Integer.parseInt(in.readLine());
		//0 - ?, 1 - ., 2 - #
		int[][] grid =new int[n][n];
		for(int i =0;i<n;i++)
		{
			String line = in.readLine();
			for(int j =0;j<n;j++)
			{
				if(line.charAt(j)=='?')
				{
					grid[i][j] = 0;
				}
				else if(line.charAt(j)=='.')
				{
					grid[i][j] = 1;
				}
				else if(line.charAt(j)=='#')
				{
					grid[i][j] = 2;
				}
			}
		}
		twobytwo(grid);
		//printGrid(grid);
		backtrack(0,0,grid);
		//printGrid(grid);
		
	}
	public static void backtrack(int x, int y,int[][] grid)
	{
		if(y==n-1)
		{
			x++;
			y=0;
		}
		if(x==n-1)
		{
			//printGrid(grid);
			//System.out.println("--------------");
			if(works(grid))
			{
				printGrid(grid);
				System.exit(0);
			}
			return;
		}
		int topleft =grid[x][y];
		int topright = grid[x][y+1];
		int botleft = grid[x+1][y];
		int botright = grid[x+1][y+1];
		for(int i=0;i<possible.length;i++)
		{
			/*
			if(i==8)
			{
				System.out.println(topleft+" "+topright+" "+botleft+" "+botright);
				System.out.println(Arrays.toString(possible[i][0]));
				System.out.println(Arrays.toString(possible[i][1]));
				System.out.println(equals(topleft,topright,botleft,botright,possible[i]));
				printGrid(grid);
			}*/
			if(equals(topleft,topright,botleft,botright,possible[i]))
			{
				
				
				grid[x][y] = possible[i][0][0];
				grid[x][y+1] = possible[i][0][1];
				grid[x+1][y] = possible[i][1][0];
				grid[x+1][y+1] = possible[i][1][1];
				//if(x==0&&y==0)
					//printGrid(grid);
				if(connected(x,y,grid)&&connected(x,y+1,grid)&&connected(x+1,y,grid)&&connected(x+1,y+1,grid))
					backtrack(x,y+1,grid);
				grid[x][y] = topleft;
				grid[x][y+1] =topright;
				grid[x+1][y] =botleft;
				grid[x+1][y+1] = botright;
			}
		}
		
	}
	public static boolean connected(int x, int y, int[][] grid)
	{
		if(x>0&&(grid[x-1][y]==grid[x][y]||grid[x-1][y]==0))
			return true;
		if(x<grid.length-1&&(grid[x+1][y]==grid[x][y]||grid[x+1][y]==0))
			return true;
		if(y>0&&(grid[x][y-1]==grid[x][y]||grid[x][y-1]==0))
			return true;
		if(y<grid.length-1&&(grid[x][y+1]==grid[x][y]||grid[x][y+1]==0))
			return true;
		return false;
	}
	public static boolean equals(int tl,int tr, int bl, int br, int[][] check)
	{
		return (check[0][0]==tl||tl==0)&&(check[0][1]==tr||tr==0)&&(check[1][0]==bl||bl==0)&&(check[1][1]==br||br==0);
	}
	public static int typecount(int a, int b, int c, int d, int i)
	{
		int ans = 0;
		if(a==i)
			ans++;
		if(b==i)
			ans++;
		if(c==i)
			ans++;
		if(d==i)
			ans++;
		return ans;
	}
	public static boolean works(int[][] grid)
	{
		boolean outerblack = false;
		boolean outerwhite = false;
		for(int i =0;i<n;i++)
		{
			if(grid[0][i]==1||grid[i][0]==1||grid[i][n-1]==1||grid[n-1][i]==1)
				outerwhite=true;
			if(grid[0][i]==2||grid[i][0]==2||grid[i][n-1]==2||grid[n-1][i]==2)
				outerblack=true;
		}
		if(!outerblack||!outerwhite)
			return false;
		int cur = 0;
		boolean[][] vis =new boolean[n][n];
		for(int i =0;i<n;i++)
		{
			for(int j =0;j<n;j++)
			{
				if(vis[i][j])
					continue;
				dfs(i,j,grid[i][j],vis,grid);
				cur++;
			}
		}
		if(cur!=2)
			return false;
		
		return true;
	}
	public static void dfs(int x, int y, int color,boolean[][] vis,int[][] grid)
	{
		if(x<0||y<0||x>=n||y>=n||vis[x][y]||grid[x][y]!=color)
			return;
		vis[x][y] = true;
		dfs(x+1,y,color,vis,grid);
		dfs(x-1,y,color,vis,grid);
		dfs(x,y+1,color,vis,grid);
		dfs(x,y-1,color,vis,grid);
		
	}
	public static void printGrid(int[][] grid)
	{
		StringBuffer sb = new StringBuffer();
		for(int i=0;i<n;i++)
		{
			for(int j =0;j<n;j++)
			{
				if(grid[i][j]==0)
				{
					sb.append("?");
				}
				else if(grid[i][j]==1)
				{
					sb.append(".");
				}
				else
				{
					sb.append("#");
				}
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
	public static void twobytwo(int[][] grid)
	{
		for(int i =0;i<n-1;i++)
		{
			for(int j =0;j<n-1;j++)
			{
				int black =typecount(grid[i][j],grid[i+1][j],grid[i][j+1],grid[i+1][j+1],2);
				int white = typecount(grid[i][j],grid[i+1][j],grid[i][j+1],grid[i+1][j+1],1);
				if(white==3)
				{
					if(grid[i][j]==0)
						grid[i][j] =2;
					if(grid[i+1][j]==0)
						grid[i+1][j] =2;
					if(grid[i][j+1]==0)
						grid[i][j+1] =2;
					if(grid[i+1][j+1]==0)
						grid[i+1][j+1] =2;
				}
				if(black ==3)
				{
					if(grid[i][j]==0)
						grid[i][j] =1;
					if(grid[i+1][j]==0)
						grid[i+1][j] =1;
					if(grid[i][j+1]==0)
						grid[i][j+1] =1;
					if(grid[i+1][j+1]==0)
						grid[i+1][j+1] =1;
				}
			}
		}
	}

}
