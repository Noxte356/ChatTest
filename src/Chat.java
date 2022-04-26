import java.net.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Chat {
    public static void main(String[] args) {
        List<String> oldMessages = new ArrayList<>();
        RequestSender requestSender = new RequestSender();
        while (true) {
            try {
                Thread.sleep(2000);
                Socket clientSocket = new Socket("127.0.0.1", 48648);
                List<String> allMessages = new ArrayList<>();
//                test
                ReaderMessages readerMessages = new ReaderMessages();
//                test
                PrinterNewMessages printerNewMessages = new PrinterNewMessages();
//                test
                requestSender.sendRequestFromChatToServer(clientSocket, "Get");

                readerMessages.readAllMessagesFromServer(clientSocket, allMessages);

                printerNewMessages.print(allMessages, oldMessages);

                clientSocket.close();
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
