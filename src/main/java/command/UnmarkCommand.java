package command;

import kiki.Storage;
import kiki.TaskList;
import kiki.Ui;
import task.Task;

/**
 * Represents a command to mark a task as not done in the Kiki chatbot.
 */
public class UnmarkCommand extends Command {
    /** The zero-based index of the task to mark as not done. */
    private final int index;

    /**
     * Constructs an UnmarkCommand targeting the task at the given zero-based index.
     *
     * @param index The zero-based index of the task to mark as not done.
     */
    public UnmarkCommand(int index) {
        this.index = index;
    }

    /**
     * Executes this unmark command by setting the task at the stored index to not done,
     * saving the updated list to storage, and returning a confirmation message.
     * If the index is out of bounds, an error message is returned instead.
     *
     * @param tasks The TaskList containing the task to unmark.
     * @param ui    The Ui instance used to format the response message.
     * @return A confirmation message showing the unmarked task, or an error message.
     */
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
