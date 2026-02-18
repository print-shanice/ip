package kiki;

import javafx.application.Application;

/**
 * Serves as the entry point for the Kiki chatbot application.
 * This class is necessary as a workaround for JavaFX's requirement that the
 * main class does not extend {@link Application} when launching from a JAR.
 */
public class Launcher {

    /**
     * Launches the Kiki JavaFX application.
     *
     * @param args Command-line arguments passed to the application.
     */
    public static void main(String[] args) {
        Application.launch(Main.class, args);
    }
}
