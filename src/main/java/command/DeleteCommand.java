package command;

import kiki.Storage;
import kiki.TaskList;
import kiki.Ui;
import task.Task;

/**
 * Represents a user delete command that has a task index
 */

public class DeleteCommand extends Command {
    private int task;

    public DeleteCommand(int task) {
        this.task = task;
    }

    @Override
    public String execute(TaskList tasks, Ui ui) {
        try {
            Task removedTask = tasks.getTask(task);
            tasks.removeTask(task);
            Storage.save(tasks.getTasks());
            return ui.showMessage("okay, removed: " + removedTask + "\n you have " + tasks.size() + " tasks in the list currently");
        } catch (IndexOutOfBoundsException e) {
            return ui.showError("that task number does not exist!");
        }
    }
}
