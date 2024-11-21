/*
 * 11/6/24
 * Sw Design With Java 
 * Jonathan Martinez
 * 
 * 
 * 
 */
import java.util.Scanner; 
public class PartBB {
    // public static void main(String[] args) {
    // Scanner in = new Scanner(System.in);
    // System.out.print("Enter number of cookies: "); 
    // int num = in.nextInt();
    // double discount;
    // if (num > 6) {
    //  discount = 0.05;
    // } else if (num > 12) {
    //  discount = 0.10;
    // }
    // System.out.println("Discount = " + discount); 
    
    // problems - discount is not initialized to 0.00 - compile time error since it's being printed
    //          - if statements in the wrong order (should be bigger to smaller based on the > sign) - logic error 
    // 
    // This is a compile time error, and a logic error as well.  

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter number of cookies: ");
        int num = in.nextInt();
        double discount = 0.00;
        if (num > 12) {
        discount = 0.10;
        } else if (num > 6) {
        discount = 0.05;
        }
        System.out.println("Discount = " + discount);  
        in.close(); 
}
}
