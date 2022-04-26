import java.net.Socket;
import java.util.ArrayList;

public class MessageStorage {
    String message;

    public void save(Socket clientSocket, String message, ArrayList<String> messageHistory) {
        this.message = message;
        messageHistory.add(message);

    }
}
