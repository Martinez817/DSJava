import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class ReadWriteExample {
    public static void main(String[] args) throws FileNotFoundException {
        File inputFile = new File("scores.txt");
        Scanner in = new Scanner(inputFile);

        File outputFile = new File("scoresFormatted.txt");
        PrintWriter out = new PrintWriter(outputFile);

        while (in.hasNext()) {
            double score = in.nextDouble();
            out.printf("%6.2f%n", score);
        }
        in.close();
        out.close();
    }
}
