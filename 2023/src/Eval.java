import jdk.jshell.JShell;
import java.lang.StringBuilder;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Eval {
    public static void main(String[] args) throws IOException {
        try(JShell js = JShell.create(); BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            js.onSnippetEvent(snip -> {
                if (snip.status() == jdk.jshell.Snippet.Status.VALID) {
                    System.out.println("➜ " + snip.value());
                }
            });

            System.out.print("> ");
            for (String line = br.readLine(); line != null; line = br.readLine()) {
                js.eval(js.sourceCodeAnalysis().analyzeCompletion(line).source());
                System.out.print("> ");
            }
        }
    }
}