package command;

import kiki.Storage;
import kiki.TaskList;
import kiki.Ui;
import task.Task;

public class MarkCommand extends Command {
    private int index;

    public MarkCommand(int index) {
        this.index = index;
    }

    @Override
    public void execute(TaskList tasks, Ui ui) {
        try {
            Task task = tasks.getTask(index);
            task.markDone();
            Storage.save(tasks.getTasks());
            ui.showMessage(" you're welcome, i've marked this task as done: " + task);
        } catch (IndexOutOfBoundsException e) {
            ui.showError("that task number does not exist!");
        } catch (NumberFormatException e) {
            ui.showError("please provide a valid task number to mark!");
        }
    }
}
