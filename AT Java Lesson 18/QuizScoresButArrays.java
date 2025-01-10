/*
 * 12-13-24
 * Sw Design With Java 
 * Jonathan Martinez 
 * 
 * This program stores quiz scores 
 * 
 * 
 */
import java.util.Scanner;

 

public class QuizScoresButArrays {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in); 
        System.out.printf("%nWelcome to the Martinez Gradebook of Good Grades!");

        while (true){
            System.out.printf("%nHow would you like to use this program today?%n%nENTER = Enter and store up to 100 scores. %nDROP - Drops the Lowest Score entered. %nAVERAGE - Finds the Average of the current scores entered. %nTEST - Provides Test Averages unrelated to the entered quiz scores %nQUIT - Quit the Program.  %n%n");
            String input = in.nextLine(); 
        String upperCaseInput = input.toUpperCase(); 
        if (upperCaseInput.equals("ENTER")){
            Quizes.enterScores(); 
        } else if (upperCaseInput.equals("DROP")){
            Quizes.dropLowestScore(); 
        } else if (upperCaseInput.equals("AVERAGE")){
            Quizes.average(); 
        } else if (upperCaseInput.equals("TEST")){
            Quizes.testAverage();
        }
        else if (upperCaseInput.equals("QUIT")){
            System.out.printf("%nThank you for using the Martinez Gradebook of Good Grades!%n Have a good rest of your day!");
            in.close(); 
            break; 
        }
      } 
    }  
}

    class Quizes {
        public static Double[] scores = new Double[100];  
        public static int scoreCount = 0; 

        public static void enterScores() {
            Scanner in = new Scanner(System.in); 

            while (scoreCount < scores.length){
                System.out.print("Enter in a score (or type 'q' to quit): ");
                String input = in.nextLine(); 
                if (input.equalsIgnoreCase("q")){
                    break; 
                }
                try {
                    Double score = Double.parseDouble(input);
                    if (score < 0){
                        System.out.print("Invalid: Score cannot be negative."); 

                    } else {
                        scores[scoreCount++] = score; 
                    } 
                } catch (NumberFormatException e) {
                        System.out.println("Invalid input. Please try again."); 
                    }
                }  
                System.out.printf("%nA total of %d quizzes were entered. %n ", scoreCount);
                printScores();
                
                System.out.printf("%n Would you like to drop the lowest score? ('y' for yes, 'n' for no) "); 
                String dropInput = in.nextLine(); 
                if (dropInput.equalsIgnoreCase("y")){
                    dropLowestScore(); 
                } else if (dropInput.equalsIgnoreCase("n")){
                    System.out.printf("%nNo scores were dropped."); 
                    printScores(); 

                } else {
                    System.out.println("Invalid input. No changes have been made. "); 
                    printScores(); 
                }
                
            }
            
            public static void printScores(){
                if (scoreCount == 0){
                    System.out.print("There are no scores to display. "); 
                }
                System.out.printf("%nThe Current Quiz Scores are as follows: %n"); 
                for (int i = 0; i < scoreCount; i++){
                    System.out.printf("%4.2f %n", scores[i]); 
                }
            }

            public static void dropLowestScore(){
                int posOfLow = 0; 
                for (int i = 1; i < scoreCount; i++){
                    if (scores[i] < scores[posOfLow]){
                        posOfLow = i; 
                    }
                }
                System.out.printf("%nBased on the Numbers in the Array, the lowest score is: " + scores[posOfLow] + "%n"); 
                for (int i = posOfLow; i < scoreCount - 1; i++){
                    scores[i] = scores[i + 1]; 
                }
                scores[--scoreCount] = null; 
                printScores(); 

            }

            public static void average(){
                double adjAverage = 0.0;
                for (int i = 0; i < scoreCount; i++ ){
                    adjAverage += scores[i];
                }
                double finAv = adjAverage / scoreCount; 
                System.out.printf("%nBased on the scores entered, the average is: %4.2f %n", finAv); 
            }

            public static double average(double... values){
                if (values.length == 0){
                    return 0.0;
                }
                double total = 0.0; 
                for (double value : values){
                    total += value; 
                } return total / values.length; 
            }

            public static void testAverage(){
                double test1 = average(10, 8, 9); 
                System.out.printf("%nTest Case 1: Average of {10, 8, 9} is: %4.2f%n", test1); 


                double[] testAv = {100, 90, 80, 100, 90}; 
                double test2 = average(testAv);
                System.out.printf("Test Case 2: Average of {100, 90, 80, 100, 90} is: %4.2f%n", test2); 

            }
        }
    