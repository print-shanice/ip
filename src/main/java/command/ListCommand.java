package command;
import kiki.TaskList;
import kiki.Ui;

/**
 * Represents a user list command from the Kiki chatbot
 */

public class ListCommand extends Command {

    @Override
    public void execute(TaskList tasks, Ui ui) {
        tasks.listTasks(ui);
    }
}
