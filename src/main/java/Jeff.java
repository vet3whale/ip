import java.util.Scanner;
import java.util.Arrays;

public class Jeff {
    public static void printList(String[] tasks, int count){
        System.out.println("\t____________________________________________________________");
        for (int i = 0; i < count; i++) {
            int itemNumber = i+1;
            System.out.println("\t " + itemNumber + ". " + tasks[i]);
        }
        System.out.println("\t____________________________________________________________");
    }

    public static void receiveInput() {
        String[] tasks = new String[100];
        int count = 0;
        Scanner in = new Scanner(System.in);
        String response = in.nextLine();
        while (!response.equals("bye")) {
            if (response.equals("list")) {
                printList(tasks, count);
            } else {
                tasks[count] = response;
                count++;
                System.out.println("\t____________________________________________________________");
                System.out.println("\t added: " + response);
                System.out.println("\t____________________________________________________________");
            }
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

        System.out.println("\t____________________________________________________________");
        System.out.println("\t Bye. Hope to see you again soon!");
        System.out.println("\t____________________________________________________________");
    }
}
