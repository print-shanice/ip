public class DeleteCommand extends Command {
    private int task;

    public DeleteCommand(int task) {
        this.task = task;
    }

    @Override
    public void execute(TaskList tasks, Ui ui) {
        try {
            tasks.removeTask(task);
            Storage.save(tasks.getTasks());

            ui.showMessage(" okay, removed: " + task + "\n you have " + tasks.size() + " tasks in the list currently");
        } catch (IndexOutOfBoundsException e) {
            ui.showError("that task number does not exist!");
        } catch (NumberFormatException e) {
            ui.showError("provide a valid task number to delete!");
        }
    }
}
