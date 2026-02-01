package command;

import kiki.TaskList;
import kiki.Ui;

/**
 * Represents a user exit command from the Kiki chatbot
 */

public class ExitCommand extends Command {
    @Override
    public String execute(TaskList tasks, Ui ui) {
        return ui.showGoodbye();
    }
}
