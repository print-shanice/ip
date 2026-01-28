package kiki;

import java.util.Scanner;

/**
 * Responsible for all user interactions for the Kiki chatbot.
 * Displays all messages and reads user input
 */

public class Ui {
    private Scanner scanner;

    public Ui() {
        scanner = new Scanner(System.in);
    }

    /**
     * Displays a welcome message to the user
     */
    public void showWelcome() {
        showLine();
        System.out.println(" good morning");
        System.out.println(" i'm kiki");
        System.out.println(" what do you want?");
        showLine();
    }

    /**
     * Displays a divider line
     */
    public void showLine() {
        System.out.println(" ____________________________________________________________");
    }

    /**
     * Reads a user command
     * @return the user input as a trimmed string
     */
    public String readCommand() {
        return scanner.nextLine().trim();
    }

    /**
     * Displays a goodbye message to the user
     */
    public void showGoodbye() {
        showLine();
        System.out.println(" finallyyyyy, bye!");
        showLine();
    }

    /**
     * Displays an error message
     * @param message the error message to display
     */
    public void showError(String message) {
        showLine();
        System.out.println(" oi! " + message);
        showLine();
    }

    /**
     * Displays a message to the user after a command
     *
     * @param message the message to display
     */
    public void showMessage(String message) {
        showLine();
        System.out.println(message);
        showLine();
    }

    /**
     * Closes scanner when program exits
     */
    public void close() {
        scanner.close();
    }
}
