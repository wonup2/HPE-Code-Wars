import java.util.*;
import java.io.*;
public class prob08 {

    public static void main(String[] args) throws IOException{
        // TODO Auto-generated method stub
        Scanner in = new Scanner(new File("input.txt"));
        String inp = "";
        ArrayList<Integer> list = new ArrayList<Integer>();
        while(in.hasNextLine()) {
            String temp = in.nextLine();
            inp += temp +" "; 
            if(temp.charAt(temp.length() - 1) == '.')
                list.add(inp.lastIndexOf('.'));

        }
        String[] a = inp.split(" ");
        String res = "";
        int count = 0;
        for(int i = 0; i < a.length; i++) {
            if(list.contains(i)) {
                res += "\n";

            }
            if(a[i].length() + count <= 80) {
                res += a[i] + " ";
                count += a[i].length() + 1;
            }
            else {
                res += "\n";
                res += a[i] + " ";
                count = a[i].length() + 1;
            }
        }
        System.out.println(res);
    }

}