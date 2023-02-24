import java.util.*;

public class prob21 {

	public static int n;
	public static int r;
	public static TreeSet<Long> set;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for(int c = 1;c<=t;c++)	{
			n = in.nextInt();
			r = in.nextInt();
			set = new TreeSet<Long>();
			for(int i = 0;i<n;i++)
				set.add(in.nextLong());
			System.out.println(c+": "+bSearch());
		}
	}
	public static long bSearch()
	{
		long l = 1;
		long r = (long)1e15;
		while(l<=r)
		{
			long mid = (l+r)/2;
			if(works(mid))
			{
				l = mid+1;
			}
			else
			{
				r = mid-1;
			}
		}
		return r;
	}
	public static boolean works(long a)
	{
		long pos = 0;
		HashSet<Long> already = new HashSet<Long>();
		for(int i =0;i<=r;i++)
		{
			//System.out.println(a+" "+pos);
			pos+=a;
			if(set.ceiling(pos)==null)
				return false;
			pos = set.ceiling(pos);
			if(already.contains(pos))
				return false;
			already.add(pos);
		}
		return true;
	}

}


/*
6
7 3
2 3 4 5 7 8 10
5 2
100 2 3 1 4
5 2
100 40 20 10 30
2 1
500000000000000 1000000000000000
5 2
200000000000000 400000000000000 600000000000000 800000000000000 1000000000000000
7 3
10 4 7 3 5 2 8
 */