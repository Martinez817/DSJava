/*
 * 12/12/24
 * Sw Design with java 
 * Jonathan Martinez 
 * 
 * This program stores an array with 10,000 integers 
 * 
 */
import java.util.Scanner; 
import java.util.Random; 
import java.util.Arrays; 

public class RandomArrays {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in); 
        while (true){
            System.out.printf("%nHow would you like to search through the array?: %nBINARY - performs a binary search through the Array. %nLINEAR - Performs a linear search through the Array %nQUIT - Quits the program %nBoth methods provide the time it took for the program to execute the search. %n%n");
            String input = in.nextLine(); 
            String upperCaseInput = input.toUpperCase(); 
            if (upperCaseInput.equals("BINARY")){
                System.out.printf("%nWhat is your target value for the Binary search?: "); 
                int targetValue = in.nextInt(); 
                in.nextLine(); 
                Array.binSearch(targetValue); 
            } else if (upperCaseInput.equals("LINEAR")){
                System.out.printf("%nWhat is your target value for the Linear search?: "); 
                int targetValue = in.nextInt(); 
                in.nextLine(); 
                Array.linearSearch(targetValue); 
            } else if (upperCaseInput.equals("QUIT")){
                System.out.printf("%nThank you for using the binary and linear search program. Have a good rest of your day!");
                break; 
            }

        }
        
        in.close();
    }
}

class Array {
    public static int[] values = new int[10000];
    public static Random random = new Random(); 
    
   static { 
    for (int i = 0; i < values.length; i++){
        values[i] = random.nextInt(0, 10000); 
        }
    }   
    
    public static void linearSearch(int targetValue) {
        int amount = 0; 
        long startTime = System.currentTimeMillis(); 
        for (int i = 0; i < values.length; i++){
            if (values[i] == targetValue){
                amount++;
            } 
        } if (amount == 0){
                System.out.printf("%nThe target value is not found in the Array."); 
        } 
        long endTime = System.currentTimeMillis(); 
        System.out.printf("%nThe target value %d appears in the array %d time(s). %n", targetValue, amount);
        System.out.printf("The Program took " + (endTime - startTime) + " ms. %n"); 

    }

    public static void binSearch( int targetValue){
        int[] copy = values.clone();  
        Arrays.sort(copy); 
        long startTime = System.currentTimeMillis(); 
        int index = Arrays.binarySearch(copy, targetValue);
        if (index >= 0){
            System.out.printf("%nThe target value appears in the Array at Array space: %d%n", index);
        } else if (index == 0) {
            System.out.printf("The target value does not appear in the Array.%n");
        } else {
            System.out.printf("Error: Invalid input.%n");
        }       
        long endTime = System.currentTimeMillis();
        System.out.printf("The Program took " + (endTime - startTime) + " ms. %n");
        
    }

}

