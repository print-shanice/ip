package task;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Event extends Task {
    private LocalDateTime start;
    private LocalDateTime end;

    private static final DateTimeFormatter INPUT = DateTimeFormatter.ofPattern("d/M/yyyy HHmm");
    private static final DateTimeFormatter OUTPUT = DateTimeFormatter.ofPattern("MMM d yyyy, h:mma");

    public Event(String name, String from, String to) {
        super(name);
        this.type = TaskType.EVENT;
        try {
            this.end = LocalDateTime.parse(to.trim(),INPUT);
            this.start = LocalDateTime.parse(from.trim(), INPUT);
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("date must be in format D/M/YYYY HHmm");
        }
    }

    @Override
    public String toString() {
        return super.toString() + " (from: " + start.format(OUTPUT) + " to: " + end.format(OUTPUT) + ")";
    }

    @Override
    public String toFileString() {
        return "E | " + (status == TaskStatus.DONE ? "1" : "0") + " | " + name + " | " + start.format(OUTPUT) + " | " + end.format(OUTPUT);
    }
}
