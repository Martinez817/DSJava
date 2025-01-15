/*
 * 1/14/24
 * Sw Design with Java 
 * Jonathan Martinez 
 */

import java.io.File; 
import java.io.PrintWriter;
import java.util.Scanner;
import java.io.IOException;


public class QuizWhileReadingFiles {
    public static void main(String[] args) { 
        try {
            File inputFile = new File("quizzes.txt");
            Scanner in = new Scanner(inputFile); 
            double[] array = new double[10];
            PrintWriter output = new PrintWriter("quizzesMod.txt");

            double total = 0.0;
            double newTotal = 0.0; 
            double average = 0.0; 

            while (in.hasNext()){
                for (int i = 0; i < array.length; i++){
                    double score = in.nextDouble();
                    array[i] = score;
                    newTotal = total + array[i];
                    total = newTotal;
                }
                average = total / array.length; 
            
            }
        
            for (int i = 0; i < array.length; i++){
                output.printf("%nQuiz #" + i +": %6.2f" , array[i]);
                           
            }
            output.printf("%n----------------%n");
            output.printf("Average: %6.2f%n", average);

            in.close();
            output.close();



        } catch (IOException e){
            System.out.printf("%nThere was a problem with the code.%n%n");
        }
    }
}
