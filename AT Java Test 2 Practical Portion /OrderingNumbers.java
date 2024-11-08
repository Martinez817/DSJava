/*
 * 
 * 11/08/2024 
 * Sw Design with Java 
 * Jonathan Martinez 
 * 
 * This program is used to sort three integers in decreasing order that are given from the user. 
 * 
 */
import java.util.Scanner; 
public class OrderingNumbers {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in); 
        //getting the three numbers 
        System.out.print("What is your first number?: "); 
        int firstNumber = in.nextInt(); 

        System.out.print("What is your second number?: "); 
        int secondNumber = in.nextInt();

        System.out.print("What is your third number?: "); 
        int thirdNumber = in.nextInt();


        System.out.println("In decending order, your numbers are: "); 


        if (firstNumber > secondNumber && firstNumber > thirdNumber) {
            System.out.println(firstNumber); 
            if (secondNumber > thirdNumber){
                System.out.println(secondNumber); 
                System.out.println(thirdNumber);
            } else if (thirdNumber > secondNumber) {
                System.out.println(thirdNumber);
                System.out.println(secondNumber); 
            }
        }
        if (secondNumber > firstNumber && secondNumber > thirdNumber) {
            System.out.println(secondNumber); 
            if (firstNumber > thirdNumber){
                System.out.println(firstNumber); 
                System.out.println(thirdNumber);
            } else if (thirdNumber > firstNumber) {
                System.out.println(thirdNumber);
                System.out.println(firstNumber); 
            }
        }

        if (thirdNumber > firstNumber && thirdNumber > secondNumber) {
            System.out.println(thirdNumber); 
            if (firstNumber > secondNumber){
                System.out.println(firstNumber); 
                System.out.println(secondNumber);
            } else if (secondNumber > firstNumber) {
                System.out.println(secondNumber);
                System.out.println(firstNumber); 
            }
            in.close();
        
        }
    
    }
}
