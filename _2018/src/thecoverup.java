import java.util.*;
import java.io.*;

public class thecoverup {

    public static void main(String[] args) throws IOException{
        Scanner in = new Scanner(System.in);
        
        int t = in.nextInt();
        for(int q = 0; q < t; q++) {
            int top = in.nextInt();
            int h = in.nextInt();
            
            //System.out.println(h);
            
            int sum = 0;
            int temp = (int) Math.sqrt(top);
            //System.out.println(temp);
            sum = top+(temp * 4);
            
            for(int i = 1; i < h; i++) {
                sum+=3;
                sum+=(temp+i)*4;
                sum+=(temp+i-2)*2;
            }
            System.out.println(sum + " liters");
        }
        
    }

}

/*
4
1 1
1 2
4 2
289 3

*/