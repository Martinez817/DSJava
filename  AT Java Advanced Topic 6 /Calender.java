/*
 * 
 * 10/29/24
 * Sw Design with Java 
 * Jonathan Martinez
 * 
 * 
 * This program is a calendar.
 */
import java.time.LocalDate; 

public class Calender {
    public static void main(String[] args) {
        LocalDate rightNow = LocalDate.now(); 
        LocalDate firstOfMonth = rightNow.withDayOfMonth(1);

        // main header
        System.out.printf("%n%n");
        System.out.println("          " + rightNow.getMonth() +"      " + rightNow.getYear());
        System.out.println(" Mon Tue Wed Thu Fri Sat Sun");

        // data of the current Day and Month of the system being used 
        int startDay = firstOfMonth.getDayOfWeek().getValue(); 
        int daysInMonth = rightNow.lengthOfMonth(); 
        int todaysDate  = rightNow.getDayOfMonth(); 
    
        for (int i = 1; i < startDay; i++){
            System.out.print("    "); // printing 4 spaces if the start day of the 
        }

        for (int day = 1; day<= daysInMonth; day++) {
            if (day == todaysDate){
                System.out.printf("%3d*", day);

            } else { 
                System.out.printf("%4d", day); 

            }
            // Sunday Dector - uses value of the week from the first of the month and 
            // adds the current day to it. if it's divisible by 7, then it's sunday. 
            if ((startDay + day - 1) % 7 == 0) {
                System.out.println();
            } 

        }
        // not sunday dector 
        if ((startDay + daysInMonth - 1) % 7 != 0) {
            System.out.println();
        }

        System.out.printf("%n%n");
    }   
}

