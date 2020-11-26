import java.util.*;
import java.io.*;

public class prob10 {

	public static void main(String[] args) throws IOException{

		BufferedReader in = new BufferedReader(new FileReader("input.txt"));
		
		String input = in.readLine();
		String[] sent = input.split(" ");
		String next = "";
		ArrayList<String> nouns = new ArrayList<String>();
		ArrayList<String> adverbs = new ArrayList<String>();
		ArrayList<String> verbs = new ArrayList<String>();
		ArrayList<String> adjectives = new ArrayList<String>();
		while(!next.equals("END")) {
			if(next.equals("NOUNS")) {
				next = in.readLine();
				while(!next.equals("ADVERBS")) {
					nouns.add(next);
					next = in.readLine();
				}
			}
			else if(next.equals("ADVERBS")) {
				next = in.readLine();
				while(!next.equals("VERBS")) {
					adverbs.add(next);
					next = in.readLine();
				}
			}
			else if(next.equals("VERBS")) {
				next = in.readLine();
				while(!next.equals("ADJECTIVES")) {
					verbs.add(next);
					next = in.readLine();
				}
			}
			else if(next.equals("ADJECTIVES")) {
				next = in.readLine();
				while(!next.equals("END")) {
					adjectives.add(next);
					next = in.readLine();
				}
			}
			else {
				next = in.readLine();
			}
		}
		//System.out.println(adjectives);
		
		for(int i = 0; i < 2; i++) {
			String tempans = "";
			for(int j = 0; j < sent.length; j++) {
				if(!sent[j].equals("[N]")&&!sent[j].equals("[AV]")&&!sent[j].equals("[V]")&&!sent[j].equals("[AJ]")) {
					tempans+=sent[j]+" ";
				}
				else if(sent[j].equals("[N]")) {
					tempans+=nouns.get(0)+ " ";
					nouns.remove(0);
				}
				else if(sent[j].equals("[V]")) {
					tempans+=verbs.get(0)+" ";
					verbs.remove(0);
				}
				else if(sent[j].equals("[AV]")) {
					tempans+=adverbs.get(0)+" ";
					adverbs.remove(0);
				}
				else if(sent[j].equals("[AJ]")) {
					tempans+=adjectives.get(0)+" ";
					adjectives.remove(0);
				}
			}
			System.out.println(tempans);
		}
		
	}

}
