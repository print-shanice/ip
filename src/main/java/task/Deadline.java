package task;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 * Represents a Deadline task that has a description, and deadline time
 */

public class Deadline extends Task {
    private LocalDateTime date;
    private static final DateTimeFormatter INPUT = DateTimeFormatter.ofPattern("d/M/yyyy HHmm");
    private static final DateTimeFormatter OUTPUT = DateTimeFormatter.ofPattern("MMM d yyyy, h:mma");

    /**
     * Constructs a Deadline with the given description and by time
     * @param name the description of the Deadline
     * @param by the by time of the Deadline
     */
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
