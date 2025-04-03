import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
    public static void main(String[] args) {
        int port = 8675; 
        if (args.length > 0) {
            try {
                port = Integer.parseInt(args[0]);
            } catch (NumberFormatException e) {
                System.err.println("Invalid port number. Using default port 8675.");
            }
        } else {
            System.out.println("Please provide a port number as an argument.");
            return;
        }

        System.out.printf("Starting EchoServer on port: %d%n", port);

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            while (true) {
                System.out.println("Waiting for a client to connect...");
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected: " + clientSocket.getInetAddress() + ":" + clientSocket.getPort());

                // Handle the client in a separate thread
                new Thread(() -> handleClient(clientSocket)).start();
                
            }
        } catch (IOException e) {
            System.out.println("Exception caught when trying to listen on port " + port);
            System.out.println(e.getMessage());
        }
    }

    private static void handleClient(Socket clientSocket) {
        try (
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))
        ) {
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                System.out.println("Received: " + inputLine); // Log the received message
                out.println(inputLine); // Echo the message back to the client
            }
        } catch (IOException e) {
            System.out.println("Exception caught while handling client: " + e.getMessage());
        } finally {
            try {
                clientSocket.close();
                System.out.println("Client disconnected.");
            } catch (IOException e) {
                System.out.println("Failed to close client socket: " + e.getMessage());
            }
        }
    }
}
