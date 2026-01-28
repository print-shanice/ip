package task;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Deadline extends Task {
    private LocalDateTime date;
    private static final DateTimeFormatter INPUT = DateTimeFormatter.ofPattern("d/M/yyyy HHmm");
    private static final DateTimeFormatter OUTPUT = DateTimeFormatter.ofPattern("MMM d yyyy, h:mma");

    public Deadline(String name, String by) {
        super(name);
        this.type = TaskType.DEADLINE;
        try {
            this.date = LocalDateTime.parse(by.trim(), INPUT);
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("date must be in format D/M/YYYY HHmm");
        }
    }

    @Override
    public String toString() {
        return super.toString() + " (by: " + date.format(OUTPUT) + ")";
    }

    @Override
    public String toFileString() {
        return "D | " + (status == TaskStatus.DONE ? "1" : "0") + " | " + name + " | " +  date.format(OUTPUT);
    }
}
