import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
public class prob11 {

    public static void main(String[] args) throws FileNotFoundException {
        // TODO Auto-generated method stub
        Scanner in = new Scanner(new File("prob11-3-in.txt"));
        int c = in.nextInt();
        while(c-->0)
        {
            int n = in.nextInt();
            int[] score = new int[n];
            String[] names = new String[n];
            for(int i = 0;i<n;i++)
            {
                score[i] = in.nextInt();
                names[i] = in.nextLine().trim();
            }
            long max = 0;
            int maxsize = 0;
            int endl = 0;
            int endr = -1;
            int l = 0;
            long cur = 0;
            for(int i =0;i<n;i++)
            {
                cur+=score[i];
                if(cur<0)
                {
                    cur=0;
                    l = i+1;
                }
                if(cur>max)
                {
                    max = cur;
                    endl = l;
                    endr = i;
                }
                else if(cur==max&&i-l+1>maxsize)
                {
                    endl = l;
                    endr = i;
                    maxsize = i-l+1;
                }
            }
            
            if(endr==-1)
                System.out.println("None");
            else
            {
                if(endr==endl)
                {
                    System.out.println(names[endl]);
                }
                else
                {
                    System.out.println(names[endl]+" to "+names[endr]);
                }
            }
            
        }
        
    }

}