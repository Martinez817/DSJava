/*
 * 
 * 11/15/24
 * Sw design with Java 
 * Jonathan Martinez 
 * 
 * This program is used to sort out the smallest number by using a parammerter method 
 * 
 */

public class SmallNumbers {
    public double Smallest(double x, double y, double z){
        double small = x; 
        
        if (y < small){
            small = y;
        }
        if (z < small){
            small = z; 
        }
        return small; 

    }

    public static void main(String[] args) {
     SmallNumbers small = new SmallNumbers(); 
     double lowestNumber = small.Smallest(26.0, 22.0, 19.0 ); 
     System.out.println("The smallest number between 26.0, 22.0, and 19.0 is: " + lowestNumber );

    }
}
