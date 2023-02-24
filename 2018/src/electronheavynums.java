import java.util.*;
import java.io.*;

public class electronheavynums {

    public static void main(String[] args) throws IOException{
        
        Scanner in = new Scanner(System.in);
        
        while(true) {
            int num = in.nextInt();
            if(num==0) {
                break;
            }
            String bin = Integer.toBinaryString(num);
            int cnt0 = 0;
            int cnt1 = 0;
            for(int i = 0; i < bin.length(); i++) {
                if(bin.charAt(i)=='1')
                    cnt1++;
                else
                    cnt0++;
            }
            if(cnt0>cnt1)
                System.out.println(num + " LIGHT");
            else if(cnt1>cnt0)
                System.out.println(num+ " HEAVY");
            else {
                System.out.println(num+ " BALANCED");
            }
        }
        
    }

}
/*
5
8
10
17
316
987654321
65536
8675309
0
*/