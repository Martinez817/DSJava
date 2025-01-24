/*
 * 1/24/24
 * Sw Design with Java 
 * Jonathan Martinez 
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Birth {
    public static void main(String[] args) {
        System.out.println();
        try {
            File file = new File("birthyears.txt");
            Scanner in = new Scanner(file); 

            in.useDelimiter(",\\s");

            while (in.hasNext()){
                String input = in.nextLine();
                String[] p = input.split(",");

                String name = p[0]; 
                String birthyear = p[1]; 

                if (birthyear.equalsIgnoreCase("n/a")){
                    System.out.printf("%s's birthyear is unknown.%n", name); 
                } else {
                    try {
                        int year = Integer.parseInt(birthyear);
                        System.out.printf("%s was born in %d%n", name, year);

                    } catch (NumberFormatException e){
                        System.out.printf(""); 
                    }
                }

                

            }
            in.close(); 
            System.out.println(); 
        } catch (FileNotFoundException e){
            System.out.printf("%The File was not found.%N");
        }

    }
}
