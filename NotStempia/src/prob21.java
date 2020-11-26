import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.*;
import java.io.*;

public class prob21 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		Scanner in = new Scanner(new FileReader(new File("input.txt")));
		DecimalFormat df = new DecimalFormat("0.00");
		df.setRoundingMode(RoundingMode.HALF_DOWN);
		//System.out.println(df.format(24.565));
		while(in.hasNextLine())
		{
			String name = in.nextLine().split(" ")[1];
			double rate = Double.parseDouble(in.nextLine().split(" ")[1]);
			int intime1 = Integer.parseInt(in.nextLine().split(" ")[1]);
			int outtime1 = Integer.parseInt(in.nextLine().split(" ")[1]);
			int intime2 = Integer.parseInt(in.nextLine().split(" ")[1]);
			int outtime2 = Integer.parseInt(in.nextLine().split(" ")[1]);
			//System.out.println(intime1 +" "+outtime1+" "+intime2+" "+outtime2);
			int intimeminutes1 = 60*(intime1/100)+intime1%100;
			int outtimeminutes1 = 60*(outtime1/100)+outtime1%100;
			int intimeminutes2 = 60*(intime2/100)+intime2%100;
			int outtimeminutes2 = 60*(outtime2/100)+outtime2%100;
			//System.out.println(intimeminutes1 +" "+outtimeminutes1+" "+intimeminutes2+" "+outtimeminutes2);
			double money = 0;
			money+=rate*(outtimeminutes1-intimeminutes1)/60;
			money+=rate*(outtimeminutes2-intimeminutes2)/60;
			//System.out.println(money);
			System.out.println(name+" earned $"+ df.format(money));
		}
		
	}

}
