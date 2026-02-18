package command;

import java.util.ArrayList;

import kiki.TaskList;
import kiki.Ui;
import task.Task;

/**
 * Represents a command to find tasks whose names contain a given keyword
 * in the Kiki chatbot.
 */
public class FindCommand extends Command {
    /** The keyword to search for in task names. */
    private final String word;

    /**
     * Constructs a FindCommand with the given search keyword.
     *
     * @param word The keyword to search for in task names.
     */
    public FindCommand(String word) {
        this.word = word;
    }

    /**
     * Executes this find command by searching the task list for tasks whose names
     * contain the stored keyword (case-insensitive) and returning a formatted list
     * of matching tasks, or a message if no matches are found.
     *
     * @param tasks The TaskList to search through.
     * @param ui    The Ui instance (not directly used; output is built via StringBuilder).
     * @return A formatted string listing matching tasks, or a no-match message.
     */
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
