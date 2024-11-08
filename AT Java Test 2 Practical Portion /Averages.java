/*
 * 
 * 11/08/2024
 * Sw Design with Java 
 * Jonathan Martinez 
 * 
 * This program calculates the averages of all the numbers from 1 to 100 
 * 
 * 
 */

public class Averages {
    public static void main(String[] args) {
        int total = 0; 
        int count = 0; 
        for (int i = 1; i <= 100; i++){
            int newTotal = total + i; 
            total = newTotal; 
            count = count + 1; 
        }
        int average = total / count; 

        System.out.print("The average of all the numbers between 1 and 100 is: " + average + "! Have a good rest of your day! "); 
        
    }
}
