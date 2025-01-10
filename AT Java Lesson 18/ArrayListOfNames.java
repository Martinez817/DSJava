/*
 * 1/8/24
 * Sw Design with Java 
 * Jonathan Martinez
 */

import java.util.Scanner; 
import java.util.ArrayList; 

public class ArrayListOfNames {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in); 
        System.out.printf("%nWelcome to Martinez's Array of Names!"); 
        while (true){
            System.out.printf("%n%nHow would you like to use the program?: %nEnterNames - Enter names into the Array. %nQuit - Quits the program. %n%n");
            String input = in.nextLine(); 
            if (input.equalsIgnoreCase("EnterNames")) {
                ArrayShenanigans.enterNames(); 
            } else if (input.equalsIgnoreCase("Quit")){
                System.out.print("Have a good rest of your day!"); 
                in.close(); 
                break; 
            } else {
                System.out.print("Invalid Input, try again. "); 
            }
        }
    }

}

class ArrayShenanigans {
    static ArrayList<String> names = new ArrayList<String>(); 
    static int nameCount = 0; 

    static void enterNames(){
        Scanner in = new Scanner(System.in);
        while (true){
            System.out.printf("%nEnter in Name #%d (or type '#' to quit): ", nameCount);
            String inputedName = in.nextLine();
            try {
                if (inputedName.equals("#")){
                    System.out.printf("%nWithin the current array, the names recorded are: %n%n"); 
                        for (int i = 0; i < names.size(); i++) {
                            String name = names.get(i); 
                            System.out.println(name);
                        }
                        break; 
                } else {
                    names.add(inputedName);
                    nameCount++; 
                } 
            } catch(Exception e){
                System.out.printf("%nInvalid input: Try Again%n%n"); 

             }
            } 

    }
}   
