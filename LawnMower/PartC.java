/*
 * 2/25/25
 * Sw Design with java 
 * Jonathan Martinez 
 * 
 * 
 * 
 */

import java.util.Scanner;
import mow.*; 
import java.util.Random;

public class PartC {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in); 
        Random rand = new Random(); 

        System.out.println("\nThank you for using the virtual Lawn Mower!");
        System.out.print("Please enter the height of the yard: ");
        int height = in.nextInt();
        System.out.print("Please enter the width of the yard: ");
        int width = in.nextInt();

        Yard yard = new Yard(height, width);
        int moeX = rand.nextInt(width - 2) + 1;
        int moeY = rand.nextInt(height - 2) + 1;
        int moeDir = rand.nextInt(4);
        Mower moe = new Mower(moeX, moeY, moeDir);

        while (!yard.isCleared()) {
            clearScreen();
            yard.print(moe);
            delay(500); 

            moe.mow(yard);

            if (moe.checkInFront(yard)) {
                moe.move(yard);
            } else {
                moe.wanderUntilGrass(yard);
            }
        }

        clearScreen();
        yard.print(moe);
        System.out.println("\nThe entire yard has been mowed!");
        in.close();
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void delay(long milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            System.err.println("Error: Interrupted while sleeping!");
        }
    }
}