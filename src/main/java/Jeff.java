import java.util.Scanner;

public class Jeff {
    public static void receiveInput() {
        Task[] tasks = new Task[100];
        int count = 0;
        Scanner in = new Scanner(System.in);
        String response = in.nextLine();
        while (!response.equals("bye")) {
            String[] words = response.split(" ");
            if (words[0].equals("todo")) { // TODOs
                tasks[count] = new ToDos(response);
                tasks[count].printAdded();
                count++;
            } else if (words[0].equals("deadline")) { // DEADLINES
                response = verifyDeadline(response);
                tasks[count] = new Deadlines(response);
                tasks[count].printAdded();
                count++;
            } else if (words[0].equals("event")) { // EVENTS
                response = verifyEvent(response);
                tasks[count] = new Events(response);
                tasks[count].printAdded();
                count++;
            } else if (words.length > 1 && isDigit(words[1])) {
                int idx = Integer.parseInt(words[1]);
                String command = words[0];
                if (idx > count) {
                    System.out.println("\t____________________________________________________________");
                    System.out.println("\t delusional fella. task does not exist. try again...");
                    System.out.println("\t____________________________________________________________");
                }
                else {
                    tasks[idx-1].setCompletionStatus(command);
                }
            }
            else if (response.equals("list")) {
                printList(tasks, count);
            } else {
                tasks[count] = new Task(response);
                tasks[count].printAdded();
                count++;
            }
            response = in.nextLine();
        }
    }

    public static void main(String[] args) {
        String chatbotName = "Jeff";

        System.out.println("\t____________________________________________________________");
        System.out.println("\t Hello, myname" + chatbotName);
        System.out.println("\t What can i do for you?");
        System.out.println("\t____________________________________________________________");

        receiveInput();

        System.out.println("\t____________________________________________________________");
        System.out.println("\t Bye. Hope to see you again soon!");
        System.out.println("\t____________________________________________________________");
    }

    public static boolean isDigit(String word) {
        if (word == null) {
            return false;
        }
        try {
            Integer.parseInt(word);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    public static String verifyDeadline(String response) {
        if (!response.contains("/by")) {
            response += " /by tbd";
        } else if (response.indexOf("/by")+2 == response.length()-1){
            response += " tbd";
        }
        return response;
    }
    public static String verifyEvent(String response) {
        if (!response.contains("/from") && !response.contains("/to")){
            response += " /from tbd /to tbd";
        } else if (!response.contains("/to")) {
            response += " /to tbd";
        } else if (!response.contains("/from")) {
            String[] words = response.split("/to");
            System.out.println(words[0] + words[1]);
            response = words[0] + "/from tbd /to" + words[1];
        } else if (response.indexOf("/to")+2 == response.length()-1){
            response += " tbd";
        }
        return response;
    }
    public static void printList(Task[] tasks, int count){
        System.out.println("\t____________________________________________________________");
        for (int i = 0; i < count; i++) {
            int itemNumber = i+1;
            Task task = tasks[i];
            System.out.println("\t " + itemNumber + ". " + task.taskString());
        }
        System.out.println("\t____________________________________________________________");
    }
}
