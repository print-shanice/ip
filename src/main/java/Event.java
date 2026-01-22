public class Event extends Task {
    private String start;
    private String end;
    public Event(String name, String start, String end) {
        super(name);
        this.end = end;
        this.start = start;
    }

    @Override
    public String toString() {
        return "[E]" + super.toString() + " (from: " + start + " to: " + end + ")";
    }
}
