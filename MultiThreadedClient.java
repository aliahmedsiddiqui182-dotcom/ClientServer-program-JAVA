import java.io.*;
import java.net.*;

public class MultiThreadedClient {
    public static void main(String[] args) {
        String hostname = "localhost";
        int port = 5000;

        try (Socket socket = new Socket(hostname, port)) {
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

            // Read welcome message from server
            System.out.println(input.readLine());

            String userInput;
            while (true) {
                System.out.print("You: ");
                userInput = console.readLine();
                output.println(userInput);

                if ("exit".equalsIgnoreCase(userInput)) {
                    break;
                }

                // Read server response
                System.out.println(input.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
