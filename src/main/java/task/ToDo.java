package task;

/**
 * Represents a todo task that has a description
 */

public class ToDo extends Task {

    public ToDo(String name) {
        super(name);
        this.type = TaskType.TODO;
    }

    @Override
    public String toFileString() {
        return "D | " + (status == TaskStatus.DONE ? "1" : "0") + " | " + name;
    }

}
