import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

public class client {
    public static void main(String[] args) {
        Socket socket = null;
        InputStreamReader inputStreamReader = null;
        OutputStreamWriter outputStreamWriter = null;
        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;

        try {
            socket = new Socket("localhost", 1234);

            inputStreamReader = new InputStreamReader(socket.getInputStream());
            outputStreamWriter = new OutputStreamWriter(socket.getOutputStream());
            bufferedReader = new BufferedReader(inputStreamReader);
            bufferedWriter = new BufferedWriter(outputStreamWriter);

            Scanner scanner = new Scanner(System.in);
            String msgToSend = "";

            while (!msgToSend.equalsIgnoreCase("bye")) {
                System.out.print("You: ");
                msgToSend = scanner.nextLine();

                // Send message to server
                bufferedWriter.write(msgToSend);
                bufferedWriter.newLine();
                bufferedWriter.flush();

                // Read response from server
                String msgFromServer = bufferedReader.readLine();
                System.out.println("Server: " + msgFromServer);
            }

            scanner.close();
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
