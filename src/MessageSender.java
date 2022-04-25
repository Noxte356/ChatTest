import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.ArrayList;

public class MessageSender {
    public void sendAllMessagesToChat(Socket clientSocket, ArrayList<String> messageHistory) {
        try {
            OutputStreamWriter writer = new OutputStreamWriter(clientSocket.getOutputStream());
            writer.write(messageHistory.size());
            writer.flush();
            for (int i = 0; i < messageHistory.size(); i++) {
                writer.write(messageHistory.get(i) + "\n");
                writer.flush();
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
