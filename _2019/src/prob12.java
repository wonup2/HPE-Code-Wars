import java.io.FileInputStream;//required for I/O from file
import java.util.Scanner;//required for I/O from stdin
import java.util.ArrayList;//required for ArrayList generics
import java.util.List;//required for List generics


public class prob12 {
	
	public static void main(String[] args) {
		try
		{
			run_();
		}
		catch (Exception e)
		{
			System.out.println("error: "+e.getMessage());	
		}
	}
	
	private static void run_() {		
		
		double s = 1;//Signal for the next operation
		double pi = 3;//establishing all of the numbers as doubles so Java will behave itself when doing division
		double one = 1;
		double two = 2;
		double four = 4;
		int n = 20000;
		int digit = 0;		
		//PROCESS THE DATA
		int counter = 0;


		for (int i = 2; i <= (n*2); i+=2){
			double current = (double)i;
			pi = pi + s * (four / (current * (current + one) * (current + two)));
			s = -1 * s;
		}
		System.out.println(pi);
		String piString = ""+pi;
		
		String[] output = piString.split("|");
		System.out.println(output[digit+1]);
	}
}