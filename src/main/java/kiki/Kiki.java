package kiki;

import command.Command;

/**
 * Represents an instance of the task manager bot, kiki
 */

public class Kiki {
    private final Ui ui;
    private final TaskList tasks;

    public Kiki() {
        ui = new Ui();
        tasks = new TaskList(Storage.load());
        ui.showWelcome();
    }

    public String getResponse(String input) {
        try {
            Command command = Parser.parse(input);
            return command.execute(tasks, ui);
        } catch (IllegalArgumentException e) {
            assert !e.getMessage().isEmpty() : "Error message should be present";
            return ui.showError(e.getMessage());
        }
    }

    public String getWelcomeMessage() {
        return ui.showWelcome();
    }

    public String getGoodbyeMessage() {
        return ui.showGoodbye();
    }
}

