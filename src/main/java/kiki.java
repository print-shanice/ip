import java.util.Scanner;

public class kiki {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(" ____________________________________________________________\n" +
                " hi! \n" +
                " i'm kiki\n" +
                " what do you want?\n" +
                " ____________________________________________________________\n");

        while (true) {
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("bye")) {
                System.out.println(" finallyyyyy, bye!\n" + " ____________________________________________________________");
                break;
            }
            else {
                System.out.println(" ____________________________________________________________\n " +
                        input + "\n ____________________________________________________________");
            }
        }
        scanner.close();
    }
}
