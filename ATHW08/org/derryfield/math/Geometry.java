package org.derryfield.math;


public class Geometry { 

    public static double calcVolSphere(double r){
        double volume = (4.0 / 3.0) * Math.PI * Math.pow(r, 3);
        System.out.printf("%nThe Volume of the sphere is %6.2f%n", volume); 
        return volume;
    }

    public static double calcSurfSphere(double r){
        double surf = 4.0 * Math.PI * Math.pow(r, 2); 
        System.out.printf("%nThe Surface Area of the sphere is %6.2f%n", surf);
        return surf;
    }
}