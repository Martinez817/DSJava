/*
 * 1/10/24
 * Sw Design with java 
 * Jonathan Martinez 
 * 
 */

import java.util.ArrayList;
import java.util.Scanner; 
public class Wrappers {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in); 
        System.out.printf("%nWelcome to the Martinez Wrapping Class!%n");
        while (true){
            System.out.printf("How would you like to use the program?: %nEnter - Enter Numbers and Displays only SOME %nQuit - Quits the program. %n%n"); 
            String input = in.nextLine(); 
            if (input.equalsIgnoreCase("Enter")){
                BigNumbers.enterNumbers(); 
            } else if (input.equalsIgnoreCase("Quit")) {
                System.out.printf("%nHave a good rest of your day!%n");
                in.close();
                break;
                }
            }
        }
    }



class BigNumbers { 
    static ArrayList<Integer> numbers = new ArrayList<Integer>();

    public static void enterNumbers() {
        Scanner in = new Scanner(System.in); 
        int index = 0; 
        while (true){ 
            System.out.printf("Enter Integer #%d (or type 'q' to quit): ", index); 
            String input = in.nextLine(); 
            if (input.equalsIgnoreCase("q")){
                System.out.printf("%n%n"); 
                break; 
            }
            try {
                Integer numb = Integer.parseInt(input);
                numbers.add(numb); 
                index++;  

            } catch (NumberFormatException e ){
                System.out.print("Invalid Input. Try again.");
            }
        }
        
        System.out.printf("%n%nBased on the numbers you entered, these were all the even numbers:%n "); 


        for (int s = 0; s < numbers.size(); s++){
            if (numbers.get(s) % 2 != 0){
                numbers.remove(s); 
            } else if (numbers.get(s) % 2 == 0){

            } 
        }
        System.out.print(numbers);
        System.out.printf("%n%n");


    }

    


}