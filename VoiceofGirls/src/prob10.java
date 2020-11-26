import java.util.*;
import java.io.*;

public class prob10 {

	static Scanner in;
	static String[] sent;
	static List<String> nouns, adverbs, verbs, adj;

	public static void main(String[] args) {
		try {
				in = new Scanner(new File("input.txt"));
				init();
				solve();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void init() {
		sent = in.nextLine().split(" ");
		nouns = new ArrayList<String>();
		adverbs = new ArrayList<String>();
		verbs = new ArrayList<String>();
		adj = new ArrayList<String>();
		String temp = in.nextLine();
		while (!temp.equals("ADVERBS")) {
			temp = in.nextLine();
			if (temp.equals("ADVERBS"))
				break;
			nouns.add(temp);
		}
		while (!temp.equals("VERBS")) {
			temp = in.nextLine();
			if (temp.equals("VERBS"))
				break;
			adverbs.add(temp);
		}
		while (!temp.equals("ADJECTIVES")) {
			temp = in.nextLine();
			if (temp.equals("ADJECTIVES"))
				break;
			verbs.add(temp);
		}
		while (in.hasNextLine()) {
			temp = in.nextLine();
			adj.add(temp);
		}
	}

	public static void solve() {
		String sentence = "";
		for (int i = 0; i < 2; i++) {
			sentence = "";
			for (int j = 0; j < sent.length; j++) {
				if (sent[j].equals("[N]")) {
					sentence += nouns.get(0) + " ";
					nouns.remove(0);
				} else if (sent[j].equals("[AV]")) {
					sentence += adverbs.get(0) + " ";
					adverbs.remove(0);
				} else if (sent[j].equals("[V]")) {
					sentence += verbs.get(0) + " ";
					verbs.remove(0);
				} else if (sent[j].equals("[AJ]")) {
					sentence += adj.get(0) + " ";
					adj.remove(0);
				} else
					sentence += sent[j] + " ";
			}
			sentence = sentence.substring(0, sentence.length() - 1);
			System.out.println(sentence);
		}
	}
}
