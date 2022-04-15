import java.net.*;
import java.io.*;
import java.util.ArrayList;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(48648);
        ArrayList<String> messageHistory = new ArrayList<>();
        System.out.println("Server started");
        while (true) {
            Socket clientSocket = serverSocket.accept();
            String[] regex = new String[1];
            OutputStreamWriter writer = new OutputStreamWriter(clientSocket.getOutputStream());
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(
                            clientSocket.getInputStream()));
            String request = reader.readLine();
            regex = request.split(": ");
            if (regex[0].equals("Send")) {
//                System.out.println(request);
                messageHistory.add(regex[1]);
                System.out.println(messageHistory.get(0));
            }
             if (regex[0].equals("Get")) {
                 writer.write(messageHistory.size());
                 for (int i = 0; i < messageHistory.size(); i++) {
                     writer.write(messageHistory.get(i) + "\n");
                 }
             }
             if (!(regex[0].equals("Send")) && !(regex[0].equals("Get"))){
                 System.out.println("Неизвестный запрос");
             }
//            serverSocket.close();
        }
    }
}
