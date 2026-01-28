import java.util.Scanner;
import java.util.Arrays;

public class Jeff {
    public static void receiveInput() {
        String line;
        Scanner in = new Scanner(System.in);
        String response = in.nextLine();
        while (!response.equals("bye")) {
            System.out.println("\t____________________________________________________________");
            System.out.println("\t " + response);
            System.out.println("\t____________________________________________________________");
            response = in.nextLine();
        }
    }
    public static void main(String[] args) {
        String chatbotName = "Jeff";

        System.out.println("\t____________________________________________________________");
        System.out.println("\t Hello! myname" + chatbotName);
        System.out.println("\t What can I do for you?");
        System.out.println("\t____________________________________________________________");

        receiveInput();

        System.out.println("\t Bye. Hope to see you again soon!");
        System.out.println("____________________________________________________________");
    }
}
