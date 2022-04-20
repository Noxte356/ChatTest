import java.net.*;
import java.io.*;
import java.util.Scanner;

public class Client2 {
    public void getMeChat() throws IOException {
        Socket clientSocket = new Socket("127.0.0.1", 48648);
        Scanner scan = new Scanner(System.in);
        OutputStreamWriter writer = new OutputStreamWriter(clientSocket.getOutputStream());
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        clientSocket.getInputStream()));

        writer.write("Get" + "\n");
        writer.flush();

        System.out.print("\033[H\033[J");
        System.out.flush();

        int chatSize = reader.read();
        for (int i = 0; i < chatSize; i++) {
            String string = reader.readLine();
            System.out.println(string);
        }

        writer.close();
        reader.close();
        clientSocket.close();
    }

    public static void main(String[] args) throws IOException {
        while (true) {
            Client2 client2 = new Client2();
            client2.getMeChat();
        }
    }

}
