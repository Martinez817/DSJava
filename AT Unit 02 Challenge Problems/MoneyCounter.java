/*
 * 10/23/24
 * Sw Design with Java 
 * Jonathan Martinez
 * 
 * This program is used to display how much money a user has. 
 */
    import java.util.Scanner; 

 public class MoneyCounter {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.print("How much money do you have?: ");

        String userMoney = in.nextLine(); 
        // checking if it's a valid number or a string
        if (userMoney.matches("\\d+\\.\\d{2}")){
            double moolah = Double.parseDouble(userMoney); 
            int dollars = (int) moolah; 
            int cents = (int) Math.round((moolah - dollars) * 100); 
        
        
            if (cents < 0 || cents > 99) {
                System.out.print("Invalid amount. Try again.");

            } else if (cents >= 0 && cents <= 99){ 
                System.out.println("You have " + dollars + " dollars and " + cents + " cents. Have a good day!"); 
                in.close();
             }

        }

        else {
            System.out.print("Invalid input. Please try again. ");
        }

        
     }
    
  }
 
