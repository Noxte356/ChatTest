import java.net.Socket;
import java.util.ArrayList;

public class MessageStorage {

    public void save(Socket clientSocket, String request, ArrayList<String> messageHistory) {
        String message = request;
        messageHistory.add(request);

    }
}
