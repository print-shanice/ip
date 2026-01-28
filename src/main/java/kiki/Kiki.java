package kiki;

import command.Command;

/**
 * Represents a location in a 2D space. A <code>Point</code> object corresponds to
 * a coordinate represented by two integers e.g., <code>3,6</code>
 */

public class Kiki {
    public static void main(String[] args) {
        Ui ui = new Ui();
        TaskList tasks = new TaskList(Storage.load());

        ui.showWelcome();
        boolean isExit = false;

        while (!isExit) {
            try {
                String command = ui.readCommand();
                Command c = Parser.parse(command);
                c.execute(tasks, ui);
                isExit = c.isExit();
            } catch (IllegalArgumentException e) {
                ui.showError(e.getMessage());
            }
        }
        ui.close();
    }
}

