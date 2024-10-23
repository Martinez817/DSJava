/*
* 10/23/24
* Sw Design with Java 
* Jonathan Martinez 
* 
* This program is used to collect a phone number from a user and display it 
*/ 

import java.util.Scanner; 

public class PhoneNumber {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter in a phone number (with no spaces): "); 
        String phoneNumber = in.nextLine(); 
        if (phoneNumber.matches("\\d{10}")) {
            String phonePartOne = phoneNumber.substring(0,3); 
            String phonePartTwo = phoneNumber.substring(3,6);
            String phonePartThree = phoneNumber.substring(6,10); 
    
            // 012-345-6789
            // 000-000-0000
             System.out.printf("Your phone number is (%s)-%s-%s. %n %nHave a good day!)", phonePartOne, phonePartTwo, phonePartThree);
        } else { 
            System.out.print("Not a valid input. Please try again. ");
        }

       in.close(); 
    }
    


    
}
