import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class ReadExample {
    public static void main(String[] args) throws FileNotFoundException {
        File inputFile = new File("AT Java Lesson 19/scores.txt");
        Scanner in = new Scanner(inputFile);
       
        in.close(); 
    }
   
}
