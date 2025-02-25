
import mow.*; 



public class PartB {
    public static void main(String[] args) {
        Yard yard = new Yard(6,8); 
        Mower moe = new Mower(1, 1, 1); 

        while (true){
            moe.mow(yard); 

            clearScreen();
            yard.print(moe);
            delay(500); 
            if (moe.checkInFront(yard)){
                moe.move(yard);
            } else {
                break; 
            }
        }
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
    public static void delay(long mseconds) {
        try {
            Thread.sleep(mseconds);
        } catch (InterruptedException e) {
            System.err.println("InterruptedException received!");
        }
    }

}
