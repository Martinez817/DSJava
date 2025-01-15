import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LowTempsWhileReadingFiles {
    public static void main(String[] args) throws FileNotFoundException {
        File inputFile = new File("temps.txt");
        Scanner in = new Scanner(inputFile);
        int[] array = new int[9];
        System.out.printf("%nWelcome to the File Reader!%n%n");

        while (in.hasNext()) {
            int lowest = array[1];
            for (int i = 0; i < array.length; i++){
                int temp = in.nextInt();
                array[i] = temp; 
                if (array[i] < lowest){
                    lowest = array[i];
                }
            }

            for (int j = 0; j < array.length; j++){
                if (array[j] <= lowest){
                    lowest = array[j];
                    System.out.printf(array[j] + " <-- Lowest%n"); 
                }
                if (lowest < array[j]){
                    System.out.println(array[j]); 
                }
    
            }
        } 
        System.out.printf("%nHave a good rest of your day!%n");  
        in.close();
       
    }
}
