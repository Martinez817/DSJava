/*
 * 
 * 10/27/24 
 * Sw design with Java 
 * Jonathan Martinez  
 * 
 * This program is used to display how much money a customer earns with a given interest rate. 
 * 
 */
import java.util.Scanner; 
public class InterestRates {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Welcome to Martinez Big Bank of Money! "); 

       
        double interestRate = 0.0; 
        double userBalance = 0.0; 
        int year = 1; 

        //input checker - found out about "in.hasNext___();", pretty snazzy in my opinion for this 
        while (true){ 
            System.out.print("Enter in the interest rate (APR) as a percentage (Example: 1.5): ");
           if (in.hasNextDouble()){
               interestRate = in.nextDouble(); 
               if (interestRate >= 0.0){
                   break; 
               } else {
                   System.out.println("Please input a positive number for your interest rate. "); 
               }
            
           } else {
            System.out.println("Invalid input: Please enter a value. "); 
            in.next(); 

           } 
       }
       
       while (true){ 
        System.out.print("Enter in your initial balance as a decimal (Example: 234.34): ");
       if (in.hasNextDouble()){
           userBalance = in.nextDouble(); 
           if (userBalance >= 0.0){
               break; 
           } else {
               System.out.println("Please input a positive number for your balance. "); 
           }
       } else {
        System.out.println("Invalid input. Please enter a value. "); 
        in.next(); 

       } 
   }

        // This may seem ludacris to do, but it's all about the attention to detail 
        System.out.println("--------------------------------------------------");
        System.out.println("| Year |   Interest Amount   |   Total Balance   |"); 
        System.out.println("--------------------------------------------------");

        while (year < 6){
            double interestAmount = userBalance * (interestRate / 100.0); 
            double adjustedBalance = interestAmount + userBalance;
            // lots of space for money because this is the martinez bank of big money 
            System.out.printf("| %4d | $%18.2f | $%16.2f |%n", year, interestAmount, adjustedBalance);
            userBalance = adjustedBalance; 
            year++; 

        }
        
        System.out.println("--------------------------------------------------");
        System.out.print("Do with this what you will. Have a good day!"); 

        in.close();
    }
    
}
