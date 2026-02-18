package command;

import java.time.format.DateTimeParseException;

import kiki.Storage;
import kiki.TaskList;
import kiki.Ui;
import task.Task;

/**
 * Represents a command to snooze a task by updating its date to a new date
 * in the Kiki chatbot. Only applicable to tasks with a date field (i.e. Deadline or Event).
 */
public class SnoozeCommand extends Command {
    /** The zero-based index of the task to snooze. */
    private int taskIndex;

    /** The new date string in the format {@code d/M/yyyy HHmm}. */
    private String newDate;

    /**
     * Constructs a SnoozeCommand for the task at the given index with the given new date.
     *
     * @param taskIndex The zero-based index of the task to snooze.
     * @param newDate   The new date string in the format {@code d/M/yyyy HHmm}.
     */
    public SnoozeCommand(int taskIndex, String newDate) {
        this.taskIndex = taskIndex;
        this.newDate = newDate;
    }

    /**
     * Executes this snooze command by updating the date of the task at the stored index.
     * If the task does not support snoozing (e.g. a ToDo), an error message is returned.
     *
     * @param tasks The TaskList containing the task to snooze.
     * @param ui    The Ui instance used to format the response message.
     * @return A confirmation message showing the snoozed task, or an error message if snoozing is unsupported.
     */
    @Override
    public String execute(TaskList tasks, Ui ui) {
        Task task = tasks.getTask(this.taskIndex);
        try {
            task.snooze(newDate);
            Storage.save(tasks.getTasks());
            return ui.showMessage("okay, task has been snoozed: " + task);
        } catch (UnsupportedOperationException e) {
            return ui.showError(e.getMessage());
        } catch (IllegalArgumentException | DateTimeParseException e) {
            return ui.showError("invalid date! date must be in format D/M/YYYY HHmm");
        }
    }
}
