package kiki;

import java.util.Scanner;

public class Ui {
    private final Scanner scanner;

    public Ui() {
        scanner = new Scanner(System.in);
    }

    public String showWelcome() {
        return "good morning!\ni'm kiki\nwhat do you want?";
    }

    public String readCommand() {
        return scanner.nextLine().trim();
    }

    public String showGoodbye() {
        return "finallyyyyy, bye!";
    }

    public String showError(String message) {
        return "oi!\n" + message;
    }

    public String showMessage(String message) {
        return message;
    }

    public void close() {
        scanner.close();
    }
}
