import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class server {
    public static void main(String[] args) {
        Socket socket = null;
        InputStreamReader inputStreamReader = null;
        OutputStreamWriter outputStreamWriter = null;
        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;
        ServerSocket serverSocket = null;

        try {
            serverSocket = new ServerSocket(1234);
            System.out.println("Server started. Waiting for client...");

            while (true) {
                socket = serverSocket.accept();
                System.out.println("Client connected!");

                inputStreamReader = new InputStreamReader(socket.getInputStream());
                outputStreamWriter = new OutputStreamWriter(socket.getOutputStream());
                bufferedReader = new BufferedReader(inputStreamReader);
                bufferedWriter = new BufferedWriter(outputStreamWriter);

                String msgFromClient;
                while ((msgFromClient = bufferedReader.readLine()) != null) {
                    System.out.println("Client: " + msgFromClient);

                    if (msgFromClient.equalsIgnoreCase("bye")) {
                        bufferedWriter.write("Goodbye!");
                        bufferedWriter.newLine();
                        bufferedWriter.flush();
                        break;
                    }

                    // Respond back to client
                    bufferedWriter.write("Server received: " + msgFromClient);
                    bufferedWriter.newLine();
                    bufferedWriter.flush();
                }

                socket.close();
                System.out.println("Client disconnected.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
