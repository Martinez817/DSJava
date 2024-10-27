/*
 * 10/27/24
 * Sw Design with Java 
 * Jonathan Martinez 
 * 
 * This program is used to calculate how many years will pass until 99% of the original amount of cesium is gone. 
 */
import java.util.Scanner; 

public class Cesium {
    public static void main(String[] args) {
       Scanner in = new Scanner(System.in); 
       Double cesiumAmount = 100.0; 
       int cesiumYear = 1; 
        // Making sure it's over 1% to continue the math. 
       while (cesiumAmount > 1.0){
        if (cesiumYear % 30 == 0){
            cesiumAmount = cesiumAmount / 2.0; 
            if (cesiumAmount > 1.0){
                cesiumYear++;
            } 
        }
        else if (cesiumYear % 30 != 0){
            cesiumYear++; 
        }
        
        if (cesiumAmount <= 1.0){
            System.out.println("Assuming you start with 100% material, you will have lost around 99% of the original Cesium after " + cesiumYear + " years. Have a good day!");
            break;
            
        } 

       }

       
       in.close();
      
    }
    
}
