package jeff;

import jeff.assets.TaskList;
import jeff.command.Command;
import jeff.exceptions.JeffException;
import jeff.parser.Parser;
import jeff.storage.Storage;
import jeff.ui.Ui;

public class Jeff {
    private static Storage storage;
    private static Ui ui;
    private static TaskList tasks = new TaskList();
    private static final String filePath = "data/tasks.txt";

    private static final String[] commandStrings = {
            "todo", "deadline", "event", "mark", "unmark", "list", "delete"
    };

    public Jeff(String filePath){
        storage = new Storage(filePath);
        ui = new Ui();
    }

    public static void run() throws JeffException {
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
                isExit = c.isExit();
            } catch (JeffException e) {

            }
        }
    }

    public static void main(String[] args) throws JeffException {
        new Jeff(filePath).run();
        ui.byeGreeting();
    }

}