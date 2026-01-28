import java.util.Scanner;

public class Ui {
    private Scanner scanner;

    public Ui() {
        scanner = new Scanner(System.in);
    }

    public void showWelcome() {
        showLine();
        System.out.println(" good morning");
        System.out.println(" i'm kiki");
        System.out.println(" what do you want?");
        showLine();
    }

    public void showLine() {
        System.out.println(" ____________________________________________________________");
    }

    public String readCommand() {
        return scanner.nextLine().trim();
    }

    public void showGoodbye() {
        showLine();
        System.out.println(" finallyyyyy, bye!");
        showLine();
    }

    public void showError(String message) {
        showLine();
        System.out.println(" oi! " + message);
        showLine();
    }

    public void showMessage(String message) {
        showLine();
        System.out.println(message);
        showLine();
    }

    public void close() {
        scanner.close();
    }
}
