/*
 * 1/17/24
 * Sw Design with Java 
 * Jonathan Martinez 
 */

 import java.time.*;
 
 class LocalDateAndTime {
    public static void main(String[] args) {
        LocalDate date = LocalDate.now();
        LocalTime time = LocalTime.now(); 

        System.out.printf("%nThe Current day is: " + date + "%nThe Current time is: " + time + "%n%n");
    }
 }
