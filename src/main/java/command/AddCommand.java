package command;

import kiki.Storage;
import kiki.TaskList;
import kiki.Ui;
import task.Task;

/**
 * Represents a command to add a task to the task list in the Kiki chatbot.
 */
public class AddCommand extends Command {
    /** The task to be added to the task list. */
    private Task task;

    /**
     * Constructs an AddCommand with the given task to be added.
     *
     * @param task The task to add to the task list.
     */
    public AddCommand(Task task) {
        this.task = task;
    }

    /**
     * Executes this add command by appending the task to the task list,
     * saving the updated list to storage, and returning a confirmation message.
     *
     * @param tasks The TaskList to add the task to.
     * @param ui    The Ui instance used to format the response message.
     * @return A confirmation message indicating the task was added and the current list size.
     */
    @Override
    public String execute(TaskList tasks, Ui ui) {
        tasks.addTask(task);
        Storage.save(tasks.getTasks());
        return ui.showMessage("okay, added: \n" + task + "\n you have " + tasks.size() + " tasks in the list currently");
    }
}
