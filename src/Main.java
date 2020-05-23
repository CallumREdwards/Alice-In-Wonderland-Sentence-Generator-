import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    static final String TRAINING_PATH = "resources/alice.txt";
    static final String INITIAL_WORD = "the".toLowerCase();
    static final int SENTENCE_LENGTH = 12;

    public static void main(String[] args) {
        try {
            String[] tokens = tokenize(new FileReader(TRAINING_PATH));
            BigramGenerator bigramGenerator = new BigramGenerator(tokens);
            prettyPrint(bigramGenerator.generate(INITIAL_WORD, SENTENCE_LENGTH));
        } catch (IOException e) {
            System.out.println("File error at " + TRAINING_PATH);
            e.printStackTrace();
        }
    }

    private static void prettyPrint(String[] sentence) {
        String output = String.join(" ", sentence);
        output = output.substring(0, 1).toUpperCase() + output.substring(1) + ".";
        System.out.println(output);
    }

    private static String[] tokenize(FileReader fileReader) throws IOException {
        BufferedReader reader = new BufferedReader(fileReader);
        return reader.readLine().split(" ");
    }
}
