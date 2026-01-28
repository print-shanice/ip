package task;

public abstract class Task {
    protected String name;
    protected TaskStatus status;
    protected TaskType type;

    public abstract String toFileString();

    public Task(String name) {
        this.name = name;
        this.status = TaskStatus.NOT_DONE;
    }

    public void markDone() {
        this.status = TaskStatus.DONE;
    }

    public void markNotDone() {
        this.status = TaskStatus.NOT_DONE;
    }

    @Override
    public String toString() {
        return type.getSymbol() + "[" + (status == TaskStatus.DONE ? "X" : " ") + "] " + name;
    }
}
