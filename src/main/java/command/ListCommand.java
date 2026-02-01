package command;
import kiki.TaskList;
import kiki.Ui;

/**
 * Represents a user list command from the Kiki chatbot
 */

public class ListCommand extends Command {

    @Override
    public String execute(TaskList tasks, Ui ui) {
        StringBuilder sb = new StringBuilder();
        sb.append("here are the tasks in your list:\n");
        for (int i = 0; i < tasks.size(); i++) {
            sb.append(" ").append(i + 1).append(".").append(tasks.getTask(i)).append("\n");
        }
        return sb.toString();
    }
}
