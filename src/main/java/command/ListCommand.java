package command;

import kiki.TaskList;
import kiki.Ui;

/**
 * Represents a command to list all tasks currently in the task list
 * in the Kiki chatbot.
 */
public class ListCommand extends Command {

    /**
     * Executes this list command by building and returning a numbered list
     * of all tasks currently in the task list.
     *
     * @param tasks The TaskList whose tasks will be listed.
     * @param ui    The Ui instance (not directly used; output is built via StringBuilder).
     * @return A formatted string containing all tasks numbered from 1.
     */
    @Override
    public String execute(TaskList tasks, Ui ui) {
        StringBuilder sb = new StringBuilder();
        sb.append("here are the tasks in your list:\n");
        for (int i = 0; i < tasks.size(); i++) {
            sb.append(" ").append(i + 1).append(".").append(tasks.getTask(i)).append("\n");
        }
        return sb.toString();
    }
}

