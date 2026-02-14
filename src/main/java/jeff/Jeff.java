package jeff;

import jeff.assets.Deadlines;
import jeff.assets.Events;
import jeff.assets.Task;
import jeff.assets.ToDos;
import jeff.exceptions.JeffException;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
public class Jeff {
    private enum CommandType {
        TODO, DEADLINE, EVENT, MARK, UNMARK, LIST
    }

    public static void receiveInput() throws JeffException {
        ArrayList<Task> tasks = new ArrayList<>();

        Scanner in = new Scanner(System.in);
        String response = in.nextLine();

        while (!response.equals("bye")) {
            try {
                String[] words = response.split(" ");
                String command = words[0];
                CommandType cmdType = parseCommand(command);

                switch (cmdType) {
                case TODO:
                    if (words.length < 2) {
                        throw new JeffException(JeffException.ErrorType.INCOMPLETE_COMMAND, "todo");
                    }
                    tasks.add(new ToDos(response));
                    tasks.get(tasks.size()-1).printAdded();
                    break;
                case DEADLINE:
                    if (words.length < 2) {
                        throw new JeffException(JeffException.ErrorType.INCOMPLETE_COMMAND, "deadline");
                    }
                    response = verifyDeadline(response);
                    tasks.add(new Deadlines(response));
                    tasks.get(tasks.size()-1).printAdded();
                    break;
                case EVENT:
                    if (words.length < 2) {
                        throw new JeffException(JeffException.ErrorType.INCOMPLETE_COMMAND, "event");
                    }
                    response = verifyEvent(response);
                    tasks.add(new Events(response));
                    tasks.get(tasks.size()-1).printAdded();
                    break;
                case MARK:
                case UNMARK:
                    if (words.length > 1 && isDigit(words[1])) {
                        int idx = Integer.parseInt(words[1]);
                        if (idx > tasks.size()) {
                            throw new JeffException(JeffException.ErrorType.IDX_OUTOFBOUNDS, "");
                        } else {
                            tasks.get(idx - 1).setCompletionStatus(command);
                        }
                    } else {
                        throw new JeffException(JeffException.ErrorType.IDX_OUTOFBOUNDS, "");
                    }
                    break;
                case LIST:
                    printList(tasks);
                    break;
                }
            } catch (JeffException e) {
            }
            response = in.nextLine();
        }

    }

    public static void main(String[] args) throws JeffException {
        String chatbotName = "jeff.Jeff";

        helloGreeting(chatbotName);
        receiveInput();
        byeGreeting();
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
            response = words[0] + "/from tbd /to" + words[1];
        } else if (response.indexOf("/to")+2 == response.length()-1){
            response += " tbd";
        }
        return response;
    }

    public static void helloGreeting(String chatbotName) {
        System.out.println("\t____________________________________________________________");
        System.out.println("\t Hello, myname" + chatbotName);
        System.out.println("\t What can i do for you?");
        System.out.println("\t____________________________________________________________");
    }
    public static void byeGreeting() {
        System.out.println("\t____________________________________________________________");
        System.out.println("\t Bye. Hope to see you again soon!");
        System.out.println("\t____________________________________________________________");
    }

    private static CommandType parseCommand(String input) throws JeffException {
        if (input == null || input.isBlank()) {
            throw new JeffException(JeffException.ErrorType.INCOMPLETE_COMMAND, "command");
        }

        String[] words = input.trim().split(" ");
        String cmd = words[0].toLowerCase();
        return switch (cmd) {
            case "todo" -> CommandType.TODO;
            case "deadline" -> CommandType.DEADLINE;
            case "event" -> CommandType.EVENT;
            case "mark" -> CommandType.MARK;
            case "unmark" -> CommandType.UNMARK;
            case "list" -> CommandType.LIST;
            default -> throw new JeffException(JeffException.ErrorType.UNKNOWN_COMMAND, words[0]);
        };
    }

    public static void printList(ArrayList<Task> tasks){
        System.out.println("\t____________________________________________________________");
        for (Task task : tasks) {
            System.out.println("\t " + tasks.indexOf(task) + ". " + task.taskString());
        }
        System.out.println("\t____________________________________________________________");
    }
}