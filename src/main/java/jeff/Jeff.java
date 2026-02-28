package jeff;

import jeff.exceptions.JeffException;

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

    public void run() {
        storage.loadTasks(tasks);
        Parser parser = new Parser();

        String chatbotName = "jeff";
        ui.helloGreeting(chatbotName);

        boolean isExit = false;
        while (!isExit) {
            String fullCommand = ui.readCommand();
            isExit = parser.readResponse(fullCommand, tasks);
        }
    }

    public static void main(String[] args) throws JeffException {
        new Jeff(filePath).run();
        ui.byeGreeting();
    }

}