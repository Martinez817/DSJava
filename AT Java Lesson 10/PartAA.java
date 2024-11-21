/*
 * 
 *  11/6/24
 * Sw Design With Java 
 * Jonathan Martinez
 * 
 */

public class PartAA {

    //    public static void main(String[] args) {
    //    String name = "Harry";
    //    System.out.println("The last letter of the name is " +
    //    name.charAt(name.length()));
    //    }
        
    // problem - "name.length()" returns the number of characters in the string but not
    // the last character. Counting also starts at 0, so although the amount of 
    // characters total is 5, the system only knows the String "name" to be 4 (HARRY)
    // this would be a runtime error.                                          01234
    
    // fix - adding "- 1" shifts the count 
    public static void main(String[] args) {
        String name = "Harry";
        System.out.println("The last letter of the name is " +
        name.charAt(name.length()-1));

        }
    
       
}

