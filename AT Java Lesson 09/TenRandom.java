/*
 * 
 * 10/29/24
 * SW Design with Java 
 * Jonathan Martinez
 * 
 * This program is used to generate 10 random numbers, then calculate the average 
 * 
 */

import java.util.Random; 
public class TenRandom {
   public static void main(String[] args) {
    Random random = new Random(); 
    double total = 0.0; 
    int count = 10;
    // when changing the count to 1000, the average still made sense since it came out to be between 1 and 10 (5.604). This makes
    // sense, given how averages are meant to represent the mean value of all the values combined. (Hence, if the values 
    // were only able to be between 1 and 10, then it makes sense that the average exists between 1 and 10 aswell.)

    
    System.out.print("These were the generated numbers:"); 

    for (int i = 0; i < count; i++){
        int randomNumber = random.nextInt(10)+ 1; 
        System.out.println(randomNumber);
        double adjustedTotal = total + randomNumber; 
        total = adjustedTotal;
    }

    double average = total / count; 

    System.out.print("The average of these generated numbers is: " + average + ".");

   } 
}
