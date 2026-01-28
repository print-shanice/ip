package command;

import kiki.Storage;
import kiki.TaskList;
import kiki.Ui;
import task.Task;

public class AddCommand extends Command {
    private Task task;

    public AddCommand(Task task) {
        this.task = task;
    }

    @Override
    public void execute(TaskList tasks, Ui ui) {
        tasks.addTask(task);
        Storage.save(tasks.getTasks());

        ui.showMessage(" okay, added: " + task + "\n you have " + tasks.size() + " tasks in the list currently");
    }
}
