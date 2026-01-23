package task;

public class ToDo extends Task {

    public ToDo(String name) {
        super(name);
        this.type = TaskType.TODO;
    }


}
