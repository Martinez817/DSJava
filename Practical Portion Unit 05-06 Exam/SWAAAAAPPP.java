/*
 * 1/21/24
 * Sw Design with java 
 * Jonathan Martinez 
 * 
 * 
 * 
 */

import java.util.Arrays;


public class SWAAAAAPPP {
    public static void main(String[] args) {
        int [] numbers = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, };
        swip.swap(2,7,numbers);
        System.out.println(Arrays.toString(numbers)); 
        
    }
 }



 class swip {
    
    static void swap(int x, int y, int[] array){
        try {
            int xPlaceHolder = 0;  
            xPlaceHolder = array[x];

            int yPlaceHolder = 0; 
            yPlaceHolder = array[y]; 

            array[x] = yPlaceHolder; 
            array[y] = xPlaceHolder; 

        } catch (NumberFormatException e) {
            System.out.print("Invalid Parameters. Try Again."); 
        }
    }

 }