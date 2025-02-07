/*
 * 1/31/24
 * Sw Design with java 
 * Jonathan Martinez
 * 
 */

import java.util.Scanner;

public class VroomVroom {
    public static void main (String args[]){
        Scanner in = new Scanner(System.in);
        Car car = new Car(); 
        System.out.printf("%nWelcome to VroomVroom! %n");
        while (true){
            System.out.printf("%nHow would you like to interact with the car?:%nAccelerate - Accelerate the car%nBrake - Slow the Car down%nSet - Set the car to a specific speed%nGet - Get the current speed of the car%nExit - Exit the program%n");
            String input = in.nextLine();
            if (input.equalsIgnoreCase("Accelerate")){
                System.out.printf("The car is now going %.1f mph. %n", car.accelerate());
            } else if (input.equalsIgnoreCase("Brake")){
                System.out.printf("The car is now going %.1f mph. %n", car.brake());
            } else if (input.equalsIgnoreCase("Set")){
                System.out.printf("What speed would you like to set the car to? %n");
                double speed = in.nextDouble();
                System.out.printf("The car is now going %.1f mph. %n", car.setInitialSpeed(speed));
                in.nextLine();
            } else if (input.equalsIgnoreCase("Get")){
                System.out.printf("The car is going %.1f mph. %n", car.getSpeed());
            } else if (input.equalsIgnoreCase("Exit")){
                System.out.printf("Have a good rest of your day! %n");
                in.close();
                break;
            } else {
                System.out.printf("Invalid input. Please try again. %n");
            }
        }
    }
 }

 class Car {
    static double initspeed; 
    final double MAX_SPEED = 120.0; 

    double initialSpeed() {
        initspeed = 0.0; 
        return initspeed;
    }
    double setInitialSpeed(double s) {
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
        if (initspeed < MAX_SPEED) {
            initspeed += 1;
            return initspeed;
        } else {
            System.out.printf("Car is at max speed. %n");
            return initspeed;
        }
    }

    double brake(){
        if (initspeed > 0) {
            initspeed -= 0.1;
            return initspeed;
        } else {
            System.out.printf("Car is at 0 mph. %n");
            return initspeed;
        }
    }

    double getSpeed(){
        return initspeed; 
    }


    
        
    }
 