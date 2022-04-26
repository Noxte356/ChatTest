import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ReaderMessages {

    public void readAllMessagesFromServer(Socket clientSocket, List<String> allMessages) {
        try {
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(
                            clientSocket.getInputStream()));
            int size = reader.read();
            for (int i = 0; i < size; i++) {
                String message = reader.readLine();
                allMessages.add(message);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
