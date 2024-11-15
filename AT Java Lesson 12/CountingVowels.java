/*
 * 
 * 11/15/24
 * Sw Design with java 
 * Jonathan Martinez 
 * 
 * This program is used to calculate the number of vowels in a specified phrase 
 * 
 */


public class CountingVowels {
    public static int CountVowels (String phrase){
        int numberOfVowels = 0; 

        for (int i = 0; i < phrase.length(); i++){
            char c = phrase.charAt(i);
            if (IsVowel(c)){
                numberOfVowels++; 
            } 
            
        }

        return numberOfVowels;
    }

    public static boolean IsVowel(char c){
        switch (Character.toLowerCase(c)){
            default: 
            return false; 
            case 'a', 'e', 'i', 'o', 'u': 
            return true;
        }
    }
    public static void main(String[] args) {
        String testPhrase = "The quick brown fox jumps over the lazy dog"; 
        int numberofVowels = CountVowels(testPhrase); 
        System.out.println("In the phrase, '" + testPhrase + "', there are about " + numberofVowels + " vowels. Have a good rest of your day!"); 
    }
}
