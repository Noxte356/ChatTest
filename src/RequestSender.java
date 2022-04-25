import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class RequestSender {

    public void sendRequestWithMessageToServer(Socket clientSocket, String request, String message) {
        try {
            OutputStreamWriter writer = new OutputStreamWriter(clientSocket.getOutputStream());
            writer.write( request + message + "\n");
            writer.flush();

            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendRequestFromChatToServer(Socket clientSocket, String request) {
        try {
            OutputStreamWriter writer = new OutputStreamWriter(clientSocket.getOutputStream());
            writer.write( request + "\n");
            writer.flush();

//            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
