/*
 * 1/24/24
 * Sw Design with Java 
 * Jonathan Martinez
 * 
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Specify{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in); 
        while (true){
            // use "jams.txt" as the test file 
            System.out.printf("%nEnter the name of a file (or '#' to quit): "); 
             String fileName = in.nextLine(); 

            if (fileName.equalsIgnoreCase("#")){
                System.out.printf("%nHave a good rest of your day!%n%n"); 
                in.close(); 
                break;
            }
        try {
            File file = new File(fileName); 
            Scanner im = new Scanner(file); 

            while (im.hasNext()){
                String list = im.nextLine(); 
                String[] parts = list.split("\\s+");

                // An odd way of printing it out instead of using a for loop but it works
                System.out.printf("%s%n%s%n%s%n%s%n",parts[0], parts[1],parts[2], parts[3] );
            
            }
            im.close();
        } catch (FileNotFoundException e){
            System.out.printf("%nThere is no file containing that name. Please try again. %n%n");
        }
        
        }

    }
 }