import java.io.*;
import java.net.*;

public class EchoClient {
    public static void main(String[] args) {
        String serverAddress = "localhost"; // Change to server IP if needed
        int port = 8765; // Change to the server's port if needed

        try (Socket socket = new Socket(serverAddress, port);
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in))) {

            System.out.println("Connected to the server. Type messages to send:");

            String userInput;
            while ((userInput = stdIn.readLine()) != null) {
                out.println(userInput); // Send message to server
                System.out.println("Server response: " + in.readLine()); // Read server response
            }
        } catch (IOException e) {
            System.err.println("Error connecting to the server: " + e.getMessage());
        }
    }
}