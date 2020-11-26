import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Scanner;

public class prob10_Palindrom {
	
	public static int value(char c) {
		return Character.isAlphabetic(c)?Character.toUpperCase(c)-'A'+1:1;
	}

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n;
		while((n=sc.nextInt())!=0) {
			char[] s=sc.nextLine().substring(1).toCharArray();
			boolean visit[]=new boolean[n];
			char ans[]=new char[n];
			int index=0;
			for(int i=0;i<n-1;i++) {
				ans[i]=s[index];
				visit[index]=true;
				int val=value(s[index]);
				for(;val>0;) {
					index++;
					if(index>=n)index=0;
					if(!visit[index])val--;
				}
			}
			ans[n-1]=s[index];
			for(char c:ans)System.out.print(c);
			System.out.println();
		}
	}
}

/*
12 Do Tee!iscdh
25 Yotei! mcgaeos'rued a drn
0

Decode This!
You're a decoding master!
*/
