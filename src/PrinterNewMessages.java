import java.util.List;

public class PrinterNewMessages {

    public void print(List<String> allMessages, List<String> oldMessages) {
        if (allMessages.size() > oldMessages.size()) {
            for (int i = oldMessages.size(); i < allMessages.size(); i++) {
                System.out.println(allMessages.get(i));
                oldMessages.add(allMessages.get(i));
            }
        }
    }
}
