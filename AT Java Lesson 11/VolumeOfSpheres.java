
/*
 * 11/13/24
 * Sw Design with Java 
 * Jonathan Martinez
 * 
 * This program is used to calculate the volume of a sphere 
 *
 */
import java.util.Scanner; 

public class VolumeOfSpheres {
    public static void main(String[] args) {
        Volume volume = new Volume(); 
        volume.volume(); 
     
    }

    
}
class Volume {
    public void volume(){
     Scanner in = new Scanner(System.in); 
      System.out.print("What is the radius of your sphere? (Ex. 2.0): "); 
      double radius = in.nextDouble(); 
        double volume = (4.0 / 3.0 ) * Math.PI * Math.pow(radius, 3); 
        System.out.printf("The volume of your sphere is: " + volume + ". Have a good rest of your day! %n");
        in.close();  
    }
    
}


