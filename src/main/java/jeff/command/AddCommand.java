package jeff.command;

import jeff.assets.Task;
import jeff.assets.TaskList;
import jeff.storage.Storage;
import jeff.ui.Ui;

/**
 * Represents a command to add a new task to the task list.
 */
public class AddCommand extends Command {
	private Task taskToAdd;

	/**
	 * Constructs an AddCommand with the specified task to be added.
	 *
	 * @param taskToAdd The task to be added to the list.
	 */
	public AddCommand(Task taskToAdd) {
		this.taskToAdd = taskToAdd;
	}

	/**
	 * Executes the add command, appends the task to the list, and prints a confirmation message.
	 *
	 * @param tasks   The list of existing tasks.
	 * @param ui      The user interface to display the confirmation.
	 * @param storage The storage component for saving the updated list.
	 */
	@Override
	public void execute(TaskList tasks, Ui ui, Storage storage) {
		tasks.add(taskToAdd);
		taskToAdd.printAdded();
	}
}
