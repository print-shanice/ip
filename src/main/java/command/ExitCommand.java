package command;

import kiki.TaskList;
import kiki.Ui;

/**
 * Represents a command to exit the Kiki chatbot.
 */
public class ExitCommand extends Command {

    /**
     * Executes this exit command by returning the goodbye message from the UI.
     *
     * @param tasks The TaskList (not used by this command).
     * @param ui    The Ui instance used to retrieve the goodbye message.
     * @return The goodbye message string.
     */
    @Override
    public String execute(TaskList tasks, Ui ui) {
        return ui.showGoodbye();
    }
}
