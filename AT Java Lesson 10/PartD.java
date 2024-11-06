/*
 * 
 *  11/6/24
 * Sw Design With Java 
 * Jonathan Martinez
 * 
 * 
 * 
 */

public class PartD {
    public static void main(String[] args) {
        // the formula for each row 
        System.out.printf("%n%n");

        for (int i = 1; i <= 5; i++) {

            // printing the periods 
            for (int a = 5; a > i; a--) {
                System.out.print(".");
            }
            // printing numbers when neccessary
            for (int b = 1; b <= i; b++) {
                System.out.print(i); 
            }
        
            System.out.println();
        }
        System.out.printf("%n%n");
    }
}
