package kiki;

import java.util.Scanner;

/**
 * Represents a UI class to handle user interactions with the Kiki chatbot
 */
public class Ui {
    private final Scanner scanner;

    /**
     * Constructs a new UI instance and initialises the input scanner
     */
    public Ui() {
        scanner = new Scanner(System.in);
    }

    /**
     * Returns the welcome message displayed when user first enters the chatbot
     */
    public String showWelcome() {
        return "good morning!\ni'm kiki\nwhat do you want?";
    }

    /**
     * Returns the user input from the chatbot
     * @return The trimmed user input
     */
    public String readCommand() {
        return scanner.nextLine().trim();
    }

    /**
     * Returns the goodbye message displayed when user gives exit command
     */
    public String showGoodbye() {
        return "finallyyyyy, bye!";
    }

    /**
     * Returns a formatted error message displayed for a given error
     *
     * @param message The raw error message to be formatted and displayed
     */
    public String showError(String message) {
        return "oi!\n" + message;
    }

    /**
     * Returns a formatted message displayed for a given error
     *
     * @param message The raw message to be formatted and displayed
     */
    public String showMessage(String message) {
        return message;
    }

    /**
     * Closes scanner used for reading user input
     */
    public void close() {
        scanner.close();
    }
}
