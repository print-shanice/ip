import java.util.Scanner;

public class kiki {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Task[] tasks = new Task[100];
        int numOfTasks = 0;


        System.out.println(" ____________________________________________________________\n" +
                " good morning \n" +
                " i'm kiki\n" +
                " what do you want?\n" +
                " ____________________________________________________________\n");

        while (true) {
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("bye")) {
                System.out.println(" ____________________________________________________________");
                System.out.println(" finallyyyyy, bye!\n" + " ____________________________________________________________");
                break;
            }
            else if (input.equalsIgnoreCase("list")) {
                System.out.println(" ____________________________________________________________\n");
                if (numOfTasks == 0) {
                    System.out.println(" no tasks added");
                } else {
                    for (int i = 0; i < numOfTasks; i++) {
                        System.out.println(" " + (i + 1) + ". " + tasks[i]);
                    }
                }
                System.out.println(" ____________________________________________________________\n");
            }
            else if (input.toLowerCase().startsWith("mark")) {
                int index = Integer.parseInt(input.split(" ")[1]) - 1;
                tasks[index].markDone();
                System.out.println(" ____________________________________________________________");
                System.out.println("you're welcome, i've marked this task as done: ");
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

            else {
                tasks[numOfTasks] = new Task(input);
                numOfTasks++;
                System.out.println(" ____________________________________________________________");
                System.out.println(" added: " + input);
                System.out.println(" ____________________________________________________________");
            }
        }
        scanner.close();
    }
}
