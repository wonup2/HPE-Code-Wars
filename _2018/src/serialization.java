import java.util.*;
import java.io.*;

public class serialization {
    
    public static void main(String[] args) throws IOException{
        Scanner in = new Scanner(System.in);
        
        while(true) {
            int start = in.nextInt();
            int l = in.nextInt();
            if(start==0 && l==0) {
                break;
            }
            
            if((start+"").length()>l) {
                System.out.println(start + " " + l +" " + "0");
                continue;
            }
            String app = "";
            int counter = start;
            while(true) {
                String temp = app+(counter+"");
                if(temp.length()>l)
                    break;
                else {
                    app+=counter+"";
                    counter+=1;
                }
            }
            
            System.out.println(start + " " + l + " " + (counter-1));
            
        }
        
    }
    
/*
0 5
0 11
3 9
7 18
98 9
13 1
8192 1024
256 8192
0 0
 */
    
    static StreamTokenizer st;
    static int readInt() throws IOException{
        st.nextToken();
        return (int)st.nval;
    }
    
    static double readDouble() throws IOException{
        st.nextToken();
        return st.nval;
    }
    
    static String readString() throws IOException{
        st.nextToken();
        return st.sval;
    }
    
}