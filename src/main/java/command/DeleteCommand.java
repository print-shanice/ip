package command;

import kiki.Storage;
import kiki.TaskList;
import kiki.Ui;
import task.Task;

/**
 * Represents a command to delete a task from the task list in the Kiki chatbot.
 */
public class DeleteCommand extends Command {
    /** The zero-based index of the task to be removed. */
    private int task;

    /**
     * Constructs a DeleteCommand targeting the task at the given zero-based index.
     *
     * @param task The zero-based index of the task to remove.
     */
    public DeleteCommand(int task) {
        this.task = task;
    }

    /**
     * Executes this delete command by removing the task at the stored index from the task list,
     * saving the updated list to storage, and returning a confirmation message.
     * If the index is out of bounds, an error message is returned instead.
     *
     * @param tasks The TaskList to remove the task from.
     * @param ui    The Ui instance used to format the response message.
     * @return A confirmation message with the removed task and new list size, or an error message.
     */
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
