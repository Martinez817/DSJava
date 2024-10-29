/*
 * 
 * 10/29/24
 * SW design with Java 
 * Jonathan Martinez 
 * 
 * This program is used to count the amount of E's present in a phrase. 
 */
import java.util.Scanner; 
public class CountingE {
    public static void main(String[] args) {
       Scanner in = new Scanner(System.in); 
       System.out.print("Enter a phrase: "); 
       String phrase = in.nextLine(); 

       int numberOfE = 0; 

       for (int i = 0; i < phrase.length(); i++){
        if (phrase.charAt(i) == 'e' || phrase.charAt(i) == 'E'){
            numberOfE++; 
        }
       }
       System.out.print("Did you know that in the phrase you just typed, there were " + numberOfE + " e's? Crazy Right? Have a good day!");
       in.close();
    }
    
}
