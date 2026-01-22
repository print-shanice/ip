import java.util.Scanner;

public class kiki {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] tasks = new String[100];
        int numOfTasks = 0;


        System.out.println(" ____________________________________________________________\n" +
                " ughhhhhh hi \n" +
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
            else {
                tasks[numOfTasks] = input;
                numOfTasks++;
                System.out.println(" ____________________________________________________________");
                System.out.println(" added: " + input);
                System.out.println(" ____________________________________________________________");
            }
        }
        scanner.close();
    }
}
