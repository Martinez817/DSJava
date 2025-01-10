/*
 * 1/9/24
 * Sw Design with Java 
 * Jonathan Martinez 
 * 
 */

import java.util.Scanner; 
import java.util.ArrayList; 

public class TemperatureTracker {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in); 
        System.out.printf("%nWelcome to Martinez's Temperature Tracker!%n%n");
        while (true){
            System.out.printf("How would you like to use the Program?: %nEnterTemps - Enter temperatures into the Array %nLowestTemp - Finds the lowest temperatures within the Array. %nQuit - Quits the Program. %n%n");
            String input = in.nextLine(); 
            if (input.equalsIgnoreCase("EnterTemps")){
                Temps.enterTemps(); 
            } else if (input.equalsIgnoreCase("LowestTemp")){
                Temps.lowestTemp(); 
            } else if (input.equalsIgnoreCase("Quit")){
                System.out.printf("%nHave a good rest of your day!%n%n"); 
                in.close(); 
                break; 

            }
        }
    }
}

class Temps {
    static ArrayList<Integer> list = new ArrayList<>(); 
    static int tempIndex = 0; 

    public static void enterTemps(){
        Scanner ink = new Scanner(System.in); 
        while (true){
            System.out.printf("%nEnter in a temperature (in Farhenheit) or type 'q' to quit: %n");
            String input = ink.nextLine();  
            if (input.equalsIgnoreCase("q")){
                System.out.printf("%n%n");
                break; 
            }
            try {
                Integer temperature = Integer.parseInt(input); 
                list.add(temperature); 

            } catch (NumberFormatException e) {
                System.out.printf("Invalid Input. Try again.");

            }
        }
    }

    public static void lowestTemp() {
            if (list.isEmpty()){
                System.out.printf("%nThere are no temps to print.%n"); 
            }

            Integer lowest = list.get(0);
            for (int i = 0; i < list.size(); i++){
                if (list.get(i) < lowest){
                    lowest = list.get(i); 
                }
            }

            System.out.printf("%nThese were the recorded temps:%n%n"); 
            for (int i = 0; i < list.size(); i++){
                int temp = list.get(i);
                if (list.get(i) == lowest){
                    System.out.printf( temp + " <-- Lowest Temp%n");
                } else {
                    System.out.printf(temp + "%n");
            }  
            }
            System.out.println();
    }
}
