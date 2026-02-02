package command;

import kiki.Storage;
import kiki.TaskList;
import kiki.Ui;
import task.Task;

public class MarkCommand extends Command {
    private final int index;

    public MarkCommand(int index) {
        this.index = index;
    }

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
