package command;

import kiki.Storage;
import kiki.TaskList;
import kiki.Ui;
import task.Task;

/**
 * Represents a user unmark command that has an index to mark a task as not done from the Kiki chatbot
 */
public class UnmarkCommand extends Command {
    private final int index;

    public UnmarkCommand(int index) {
        this.index = index;
    }

    @Override
    public String execute(TaskList tasks, Ui ui) {
        try {
            Task task = tasks.getTask(index);
            task.markNotDone();
            Storage.save(tasks.getTasks());
            return ui.showMessage("you're welcome, i've marked this task as not done: \n" + task);
        } catch (IndexOutOfBoundsException e) {
            return ui.showError("that task number does not exist!");
        }
    }
}
