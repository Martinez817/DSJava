/*
 * 1/8/24
 * Sw Design with Java 
 * Jonathan Martinez 
 * 
 */


/*
 * Part A: 
 * 
 * 1. int [][] newArrayOne = new Integer[4][3]
 * 2. int [][] newArrayTwo = new Integer[2][5]
 * 3. int [][] newArrayThree = 
 * {
 *          {8, 6, 7}, 
 *          {5, 3, 0}, 
 * }; 
 * 
 */

 import java.util.Scanner; 

 public class TwoDimensionalArrays {
    public static void main(String[] args) {
      Scanner in = new Scanner(System.in); 
      System.out.printf("%n%nWelcome to Martinez's Array Printer!");
      while (true){
         System.out.printf("%n%nWhich Array would you like to print?%nArrayThree - Prints Array #3 %nArrayFour - Prints Array #4%nQUIT - Quits the Program %n%n"); 
         String input = in.nextLine(); 
         if (input.equalsIgnoreCase("ArrayThree")){
            Printing.print(new Printing().newArrayThree);
         } else if (input.equalsIgnoreCase("ArrayFour")){
            Printing.print(new Printing().newArrayFour); 
         } else if (input.equalsIgnoreCase("Quit")){
            System.out.printf("%nHave a good rest of your day!");
            in.close();
            break; 
         }
         
         else {
            System.out.printf("%nInvalid Input. Please try again. %n%n");
         }
      }

      
    }
 }

class Printing {

   int [][] newArrayThree = 
   {
         {8, 6, 7}, 
         {5, 3, 0}, 
   }; 
   int [][] newArrayFour = 
   {
      {0, 7, 6, 5},
      {2, 2, 0, 1},
      {8, 4, 5, 7},

   }; 

    public static void print(int [][] values) {
      System.out.println();
      for (int i = 0; i < values.length; i++){
         for (int j = 0; j < values[i].length; j++){
            System.out.printf("%4d,", values[i][j]);
         
         }
         System.out.println();
      }

    }
   }