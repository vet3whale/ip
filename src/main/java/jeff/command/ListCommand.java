package jeff.command;

import jeff.assets.TaskList;
import jeff.storage.Storage;
import jeff.ui.Ui;

/**
 * Represents a command to list all tasks currently in the task list.
 */
public class ListCommand extends Command {
	/**
	 * Executes the list command and prints all existing tasks to the user interface.
	 *
	 * @param tasks   The list of existing tasks.
	 * @param ui      The user interface to display the tasks.
	 * @param storage The storage component (unused in this command).
	 */
	@Override
	public void execute(TaskList tasks, Ui ui, Storage storage) {
		ui.printList(tasks);
	}
}
