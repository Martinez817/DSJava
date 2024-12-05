/*
 * 12/03/24
 * Jonathan Martinez
 * Sw Design with Java
 * 
 */
import java.util.Scanner; 

public class InClassChallenge {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        final int LENGTH = 100; 
        Double[] scores =  new Double[LENGTH];

        int currentNumber = 0; 

        while (true){
            System.out.println("Enter a test score or 'q' to quit: ");
            if (in.hasNext("q") || in.hasNext("Q")){
                in.next(); 

                System.out.println("Done with Input!");
                break; 
            }
            if (currentNumber < scores.length){
                double values = in.nextDouble(); 
                scores[currentNumber] = values; 
                currentNumber++; 
            } else if (currentNumber == scores.length) {
                System.out.println("The Memory is Full! "); 
                System.out.println("No more inputs!");
                break; 
            }

        }

        in.close();

    }
}
