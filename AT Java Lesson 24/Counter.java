/*
 * 1/23/24 
 * Sw Design with java 
 * Jonathan Martinez 
 * 
 */

import java.util.Scanner;

public class Counter {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in); 
        CountinCheese counter = new CountinCheese();
        System.out.printf("%n%nWhat is your name?: ");
        String name = in.nextLine(); 
        System.out.printf("%n%nHello %s!%n", name);
        System.out.printf("What is your age?: "); 
        int age = in.nextInt(); 
        System.out.printf("%n%nYou are %d years old!%n", age);

        while (true){
            System.out.printf("%nWelcome to the cake counter!%nHow would you like to use the program?%nC - Vote for Cake%nP - Vote for Pie%nGC- Gets the count of both%nS - Set the counter%nQ - Quit%n%n");
            String input = in.next(); 
            if (input.equalsIgnoreCase("c")){
                counter.countCake();
            } else if (input.equalsIgnoreCase("p")){
                counter.countPie();
            } else if (input.equalsIgnoreCase("gc")){
                counter.getCount();
            } else if (input.equalsIgnoreCase("s")){
                System.out.printf("Enter the number of votes for Cake: ");
                int c = in.nextInt(); 
                System.out.printf("Enter the number of votes for Pie: ");
                int p = in.nextInt(); 
                counter = new CountinCheese(c, p);
            } else if (input.equalsIgnoreCase("q")){
                System.out.printf("Goodbye %s!%n", name);
                in.close();
                break; 
            } else {
                System.out.printf("Invalid input!%n");
            }

        }

    }
}

class CountinCheese {
    private int cake;
    private int pie; 


    public CountinCheese() {
        cake = 0; 
        pie = 0; 
    }
    
    public CountinCheese(int p, int q) {
        cake = p; 
        pie = q; 
        System.out.printf("Set: Cake = %d, Pie = %d%n", cake, pie);
    }
    
    public void countCake(){
        cake++; 
    }
    
    public void countPie(){
        pie++;
    }
    
    public void getCount(){
        System.out.printf("%nCount: Cake: %d, Pie: %d%n", cake, pie);
    }
    

}


