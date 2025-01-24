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

public class MoreInputs {
    public static void main(String[] args) {
        try {
             File file = new File("sales_by_cat.txt");
            Scanner in = new Scanner(file);

        in.useDelimiter(",\\s*");

        System.out.println(",--------------------------------------------------,");
        System.out.printf("| %-15s | %-10s | %-15s   |%n", "DEPT", "NAME", "BALANCE");
        System.out.println("'--------------------------------------------------'");

        
        while (in.hasNext()){
            String line = in.nextLine(); 

            String[] parts = line.split((",\\s*"));

            String dept = parts[0];
            String name =  parts[1]; 
            String balanceString = parts[2]; 

            

            double balance; 
            if (balanceString.equalsIgnoreCase("n/a")){
                balance = 0.0; 
            } else {
                balance = Double.parseDouble(balanceString); 
            }

            String formattedBalance = NumberFormat.getCurrencyInstance(Locale.US).format(balance);

            System.out.printf("| %-15s | %-10s | %-15s  |%n", dept , name, formattedBalance);
             
        }
        
        in.close();
        System.out.println("'--------------------------------------------------'");
        } catch (FileNotFoundException e) {
            System.out.printf("%n%nFile not Found.%n%n");

        }
         
        
    
    }
}

