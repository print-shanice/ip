package command;

import kiki.TaskList;
import kiki.Ui;

/**
 * Represents a user command in the Kiki chatbot
 */
public abstract class Command {
    protected boolean isExit = false;

    /**
     * Executes user command
     *
     * @param tasks The TaskList object to operate on
     * @param ui The Ui Object to interact with the user
     */
    public abstract String execute(TaskList tasks, Ui ui);

    /**
     * Returns true if the command should exit the program
     * @return boolean representing if command is an exit command
     */
    public boolean isExit() {
        return isExit;
    }
}
