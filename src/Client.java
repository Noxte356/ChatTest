import java.net.*;
import java.io.*;
import java.util.Scanner;

public class Client {
    public void runPrintChat () throws IOException {
        Socket clientSocket = new Socket("127.0.0.1", 48648);
        Scanner scan = new Scanner(System.in);
        OutputStreamWriter writer = new OutputStreamWriter(clientSocket.getOutputStream());
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        clientSocket.getInputStream()));
        String message = scan.nextLine();
        writer.write("Send: " + message + "\n");
        writer.flush();

        reader.close();
        writer.close();
        clientSocket.close();

    }

    public static void main(String[] args) throws IOException {
        while (true) {
            Client client = new Client();
            client.runPrintChat();
        }
    }
}
