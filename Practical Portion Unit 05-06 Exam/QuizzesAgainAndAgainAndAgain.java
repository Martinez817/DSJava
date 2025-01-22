/*
 * 1/21/24
 * Sw Design with Java 
 * Jonathan Martinez 
 * 
 * 
 */

import java.util.Scanner;

public class QuizzesAgainAndAgainAndAgain {
   public static void main(String[] args) {
    Scanner in = new Scanner(System.in); 
    double[] scores = new double[100]; 
    int count = 0;
    System.out.printf("%nThank you for Using the Martinez Book of Quiz Scores (for like the third or fourth time)%n");
    while (true){ 
        System.out.printf("%nEnter in a quiz score or 'q' to quit: "); 
        String input = in.nextLine(); 
        if (input.equalsIgnoreCase("q")) {
        System.out.printf("%nHave a good rest of your day!%n");
        break;
        }   
        else {
            try {
                if (count <scores.length){
                    double userIn = Double.parseDouble(input);
                    scores[count] = userIn;
                    count++;
                } else {
                System.out.printf("%nMaximum number of scores.%n");
                break; } 
                }catch (NumberFormatException e){
                System.out.printf("%nInvalid Input. Try again.%n");
            }
        }
    }
    System.out.printf("%n=-=-=-=-=-=-=-=%n");
    double total = 0.0;  
    double average = 0.0;
    for (int j = 0; j < count; j++){
        System.out.printf("%n%6.2f%n", scores[j]);
        total += scores[j];
    } 
    System.out.printf("%n=-=-=-=-=-=-=-=%n");
    average = total / count;
    System.out.printf("%nAverage: %6.2f%n", average);
    in.close();
    }
    
}


