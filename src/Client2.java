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

        writer.write("Get");
        writer.flush();

        int numb = reader.read();
        System.out.println(numb);
        for (int i = 0; i < numb; i++) {
            String string = reader.readLine();
            System.out.println(string);
        }

        reader.close();
        writer.close();
        clientSocket.close();

    }

}
