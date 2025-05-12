package hw;
import java.util.Scanner;
import java.io.*;
import java.util.*;

public class EmployeeWriter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String fileName = "data.bin";
        int currentID = (args.length > 0) ? Integer.parseInt(args[0]) : 1;
        Employee.lastIDUsed = currentID - 1;
        ArrayList<Employee> employeeList = new ArrayList<>();

        while (true) {
            System.out.print("First name (or press enter to save and exit): ");
            String firstName = scanner.nextLine();
            if (firstName.isEmpty()) break;

            System.out.print("Last name: ");
            String lastName = scanner.nextLine();

            System.out.print("Salary: ");
            double salary = Double.parseDouble(scanner.nextLine());

            int id = ++Employee.lastIDUsed;
            employeeList.add(new Employee(firstName, lastName, id, salary));
        }

        try (DataOutputStream out = new DataOutputStream(new FileOutputStream(fileName))) {
            out.writeInt(Employee.lastIDUsed);
            out.writeInt(employeeList.size());

            for (Employee emp : employeeList) {
                out.writeInt(emp.getID());
                out.writeUTF(emp.getFirstName());
                out.writeUTF(emp.getLastName());
                out.writeDouble(emp.getSalary());
            }

            System.out.println("Employee data saved to " + fileName);
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
        scanner.close();
    }
    
}
