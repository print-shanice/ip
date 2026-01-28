package kiki;

import command.Command;

public class kiki {
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

