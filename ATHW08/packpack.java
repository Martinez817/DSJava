/*
 * 1/22/24
 * Sw Design with Java 
 * Jonathan Martinez 
 * 
 */

import org.derryfield.math.Geometry;

public class packpack {
    public static void main(String[] args) {
        System.out.printf("%nThank you for using the Martinez Geometry calculator!%n%nHere is a test:%n"); 
        System.out.printf("%nIf the radius of the sphere is 4, then:%n");
        Geometry.calcVolSphere(4);
        Geometry.calcSurfSphere(4);
    }
}
