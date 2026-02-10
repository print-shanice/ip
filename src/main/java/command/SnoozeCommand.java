package command;

import kiki.Storage;
import kiki.TaskList;
import kiki.Ui;
import task.Task;

/**
 * Represents a user command to add tasks in the Kiki chatbot
 */

public class SnoozeCommand extends Command {
    private int taskIndex;
    private String newDate;

    public SnoozeCommand(int taskIndex, String newDate) {
        this.taskIndex = taskIndex;
        this.newDate = newDate;
    }

    @Override
    public String execute(TaskList tasks, Ui ui) {
        Task task = tasks.getTask(this.taskIndex);
        try {
            task.snooze(newDate);
            return ui.showMessage("okay, task has been snoozed: " + task);
        } catch (UnsupportedOperationException e) {
            return ui.showError(e.getMessage());
        }
    }
}
