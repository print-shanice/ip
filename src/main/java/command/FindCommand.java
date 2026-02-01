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
    public String execute(TaskList tasks, Ui ui) {
        ArrayList<Task> matches = tasks.findTasks(word);
        StringBuilder sb = new StringBuilder();
        if (matches.isEmpty()) {
            sb.append("no tasks match your keyword: ").append(word).append("\n");
        } else {
            sb.append("here are the matching tasks in your list:\n");
            for (int i = 0; i < matches.size(); i++) {
                sb.append(" ").append(i + 1).append(".").append(matches.get(i)).append("\n");
            }
        }
        return sb.toString();
    }
}
