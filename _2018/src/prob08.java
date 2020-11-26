import java.util.*;
import java.io.*;

public class prob08{

    static String file = "prob08";
    static Scanner in;
    static PrintWriter out;
    static int start;
    static int maxLength;
    static int length;
    
    public static void main(String[] args) throws IOException{
        //for(int i = 1; i <= 3; i++) {
            in = new Scanner(System.in);//new File(file + "-" + 1 + "-in.txt"));
            out = new PrintWriter(new File("out.txt"));
            
            boolean go = true;
            while (go) {
                start = in.nextInt();
                maxLength = in.nextInt();
                if (start == 0 && maxLength == 0)
                    break;
                init();
                solve();
            }
            
            in.close();
            out.close();
           
            //Check.check("out.txt", file+"-"+1+"-out.txt");
        //}
    }
    
    public static void init() {

        length = 0;
            
    }
    
    public static void solve() {
        String temp = "";
        String ta = start + "";
        if (ta.length() > maxLength)
            start = 0;
        else {
            while (length < maxLength) {
                String te = temp;
                te += start;
                if (te.length() > maxLength) {
                    start--;
                    break;
                }
                else {
                    temp = te;
                    start++;
                }
                
            }
        }
        System.out.println(start + " " + " " + maxLength + " " + " " + start);
        
    }
}