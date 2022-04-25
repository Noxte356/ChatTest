import java.net.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Chat {
    public static void main(String[] args) {
        List<String> oldMessage = new ArrayList<>();
        RequestSender requestSender = new RequestSender();
        while (true) {
            try {
                Thread.sleep(2000);
                Socket clientSocket = new Socket("127.0.0.1", 48648);
                List<String> newMessage = new ArrayList<>();
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(
                                clientSocket.getInputStream()));
                requestSender.sendRequestFromChatToServer(clientSocket, "Get");
                int size = reader.read();
                oldMessage.add("привет");
                for (int i = 0; i < size; i++) {
                    String message = reader.readLine();
                    if (!(message.equals(oldMessage.get(i)))){
                        System.out.println(message);
                        oldMessage.add(message);
                    }

                }
                clientSocket.close();
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
