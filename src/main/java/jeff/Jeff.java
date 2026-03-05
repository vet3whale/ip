package jeff;

import jeff.assets.TaskList;
import jeff.command.Command;
import jeff.exceptions.JeffException;
import jeff.parser.Parser;
import jeff.storage.Storage;
import jeff.ui.Ui;

/**
 * Welcome to my task tracking chatbot, Jeff, that remembers your events, deadlines and todo.
 * BEWARE: Jeff ain't your fruity chatbot that talks to you nice when you make mistakes.
 * If you think Jeff is a regular name, you lack ball knowledge, mynameJeff.
 **/

public class Jeff {
    private static Storage storage;
    private static Ui ui;
    private static TaskList tasks = new TaskList();
    private static final String filePath = "data/tasks.txt";

    private static final String[] commandStrings = {
            "todo", "deadline", "event", "mark", "unmark", "list", "delete"
    };

    /**
     * Initializes the Jeff chatbot with the specified file path for storage.
     *
     * @param filePath The path to the file where tasks are saved.
     */
    public Jeff(String filePath){
        storage = new Storage(filePath);
        ui = new Ui();
    }

    /**
     * Runs the main loop of the chatbot.
     * Continuously reads user input, parses it, and executes the corresponding commands
     * until the exit command is given.
     */
    public static void run() {
        storage.loadTasks(tasks);
        Parser parser = new Parser();

        String chatbotName = "jeff";
        ui.helloGreeting(chatbotName);

        boolean isExit = false;
        while (!isExit) {
            try {
                String fullCommand = ui.readCommand();
                Command c = parser.readResponse(fullCommand, tasks);
                c.execute(tasks, ui, storage);
                storage.storeTasks(tasks);
                isExit = c.isExit();
            } catch (JeffException e) {

            }
        }
    }
    /**
     * The main method that starts the application.
     *
     * @param args Command line arguments used to run the program.
     */
    public static void main(String[] args) {
        new Jeff(filePath).run();
        ui.byeGreeting();
    }

}