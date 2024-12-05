/*
 * 
 * 12/6/24
 * Sw design with Java 
 * Jonathan Martinez 
 * 
 * 
 * 
 * Part A - 
 * 
 * 1) b - 2 
 * 2) c - array[5] = 1
 * 3) c - 4 
 * 
 * 
 */
public class Homework14 {
    public static void main(String[] args) {
        Double[] numbers = { 2.2, 1.0, 3.7, 4.1, 88.0 };
        double total = 0.0; 
        for (int i = 0; i < numbers.length; i++){
            System.out.println(numbers[i]);
            double adjustedTotal = total + numbers[i]; 
            total = adjustedTotal;   
        }
    double average = total / numbers.length; 
    System.out.println("Based on those numbers, the average is: " + average + "! Have a good day!"); 
    }
}
