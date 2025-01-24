/*
 * 
 * 
 * 
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;



public class Unemployment {
    public static void main(String[] args) {
        try {
             File file = new File("Top5Unemployment.txt");
            Scanner in = new Scanner(file);

        in.useDelimiter("[,\\s\\n]+");

        System.out.println(",--------------------------------------------------------------------,");
        System.out.printf("| TOP 5 UNEMPLOYMENT RATES (NATIONWIDE!!!!!!!!!)                 |%n");
        System.out.println("'--------------------------------------------------------------------'");

        System.out.println(",--------------------------------------------------------------------,");
        System.out.printf("| %-7s | %-20s | %-5s | %-25s |%n", "RANK", "COUNTRY", "RATE", "REGION");
        System.out.println("'--------------------------------------------------------------------'");

        
        while (in.hasNext()){ 
            String line = in.nextLine(); 
            String[] parts = line.split(",\\s*");

            String country = parts[0];
            double unemRate = Double.parseDouble(parts[1]);
            int rank = Integer.parseInt(parts[2]);
            String region = parts[3];

            System.out.println(",--------------------------------------------------------------------,");
            System.out.printf("|Rank #%02d: %-22s| %3.2f | %-25s |%n", rank, country, unemRate, region); 
            System.out.println("'--------------------------------------------------------------------'");
        }
        
        in.close();
        
        } catch (FileNotFoundException e) {
            System.out.printf("%n%nFile not Found.%n%n");

        }
         
        
    
    }
}
