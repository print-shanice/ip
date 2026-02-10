package kiki;

import command.Command;

/**
 * Represents an instance of the task manager bot, kiki
 */

public class Kiki {
    private final Ui ui;
    private final TaskList tasks;

    /**
     * Constructs a new Kiki instance
     */
    public Kiki() {
        ui = new Ui();
        tasks = new TaskList(Storage.load());
        ui.showWelcome();
    }

    /**
     * Processes user input and returns the corresponding response from Kiki
     * @param input Raw user input typed
     * @return Response message from Kiki to be displayed
     */
    public String getResponse(String input) {
        try {
            Command command = Parser.parse(input);
            return command.execute(tasks, ui);
        } catch (IllegalArgumentException e) {
            assert !e.getMessage().isEmpty() : "Error message should be present";
            return ui.showError(e.getMessage());
        }
    }

    /**
     * Returns welcome message shown when user first enters the chatbot
     *
     * @return The welcome message string
     */
    public String getWelcomeMessage() {
        return ui.showWelcome();
    }

    /**
     * Returns goodbye message shown when user gives an Exit Command
     *
     * @return The goodbye message string
     */
    public String getGoodbyeMessage() {
        return ui.showGoodbye();
    }
}

