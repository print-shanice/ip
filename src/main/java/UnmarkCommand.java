import task.Task;

public class UnmarkCommand extends Command {
    private int index;

    public UnmarkCommand(int index) {
        this.index = index;
    }

    @Override
    public void execute(TaskList tasks, Ui ui) {
        try {
            Task task = tasks.getTask(index);
            task.markNotDone();
            Storage.save(tasks.getTasks());
            ui.showMessage(" you're welcome, i've marked this task as not done: " + task);
        } catch (IndexOutOfBoundsException e) {
            ui.showError("that task number does not exist!");
        } catch (NumberFormatException e) {
            ui.showError("please provide a valid task number to unmark!");
        }  catch (IllegalArgumentException e) {
            ui.showError(e.getMessage());
        }
    }
}
