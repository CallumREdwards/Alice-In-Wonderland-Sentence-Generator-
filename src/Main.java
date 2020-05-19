import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    static final String TRAINING_PATH = "resources/alice.txt";

    public static void main(String[] args) {
        try {
            String[] tokens = tokenise(new File(TRAINING_PATH));
            BigramGenerator bigramGenerator = new BigramGenerator(tokens);
        } catch (FileNotFoundException e) {
            System.out.println("No file at " + TRAINING_PATH);
            e.printStackTrace();
        }
    }

    private static String[] tokenise(File file) throws FileNotFoundException {
        Scanner scanner = new Scanner(file);
        return scanner.next().split(" ");
    }
}
