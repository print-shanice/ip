package task;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 * Represents an Event task that has a description, start time and end time
 */

public class Event extends Task {
    private LocalDateTime start;
    private LocalDateTime end;

    private static final DateTimeFormatter INPUT = DateTimeFormatter.ofPattern("d/M/yyyy HHmm");
    private static final DateTimeFormatter OUTPUT = DateTimeFormatter.ofPattern("MMM d yyyy, h:mma");

    /**
     * Constructs an Event with the given description, from time and to time
     * @param name the description of the Deadline
     * @param from the from time of the Deadline
     * @param to the to time of the Deadline
     */
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

    /**
     * Returns the formatted file string representation of Event
     */
    @Override
    public String toFileString() {
        return "E | " + (status == TaskStatus.DONE ? "1" : "0") + " | " + name +
                " | " + start.format(OUTPUT) + " | " + end.format(OUTPUT);
    }

    @Override
    public void snooze(String newBy) {
        this.end = LocalDateTime.parse(newBy.trim(), INPUT);;
    }
}
