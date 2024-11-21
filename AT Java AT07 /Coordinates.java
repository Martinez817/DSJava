/*
 * 
 * 11/19/24
 * Sw Design with Java 
 * Jonathan Martinez 
 * 
 */

public class Coordinates {
    double x; 
    double y; 

    public Coordinates() { 
        double x = 0; 
        double y = 0; 
    }

    public Coordinates(int z, int t){
         x = z; 
         y = t; 
    }

    public double getX(){ 
        return x; 
    }
    public double getY(){
        return y; 

    }
    public double getRadius(){
        double radius = Math.sqrt((x * x) + (y * y)); 
        return radius;  
    }
    public double getAngle(){
        double radians = Math.atan2(y , x);
        double angle = radians * (180 / Math.PI); 
        return angle;
    }

    public void translate(int dx, int dy){
        x += dx;
        y += dy; 
    }
    public double distanceTo(Coordinates other){
        double dx = x - other.x; 
        double dy = y - other.y; 
        return Math.sqrt((dx * dx) + (dy * dy)); 
    }



 
public static void main (String[] args){
    Coordinates p1 = new Coordinates(); 
    System.out.printf("%nPoint 1 stats: %n");
    System.out.println("x is equal to: " + p1.getX()); 
    System.out.println("y is equal to: " + p1.getY()); 
    System.out.println("r is equal to: " + p1.getRadius()); 
    System.out.printf("Theta is equal to: " + p1.getAngle() + "%n%n" ); 
    
    Coordinates p2 = new Coordinates(5,6); 
    System.out.println("Point 2 stats: "); 
    System.out.println("x is equal to: " + p2.getX()); 
    System.out.println("y is equal to: " + p2.getY()); 
    System.out.println("r is equal to: " + p2.getRadius()); 
    System.out.printf("Theta is equal to: " + p2.getAngle() + "%n%n");


    p1.translate(2,2);
    System.out.println("After translation (2,2), these are point 1's new stats:  "); 
    System.out.println("x is equal to: " + p1.getX()); 
    System.out.println("y is equal to: " + p1.getY()); 
    System.out.println("r is equal to: " + p1.getRadius()); 
    System.out.printf("Theta is equal to: " + p1.getAngle() + "%n%n" );

    double distance = p1.distanceTo(p2); 
    System.out.printf("The distance between point 1 and point 2 is: " + distance + " units. %n%n"); 

}
}


