package task;

/**
 * Represents a generic task with a name, type and status
 */
public abstract class Task {
    protected String name;
    protected TaskStatus status;
    protected TaskType type;

    /**
     * Returns the storage string representation of the task
     */
    public abstract String toFileString();

    /**
     * Constructs a Task with the given description
     * @param name the description of the task
     */
    public Task(String name) {
        this.name = name;
        this.status = TaskStatus.NOT_DONE;
    }

    /**
     * Marks this task as done
     */
    public void markDone() {
        this.status = TaskStatus.DONE;
    }

    /**
     * Marks this task as not done
     */
    public void markNotDone() {
        this.status = TaskStatus.NOT_DONE;
    }

    @Override
    public String toString() {
        return type.getSymbol() + "[" + (status == TaskStatus.DONE ? "X" : " ") + "] " + name;
    }
}
