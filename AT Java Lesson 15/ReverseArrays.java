/*
 * 12/11/24
 * Sw Design with java 
 * Jonathan Martinez
 * 
 * This program is an interactable Array that holds 10 integers.
 */

import java.util.Arrays;
import java.util.Scanner; 
import java.util.Collections; 


public class ReverseArrays {
    public static void main(String[] args) {
     Scanner in = new Scanner(System.in); 
     
     while (true){
        System.out.printf("%nHow would you like to interact with the Array?: %nUP - Move up in the Array %nDOWN - Move down in the Array %nVIEW - View the current Array Space you're on %nCHANGE - Change the number at the current Array Space %nTARGET - Allows for user to input a target intger and counts how many times it appears in the Array. %nDISPLAY - Displays the current, unaltered Array %nREVERSE - Sorts, reverses, and displays the current array %nQUIT - Quit the program %n%n"); 
        String input = in.nextLine(); 
        String upperCaseInput = input.toUpperCase(); 
        if (upperCaseInput.equals("UP")){
            Array.moveUp(); 
        } else if (upperCaseInput.equals("DOWN")){
            Array.moveDown(); 
        } else if (upperCaseInput.equals("VIEW")){
            Array.viewArraySpace(); 
        } else if(upperCaseInput.equals("CHANGE")){
            Array.changeArray();    
        } else if(upperCaseInput.equals("TARGET")){
            Array.targetValue(); 
        } else if (upperCaseInput.equals("DISPLAY")){
            Array.displayArray(); 
        } else if (upperCaseInput.equals("REVERSE")){
            Array.sortArray(); 
        } else if (upperCaseInput.equals("QUIT")){
            System.out.print("Thank you for using this Array program. Have a good day! "); 
            in.close(); 
            break; 
        } else {
            System.out.printf("%nInvalid input. Try again.%n"); 
        }

     }

    }
}

   class Array { 
    public static Integer[] values = new Integer[20]; 
    public static int arrayStep = 0; 

    static {
        Arrays.fill(values, 0);
    }

    public static void moveUp() {
        if (arrayStep < 19){
            arrayStep++; 
            System.out.printf("%nCurrently at Array Space: " + arrayStep + "%n" ); 
            
        } else if (arrayStep == 19){
            System.out.printf("%nError: No more space above.%n"); 
            System.out.printf("Currently at Array Space: " + arrayStep + "%n"); 
        }
    } 
    public static void moveDown(){
        if (arrayStep > 0){
            arrayStep--; 
            System.out.printf("%nCurrently at Array Space: " + arrayStep + "%n"); 
        } else if (arrayStep == 0 ){
            System.out.printf("%nError: No more space below.%n"); 
            System.out.printf("Currently at Array Space: " + arrayStep + "%n" ); 
        }
    }

    public static void viewArraySpace(){

        System.out.printf("%nCurrently at Array Space: " + arrayStep + "%nThe value of Array step " + arrayStep + " is " + values[arrayStep] + ". %n" ); 

    }
    public static void changeArray(){

        Scanner in = new Scanner(System.in);
        System.out.printf("%nWhat would you like to change Array Step " + arrayStep + " to?:%n%n");
        values[arrayStep] = in.nextInt();   
        System.out.printf("%nArray Space " + arrayStep + " is now " + values[arrayStep] + ". %n");
        in.nextLine(); 
        // The resource leak is oddly neccessary..? I'm not 100% sure on why but if i add in.close then the change function 
        // doesn't work, probably something to do with the fact that there's twos scanners semi overlapping eachother
        // for a moment. 
    }
    public static void displayArray(){
        System.out.printf("%nThis is the current Array:%n "); 
        for (int i : values){
            System.out.print(i + " * "); 
        }
        System.out.printf("%n");
    }
    public static void targetValue(){
        Scanner in = new Scanner(System.in); 
        System.out.printf("%nWhat is your target integer value?: "); 
        int target = in.nextInt(); 
        int amount = 0;
        for (int i = 0; i < values.length; i++){
            if (values[i] == target){
                amount++; 
             }
        } 
        System.out.printf("In the Array, the integer %d shows up %d times.%n", target, amount);


    }

    public static void sortArray(){
        System.out.printf("%nThe current Array would be sorted and reversed as follows:%n"); 
        Integer [] sort = values.clone(); 
        Arrays.sort(sort, Collections.reverseOrder()); 
    

        for (int i : sort){
            System.out.print(i + ", ");

        }
        System.out.printf("%n"); 
       
    }

}
