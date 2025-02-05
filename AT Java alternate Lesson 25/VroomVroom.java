/*
 * 1/31/24
 * Sw Design with java 
 * Jonathan Martinez
 * 
 */

 public class VroomVroom {
    public static void main (String args[]){
        

    }
 }

 class Car {
    static double initspeed; 
    final double MAX_SPEED = 120.0; 

    double Initialspeed() {
        initspeed = 0.0; 
        return initspeed;
    }
    double Initialspeed(double s) {
        if (s < MAX_SPEED) {
            initspeed = s;
            return initspeed;
        } else {
            System.out.printf("Invalid speed. Please try again. %n");
            initspeed = 0;
            return initspeed;
        }
    }

    double accelerate(){
        if (initspeed < MAX_SPEED){
            initspeed = initspeed++; 
            if (initspeed == MAX_SPEED){
                System.out.printf("%nAlready at max speed (120mph)%n");
                initspeed--;
                return initspeed;
            } else {
                System.out.printf("%nThe Car's current speed is: %d", initspeed);
            }
        } 
    }

    
        
    }
 }