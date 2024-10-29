/*
 * 10/27/24
 * SW Design with Java 
 * Jonathan Martinez 
 * 
 * This program is used as a light controller for a dimmable light. 
 */
import java.util.Scanner; 

public class LetThereBeLight {
    public static void main(String[] args) {
        DimmableLight light = new DimmableLight(); 
        Scanner in = new Scanner(System.in);

        System.out.printf("%nWelcome to the light controller!%n");  

        //  The main looping mechanism for this whole operation 
        while (true) {
            System.out.printf("%nEnter in a command (in all caps) for the light: %nON - Turn ON %nOFF - Turn OFF %nUP - Brightness Up %nDOWN - Brightness Down %nVIEW - View current status of the Light %nQUIT - Quit the Program %n"); 
            String input = in.nextLine(); 
            if (input.equals("ON")){
                light.turnOn(); 
            } else if (input.equals("OFF")){
                light.turnOff(); 
            } else if (input.equals("UP")){
                light.brightnessUp(); 
            } else if (input.equals("DOWN")){
                light.brightnessDown(); 
            } else if (input.equals("VIEW")){
                light.viewLight(); 
            } else if (input.equals("QUIT")){
                System.out.print("Thank you for using the light controller program. Have a good day! "); 
                in.close(); 
                break; 
            } else {
                System.out.printf("%nInvalid input. Try again.%n"); 
            }
        
        }

    }
    
}

// When interacting with a light you can: adjust the brightness, turn it on or off, and look at it. 
// All this stuff below is the "nitty gritty" 
class DimmableLight {
    private boolean power = false; 
    private int brightness = 1; 

    public void turnOn(){
        power = true; 
        System.out.printf("%nThe Light is now on.%n"); 
    }
    public void turnOff(){
        power = false; 
        System.out.printf("%nThe Light is now off.%n"); 
    }
    public void viewLight(){
        System.out.printf("%nThe light is " + (power ? "on" : "off") + " and was last set to brightness level " + brightness + ".%n" ); 
    }
    public void brightnessUp(){
        if (brightness < 10 ){
            brightness++; 
            System.out.printf("%nThe brightness is now at level " + brightness + ".%n"); 
        } else {
            System.out.printf("%nThe brightness is already at it's max level (10).%n"); 
        }
    }
    public void brightnessDown(){
        if (brightness > 1 ){
            brightness--; 
            System.out.printf("%nThe brightness is now at level " + brightness + ".%n"); 
        } else {
            System.out.printf("%nThe brightness is already at it's lowest level (1).%n"); 
        }
    }

}
