package task;

public class Deadline extends Task {
    private String date;

    public Deadline(String name, String date) {
        super(name);
        this.date = date;
        this.type = TaskType.DEADLINE;
    }

    @Override
    public String toString() {
        return super.toString() + " (by: " + date + ")";
    }
}
