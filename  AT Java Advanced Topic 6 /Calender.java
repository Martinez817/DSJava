/*
 * 
 * 10/29/24
 * Sw Design with Java 
 * Jonathan Martinez
 * 
 * 
 * 
 */
import java.time.LocalDate; 

public class Calender {
    public static void main(String[] args) {
        LocalDate rightNow = LocalDate.now(); 
        System.out.println("          " + rightNow.getMonth() +  "          ");
        System.out.println(" Mon Tue Wed Thu Fri Sat Sun");
        int dayOfMonth = rightNow.getDayOfMonth(); 
        System.out.print(rightNow.getDayOfWeek());  

    }
    
}
