/*
 * 
 * 10/29/24
 * SW Design with Java
 * Jonathan Martinez 
 * 
 * This program is used to roll and display a dice. 
 * 
 * 
 */
import java.util.Scanner; 
import java.util.Random; 

public class DiceRolling {
    public static void main(String[] args) {
        Die die = new Die(); 
        Scanner in = new Scanner (System.in); 
        System.out.printf("%nThank you for choosing the Martinez Dice Rolling experience! %n");

        while (true){
            System.out.printf("%nWhat would you like to do with the die?: %nROll - Rolls the dice value %nDISPLAY - Displays the dice %nVALUE - Gives the value of the Dice %nQUIT - Ends the program %n%n"); 
            String input = in.nextLine(); 
            if (input.equals("ROLL")){
                die.roll(); 
            } else if (input.equals("DISPLAY")){
                die.display(); 
            } else if (input.equals("VALUE")){
                die.value();
            } else if (input.equals("QUIT")){
                System.out.println("Thank you for playing! Have a good day!"); 
                break; 
            } else {
                System.out.printf("%nInvalid Input. Try again.%n"); 
            }

        }
        in.close(); 
    }

}
/*
 * Methods: 
 * roll(): used to roll the dice and change the dice value 
 * display(): used to display the Dice image in the terminal
 * value(): used to state the value of the dice in case the user doesn't want to see the image (lame) 
 * 
 */

class Die { 
    Random random = new Random();
    private int diceValue; 

    public void roll() {
        diceValue = random.nextInt(6) + 1;
        System.out.printf("%nThe Dice has been rolled!%n");
    } 
    public void value(){
        System.out.printf("%nYou rolled a " + diceValue + "!%n"); 
    }
    public void display(){
        System.out.println("          "); 
        System.out.println("+-------+"); 
        switch (diceValue){
            case 1: 
                System.out.println("|       |");
                System.out.println("|   0   |");
                System.out.println("|       |");
                break;
            case 2:
                System.out.println("| 0     |");
                System.out.println("|       |");
                System.out.println("|     0 |");
                break;
            case 3:
                System.out.println("| 0     |");
                System.out.println("|   0   |");
                System.out.println("|     0 |");
                break;
            case 4: 
                System.out.println("| 0   0 |");
                System.out.println("|       |");
                System.out.println("| 0   0 |"); 
                break;   
            case 5: 
                System.out.println("| 0   0 |");
                System.out.println("|   0   |");
                System.out.println("| 0   0 |");
                break; 
            case 6:
                System.out.println("| 0   0 |");
                System.out.println("| 0   0 |");
                System.out.println("| 0   0 |");
                break; 
        }

        System.out.printf("+-------+%n");
    }
}