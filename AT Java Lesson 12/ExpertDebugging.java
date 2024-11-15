/*
 * 11/15/24
 * Sw Design with Java 
 * Jonathan Martinez 
 * 
 * 
 * Describe the error in the following program and explain how to fix it.
 *  public class Conversation {   
        public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("What is your first name? ");
        String input = in.next();
        System.out.println("Hello, " + input);
        System.out.print("How old are you? ");
        int input = in.nextInt();
        input++;
        System.out.println("Next year, you will be " + input);
   }
}
   
 * 
 * 
 * Problems with the Code: 
 * 1. Scanner isn't imported (java.util.Scanner)
 * 2. Resource leak because the Scanner isn't closed (need to add a 'in.close()')
 * 3. "input" is used as the name of a variable twice, once as an integer and once for a string, in the same scope. 
 *    This could be solved by making them different names.
 * 
 * 
 * 
 */

