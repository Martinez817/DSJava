
/*
 * 1/24/24
 * Sw Design with Java 
 * Jonathan Martinez
 *  
 * 
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CharCounter {
    public static void main(String[] args) {
        try {
            File file = new File("characters.txt"); 
            System.out.printf("%nThe 5 quick brown foxes jumped over the 42 lazy dogs. Mary had 57 little lambs.%n");
            Scanner in = new Scanner(file); 
            int totalChars = 0;
            int letterCount = 0;
            int digitCount = 0; 

            while (in.hasNextLine()){
                String line = in.nextLine(); 
                
                for (char c : line.toCharArray()){
                    totalChars++; 

                    if (Character.isLetter(c)){
                        letterCount++; 
                    } else if (Character.isDigit(c)){
                        digitCount++; 
                    }
                }

            }
            in.close(); 

            System.out.printf("%nTotal Characters: %d", totalChars);
            System.out.printf("%nTotal Letters: %d", letterCount);
            System.out.printf("%nTotal Numbers: %d%n%n", digitCount);


        } catch (FileNotFoundException e ){
            System.out.printf("%n%nFile Not Found. Try Again.%n%n");
        }


    }
}
