/*
 * 
 * 10/29/24
 * Sw design with Java 
 * Jonathan Martinez 
 * 
 * This program is used to calculate the average of multiple grades a user inputs
 * 
 */
import java.util.Scanner; 

public class GradeAverage {
    public static void main(String[] args) {
        Scanner in = new Scanner (System.in);
        int numberOfScores = 0; 
        int gradeNumber = 1; 
        double totalScorePool = 0;  
    
        System.out.println("Welcome to the Martinez Average Grade Calculator! Enter a positive value to continue calculating your average, or a negative value to see your final average."); 

        while (true){
            System.out.println("What is the value of Grade #" + gradeNumber + "?: "); 
            if (in.hasNextDouble()){
                double score = in.nextDouble();
                if (0.0 < score){
                    gradeNumber++;
                    numberOfScores++; 
                    double adjustedScorePool = totalScorePool + score; 
                    totalScorePool = adjustedScorePool; 
                }
                else if (0.0 > score){ 
                    double average = totalScorePool / numberOfScores; 
                    System.out.print("Based on all " + numberOfScores + " of your scores, your average is: " + average + ". Have a good day!" ); 
                    break; 
                } 
            } else {
                System.out.print("Invalid input. Try again. "); 
                in.next();
            }                
            
        }
        
        in.close(); 

    } 

}
