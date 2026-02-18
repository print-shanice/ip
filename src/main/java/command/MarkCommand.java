package command;

import kiki.Storage;
import kiki.TaskList;
import kiki.Ui;
import task.Task;

/**
 * Represents a command to mark a task as done in the Kiki chatbot.
 */
public class MarkCommand extends Command {
    /** The zero-based index of the task to mark as done. */
    private final int index;

    /**
     * Constructs a MarkCommand targeting the task at the given zero-based index.
     *
     * @param index The zero-based index of the task to mark as done.
     */
    public MarkCommand(int index) {
        this.index = index;
    }

    /**
     * Executes this mark command by setting the task at the stored index to done,
     * saving the updated list to storage, and returning a confirmation message.
     * If the index is out of bounds, an error message is returned instead.
     *
     * @param tasks The TaskList containing the task to mark.
     * @param ui    The Ui instance used to format the response message.
     * @return A confirmation message showing the marked task, or an error message.
     */
    @Override
    public String execute(TaskList tasks, Ui ui) {
        try {
            Task task = tasks.getTask(index);
            task.markDone();
            Storage.save(tasks.getTasks());
            return ui.showMessage("you're welcome, i've marked this task as done: \n" + task);
        } catch (IndexOutOfBoundsException e) {
            return ui.showError("that task number does not exist!");
        }
    }
}
