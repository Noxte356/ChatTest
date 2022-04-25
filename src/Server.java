import java.net.*;
import java.io.*;
import java.util.ArrayList;

public class Server {

    public static final String SAVE_MESSAGE_COMMAND = "Send";
    public static final String OUT_MESSAGE_COMMAND = "Get";

    public static void main(String[] args) throws IOException {
        MessageStorage messageStorage = new MessageStorage();
        MessageSender messageSender = new MessageSender();
        ServerSocket serverSocket = new ServerSocket(48648);
        ArrayList<String> messageHistory = new ArrayList<>();
        System.out.println("Server started");
        while (true) {
            Socket clientSocket = serverSocket.accept();
            String[] regex = new String[5];
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(
                            clientSocket.getInputStream()));

            String request = reader.readLine();
            regex = request.split(": ");
            if (regex[0].equals(SAVE_MESSAGE_COMMAND)) {
                messageStorage.save(clientSocket, regex[1], messageHistory);
            }
            if (request.equals(OUT_MESSAGE_COMMAND)) {
                messageSender.sendAllMessagesToChat(clientSocket, messageHistory);
            }
            if (!(regex[0].equals(SAVE_MESSAGE_COMMAND)) && !(request.equals("Get"))) {
                System.out.println("Неизвестный запрос");
            }
//            serverSocket.close();
//            1) Добить приложение шоб работало
//            2) Вынести ХардКод в константы
//            3) Разбить логику по классом в том числе и обработчики
//            4) Попробовать заюзать многопоточность и соеденить Клиет и чат
        }
    }
}