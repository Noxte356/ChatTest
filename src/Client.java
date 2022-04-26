import java.net.*;
import java.io.*;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        Chat chat = new Chat();
        chat.start();
        try {
            Scanner scan = new Scanner(System.in);
            RequestSender requestSender = new RequestSender();
            while (true) {
                String message = scan.nextLine();
                Socket clientSocket = new Socket("127.0.0.1", 48648);
                requestSender.sendRequestWithMessageToServer(clientSocket, "Send: ", message);
                clientSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
