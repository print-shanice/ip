package command;

import java.util.ArrayList;

import kiki.TaskList;
import kiki.Ui;
import task.Task;

public class FindCommand extends Command {
    private final String word;

    public FindCommand(String word) {
        this.word = word;
    }

    @Override
    public void execute(TaskList tasks, Ui ui) {
        ArrayList<Task> matches = tasks.findTasks(word);
        if (matches.isEmpty()) {
            ui.showMessage(" no tasks match your keyword: " + word);
        } else {
            ui.showLine();
            ui.showPlainMessage(" the matching tasks in your lists are here: ");
            for (int i = 0; i < matches.size(); i++) {
                ui.showPlainMessage(" " + (i + 1) + "." + matches.get(i));
            }
            ui.showLine();
        }
    }
}
