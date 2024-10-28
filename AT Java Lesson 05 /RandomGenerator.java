/*
 * 
 * 10/27/24
 * SW Desigin with Java 
 * Jonathan Martinez
 * 
 * This program is a playground-test of the Random class. 
 * 
 */
import java.util.Random; 
public class RandomGenerator {
    public static void main(String[] args) {
        for (int i = 0; i < 101; i++) {
            Random random = new Random(); 
            int number = random.nextInt(100);
            System.out.println(number);  

        }

        
    }
    
}
