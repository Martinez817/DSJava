/*
 * 1/24/24
 * Sw Design with Java 
 * Jonathan Martinez
 * 
 * 
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.text.NumberFormat; 
import java.util.Locale; 

public class Delimitors {
    public static void main(String[] args) {
        try {
             File file = new File("customerdata.txt");
            Scanner in = new Scanner(file);

        in.useDelimiter("[,\\s\\n]+");

        System.out.println(",--------------------------------------------------,");
        System.out.printf("| %-7s | %-20s | %-15s |%n", "ID", "Name", "Balance");
        System.out.println("'--------------------------------------------------'");

        
        while (in.hasNext()){
            int id = in.nextInt(); 
            String country = in.next(); 
            double balance = in.nextDouble(); 

            String formattedBalance = NumberFormat.getCurrencyInstance(Locale.US).format(balance);
            
            System.out.printf("| %06d | %-20s | %-15s  |%n", id, country, formattedBalance); 
        }
        
        in.close();
        System.out.println("'--------------------------------------------------'");
        } catch (FileNotFoundException e) {
            System.out.printf("%n%nFile not Found.%n%n");

        }
         
        
    
    }
}

