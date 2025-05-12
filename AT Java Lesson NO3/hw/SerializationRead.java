package hw;
import java.io.*;
import java.util.*;

public class SerializationRead {
    public static void main(String[] args) {
        String fileName = (args.length > 0) ? args[0] : "data.bin";
        ArrayList<Employee> employeeList = new ArrayList<>();

        try (DataInputStream in = new DataInputStream(new FileInputStream(fileName))) {
            int lastIDUsed = in.readInt();
            int numEmployees = in.readInt();

            System.out.println("Last used ID: " + lastIDUsed);
            System.out.println("Reading " + numEmployees + " employees:\n");

            for (int i = 0; i < numEmployees; i++) {
                int id = in.readInt();
                String firstName = in.readUTF();
                String lastName = in.readUTF();
                double salary = in.readDouble();
                employeeList.add(new Employee(firstName, lastName, id, salary));
            }

            for (Employee emp : employeeList) {
                emp.displayInfo();
                System.out.println();
            }

        } catch (IOException e) {
            System.out.println("Error reading from file: " + e.getMessage());
        }
    }
}
