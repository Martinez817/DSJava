/*
 * 02/04/25
 * Sw Design with Java 
 * Jonathan Martinez 
 */

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ihatedoingquizscoresagainandagainandagainandagainandagain {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in); 
        GettingQuizzy quizzy = new GettingQuizzy();

        System.out.printf("%n%nThank you for Using the Martinez Quiz Machine!%n");
        
        while (true){
            System.out.printf("%nHow would you like to use the Machine?%nADD: Add a quiz grade. %nQUIT: Quits the program. %n%n");
            String input = in.next(); 
            if (input.equalsIgnoreCase("quit")){
                System.out.printf("%nHave a good rest of your day!");
                break; 
            }
            else if (input.equalsIgnoreCase("Add")){
                quizzy.getQuizScore(in); 
            }
        }
    }

 }

 class GettingQuizzy {
    static int[] scores = new int[10];
    static int interval = 0; 

    public int getQuizScore(Scanner in){
        try {
            System.out.printf("%nWhat Score would you like to enter? (0-100): ");
            int score = in.nextInt(); 
            if (score < 101 && score > -1){

                if (interval < scores.length){

                scores[interval] = score; 
                System.out.printf("Score #%d is: %d", interval, scores[interval]);

                // this is extra code but I forgot to have it actually return a number but I also want "interval" to dop it's indexing
                // so int "p" is coming into play

                int p = scores[interval]; 
                interval++;

                return p; 
                } else {
                    System.out.printf("%nScore Array is Full.%n");
                    return -1;
                }
            } else {
                System.out.printf("%nInvalid score. Please Try again.%n");
                return -1;
            }
            
        } catch (InputMismatchException e){
            System.out.printf("Invalid input. Please try again.%n");
            in.next(); 
            return -1; 
            
        }

    }

 }