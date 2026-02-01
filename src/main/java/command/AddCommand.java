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
    public String execute(TaskList tasks, Ui ui) {
        tasks.addTask(task);
        Storage.save(tasks.getTasks());

        return ui.showMessage("okay, added: \n" + task + "\n you have " + tasks.size() + " tasks in the list currently");
    }
}
