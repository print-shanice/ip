package command;

import kiki.TaskList;
import kiki.Ui;

/**
 * Represents a user exit command from the Kiki chatbot
 */

public class ExitCommand extends Command {
    @Override
    public void execute(TaskList tasks, Ui ui) {
        ui.showGoodbye();
        isExit = true;
    }
}
