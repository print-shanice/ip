package command;

import kiki.Storage;
import kiki.TaskList;
import kiki.Ui;
import task.Task;

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
