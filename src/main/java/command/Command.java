package command;

import kiki.TaskList;
import kiki.Ui;

public abstract class Command {
    protected boolean isExit = false;

    public abstract void execute(TaskList tasks, Ui ui);

    public boolean isExit() {
        return isExit;
    }
}
