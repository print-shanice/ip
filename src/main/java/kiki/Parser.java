package kiki;

import command.*;
import task.Deadline;
import task.Event;
import task.ToDo;

public class Parser {
    public static Command parse(String input) throws IllegalArgumentException {
        String[] words = input.trim().split("\\s+", 2);
        String command = words[0].toLowerCase();

        switch (command) {
            case "bye":
                return new ExitCommand();

            case "list":
                return new ListCommand();

            case "mark":
                if (words.length < 2) throw new IllegalArgumentException("specify task number!");
                int markIndex = Integer.parseInt(words[1]) - 1;
                return new MarkCommand(markIndex);

            case "unmark":
                if (words.length < 2) throw new IllegalArgumentException("specify task number!");
                int unmarkIndex = Integer.parseInt(words[1]) - 1;
                return new UnmarkCommand(unmarkIndex);

            case "todo":
                if (words.length < 2) throw new IllegalArgumentException("todo description cannot be empty");
                return new AddCommand(new ToDo(words[1].trim()));

            case "deadline":
                if (words.length < 2) throw new IllegalArgumentException("deadline must have description and a /by date!");
                String[] deadlineDate = words[1].split("/by", 2);
                if (deadlineDate.length < 2) throw new IllegalArgumentException("use the format: deadline <desc> /by <date>");
                return new AddCommand(new Deadline(deadlineDate[0].trim(), deadlineDate[1].trim()));

            case "event":
                if (words.length < 2) throw new IllegalArgumentException("event must have description, /from date and /to date!");
                String[] eventDate = words[1].split("/from|/to");
                if (eventDate.length < 3) throw new IllegalArgumentException("use the format: event <desc> /from <date> /to <date>");
                return new AddCommand(new Event(eventDate[0].trim(), eventDate[1].trim(), eventDate[2].trim()));

            case "delete":
                if (words.length < 2) throw new IllegalArgumentException("specify task number!");
                return new DeleteCommand(Integer.parseInt(words[1]) - 1);

            default:
                throw new IllegalArgumentException("not sure what that means...");
        }
    }
}
