package command;
import kiki.TaskList;
import kiki.Ui;

public class ListCommand extends Command {

    @Override
    public void execute(TaskList tasks, Ui ui) {
        tasks.listTasks(ui);
    }
}
