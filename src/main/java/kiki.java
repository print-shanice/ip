import java.util.ArrayList;
import java.util.Scanner;

public class kiki {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Task> tasks = new ArrayList<>();


        System.out.println(" ____________________________________________________________");
        System.out.println(" good morning");
        System.out.println(" i'm kiki");
        System.out.println(" what do you want?");
        System.out.println(" ____________________________________________________________");


        while (true) {
            String input = scanner.nextLine().trim();
            if (input.equalsIgnoreCase("bye")) {
                System.out.println(" ____________________________________________________________");
                System.out.println(" finallyyyyy, bye!");
                System.out.println(" ____________________________________________________________");
                break;
            }
            else if (input.equalsIgnoreCase("list")) {
                System.out.println(" ____________________________________________________________");
                if (tasks.isEmpty()) {
                    System.out.println(" no tasks added");
                } else {
                    for (int i = 0; i < tasks.size(); i++) {
                        System.out.println(" " + (i + 1) + ". " + tasks.get(i));
                    }
                }
                System.out.println(" ____________________________________________________________");
            }
            else if (input.toLowerCase().startsWith("mark")) {
                try {
                    String[] parts = input.trim().split("\\s+");
                    if (parts.length < 2) {
                        throw new IllegalArgumentException("specify a task number!");
                    }
                    int index = Integer.parseInt(input.split(" ")[1]) - 1;
                    if (index < 0 || index >= tasks.size()) {
                        throw new IndexOutOfBoundsException();
                    }
                    tasks.get(index).markDone();
                    System.out.println(" ____________________________________________________________");
                    System.out.println(" you're welcome, i've marked this task as done:");
                    System.out.println(" " + tasks.get(index));
                    System.out.println(" ____________________________________________________________");
                } catch (IndexOutOfBoundsException e) {
                    System.out.println(" ____________________________________________________________");
                    System.out.println(" oi! that task number does not exist!");
                    System.out.println(" ____________________________________________________________");
                } catch (NumberFormatException e) {
                    System.out.println(" ____________________________________________________________");
                    System.out.println(" oi! please provide a valid task number to mark!");
                    System.out.println(" ____________________________________________________________");
                }  catch (IllegalArgumentException e) {
                    System.out.println(" ____________________________________________________________");
                    System.out.println(" oi! " + e.getMessage());
                    System.out.println(" ____________________________________________________________");
                }
            }

            else if (input.toLowerCase().startsWith("unmark")){
                try {
                    String[] parts = input.trim().split("\\s+");
                    if (parts.length < 2) {
                        throw new IllegalArgumentException("specify a task number!");
                    }

                    int index = Integer.parseInt(input.split(" ")[1]) - 1;
                    if (index < 0 || index >= tasks.size()) {
                        throw new IndexOutOfBoundsException();
                    }
                    tasks.get(index).markNotDone();
                    System.out.println(" ____________________________________________________________");
                    System.out.println(" you're welcome, i've marked this task as not done:");
                    System.out.println(" " + tasks.get(index));
                    System.out.println(" ____________________________________________________________");
                } catch (IndexOutOfBoundsException e) {
                    System.out.println(" ____________________________________________________________");
                    System.out.println(" oi! that task number does not exist!");
                    System.out.println(" ____________________________________________________________");
                } catch (NumberFormatException e) {
                    System.out.println(" ____________________________________________________________");
                    System.out.println(" oi! please provide a valid task number to unmark!");
                    System.out.println(" ____________________________________________________________");
                }  catch (IllegalArgumentException e) {
                    System.out.println(" ____________________________________________________________");
                    System.out.println(" oi! " + e.getMessage());
                    System.out.println(" ____________________________________________________________");
                }
            }

            else if (input.toLowerCase().startsWith("todo")) {
                try {
                    if (input.length() <= 5) {
                        throw new IllegalArgumentException("todo description cannot be empty");
                    }
                    String name = input.substring(5).trim();
                    tasks.add(new ToDo(name));
                    System.out.println(" ____________________________________________________________");
                    System.out.println(" okay, added: " + tasks.get(tasks.size() - 1));
                    System.out.println(" you have " + tasks.size() + " tasks in the list currently");
                    System.out.println(" ____________________________________________________________");
                } catch (IllegalArgumentException exception) {
                    System.out.println(" ____________________________________________________________");
                    System.out.println(" oi! " + exception.getMessage());
                    System.out.println(" ____________________________________________________________");
                }

            }

            else if (input.toLowerCase().startsWith("deadline")) {
                try {
                    if (input.length() <= 9) {
                        throw new IllegalArgumentException("deadline must have description and a /by date!");
                    }

                    String[] parts = input.substring(9).split("/by", 2);
                    if (parts.length < 2) {
                        throw new IllegalArgumentException("use the format: deadline <description> /by <date>");
                    }

                    String name = parts[0].trim();
                    String date = parts[1].trim();
                    if (name.isEmpty() || date.isEmpty()) {
                        throw new IllegalArgumentException("deadline must have description and a /by date!");
                    }
                    tasks.add(new Deadline(name, date));
                    System.out.println(" ____________________________________________________________");
                    System.out.println(" okay, added: " + tasks.get(tasks.size() - 1));
                    System.out.println(" you have " + tasks.size() + " tasks in the list currently");
                    System.out.println(" ____________________________________________________________");
                } catch (IllegalArgumentException e) {
                    System.out.println(" ____________________________________________________________");
                    System.out.println(" oi! " + e.getMessage());
                    System.out.println(" ____________________________________________________________");
                }
            }

            else if (input.toLowerCase().startsWith("event")) {
                try {
                    if (input.length() <= 6) {
                        throw new IllegalArgumentException("event must have a description, /from time, and /to time!");
                    }

                    String[] parts = input.substring(6).split("/from|/to");
                    if (parts.length < 3) {
                        throw new IllegalArgumentException("use the format: event <description> /from <start> /to <end>");
                    }

                    String name = parts[0].trim();
                    String start = parts[1].trim();
                    String end = parts[2].trim();
                    if (name.isEmpty() || start.isEmpty() || end.isEmpty()) {
                        throw new IllegalArgumentException("event must have a description, /from time, and /to time!");
                    }
                    tasks.add( new Event(name, start, end));
                    System.out.println(" ____________________________________________________________");
                    System.out.println(" okay, added: " + tasks.get(tasks.size() - 1));
                    System.out.println(" you have " + tasks.size() + " tasks in the list currently");
                    System.out.println(" ____________________________________________________________");
                } catch (IllegalArgumentException e) {
                    System.out.println(" ____________________________________________________________");
                    System.out.println(" oi! " + e.getMessage());
                    System.out.println(" ____________________________________________________________");
                }
            }
            else if (input.toLowerCase().startsWith("delete")) {
                try {
                    String[] parts = input.trim().split("\\s+");
                    if (parts.length < 2) {
                        throw new IllegalArgumentException("specify task number to delete!");
                    }
                    int index = Integer.parseInt(parts[1]) - 1;

                    if (index < 0 || index >= tasks.size()) {
                        throw new IndexOutOfBoundsException();
                    }
                    Task temp = tasks.remove(index);

                    System.out.println(" ____________________________________________________________");
                    System.out.println(" okay, removed: " + temp);
                    System.out.println(" now you have " + tasks.size() + " tasks in the list currently");
                    System.out.println(" ____________________________________________________________");
                } catch (IndexOutOfBoundsException e) {
                    System.out.println(" ____________________________________________________________");
                    System.out.println(" oi! that task number does not exist!");
                    System.out.println(" ____________________________________________________________");
                } catch (NumberFormatException e) {
                    System.out.println(" ____________________________________________________________");
                    System.out.println(" oi! please provide a valid task number to delete!");
                    System.out.println(" ____________________________________________________________");
                } catch (IllegalArgumentException e) {
                    System.out.println(" ____________________________________________________________");
                    System.out.println(" oi! " + e.getMessage());
                    System.out.println(" ____________________________________________________________");
                }
            }

            else {
                System.out.println(" ____________________________________________________________");
                System.out.println(" not sure what that means...");
                System.out.println(" try todo, deadline or event");
                System.out.println(" ____________________________________________________________");
            }
        }
        scanner.close();
    }
}
