import java.net.*;
import java.io.*;
import java.util.Scanner;

public class Client2 {
    public static void main(String[] args) throws IOException {
        Socket clientSocket = new Socket("127.0.0.1", 48648);
        Scanner scan = new Scanner(System.in);
        OutputStreamWriter writer = new OutputStreamWriter(clientSocket.getOutputStream());
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        clientSocket.getInputStream()));

        writer.write("Get" + "\n");
        writer.flush();

        int chatSize = reader.read();
        for (int i = 0; i < chatSize; i++) {
            String string = reader.readLine() + "\n";
            System.out.println(string);
        }

        writer.close();
        reader.close();
        clientSocket.close();

    }

}
