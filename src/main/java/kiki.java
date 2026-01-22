import java.util.Scanner;

public class kiki {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Task[] tasks = new Task[100];
        int numOfTasks = 0;


        System.out.println(" ____________________________________________________________");
        System.out.println(" good morning");
        System.out.println(" i'm kiki");
        System.out.println(" what do you want?");
        System.out.println(" ____________________________________________________________");


        while (true) {
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("bye")) {
                System.out.println(" ____________________________________________________________");
                System.out.println(" finallyyyyy, bye!");
                System.out.println(" ____________________________________________________________");
                break;
            }
            else if (input.equalsIgnoreCase("list")) {
                System.out.println(" ____________________________________________________________");
                if (numOfTasks == 0) {
                    System.out.println(" no tasks added");
                } else {
                    for (int i = 0; i < numOfTasks; i++) {
                        System.out.println(" " + (i + 1) + ". " + tasks[i]);
                    }
                }
                System.out.println(" ____________________________________________________________");
            }
            else if (input.toLowerCase().startsWith("mark")) {
                int index = Integer.parseInt(input.split(" ")[1]) - 1;
                tasks[index].markDone();
                System.out.println(" ____________________________________________________________");
                System.out.println("you're welcome, i've marked this task as done:");
                System.out.println(" " + tasks[index]);
                System.out.println(" ____________________________________________________________");
            }

            else if (input.toLowerCase().startsWith("unmark")){
                int index = Integer.parseInt(input.split(" ")[1]) - 1;
                tasks[index].markNotDone();
                System.out.println(" ____________________________________________________________");
                System.out.println("you're welcome, i've marked this task as not done: ");
                System.out.println(" " + tasks[index]);
                System.out.println(" ____________________________________________________________");
            }

            else if (input.toLowerCase().startsWith("todo")) {
                String name = input.substring(5);
                tasks[numOfTasks++] = new ToDo(name);
                System.out.println(" ____________________________________________________________");
                System.out.println(" okay, added: " + tasks[numOfTasks - 1]);
                System.out.println(" you have " + numOfTasks + " tasks in the list currently");
                System.out.println(" ____________________________________________________________");
            }

            else if (input.toLowerCase().startsWith("deadline")) {
                String[] parts = input.substring(9).split("/by", 2);
                String name = parts[0].trim();
                String date = parts[1].trim();
                tasks[numOfTasks++] = new Deadline(name, date);
                System.out.println(" ____________________________________________________________");
                System.out.println(" okay, added: " + tasks[numOfTasks - 1]);
                System.out.println(" you have " + numOfTasks + " tasks in the list currently");
                System.out.println(" ____________________________________________________________");
            }

            else if (input.toLowerCase().startsWith("event")) {
                String[] parts = input.substring(6).split("/from|/to");
                String name = parts[0].trim();
                String start = parts[1].trim();
                String end = parts[2].trim();
                tasks[numOfTasks++] = new Event(name, start, end);
                System.out.println(" ____________________________________________________________");
                System.out.println(" okay, added: " + tasks[numOfTasks - 1]);
                System.out.println(" you have " + numOfTasks + " tasks in the list currently");
                System.out.println(" ____________________________________________________________");

            }

            else {
                tasks[numOfTasks] = new Task(input);
                numOfTasks++;
                System.out.println(" ____________________________________________________________");
                System.out.println(" added: " + input);
                System.out.println(" you have " + numOfTasks + " tasks in the list currently");
                System.out.println(" ____________________________________________________________");
            }
        }
        scanner.close();
    }
}
