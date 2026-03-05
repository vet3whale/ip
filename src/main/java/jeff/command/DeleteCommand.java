package jeff.command;

import jeff.assets.Task;
import jeff.assets.TaskList;
import jeff.exceptions.JeffException;
import jeff.storage.Storage;
import jeff.ui.Ui;

/**
 * Represents a command to delete a specific task from the task list.
 */
public class DeleteCommand extends Command {
	private int index;

	/**
	 * Constructs a DeleteCommand with the specified index of the task to be deleted.
	 *
	 * @param index The zero-based index of the task to delete.
	 */
	public DeleteCommand(int index) {
		this.index = index;
	}

	/**
	 * Executes the delete command, removes the task from the list, and prints a deletion message.
	 *
	 * @param tasks   The list of existing tasks.
	 * @param ui      The user interface to display the deletion confirmation.
	 * @param storage The storage component for saving the updated list.
	 * @throws JeffException If the provided index is out of bounds.
	 */
	@Override
	public void execute(TaskList tasks, Ui ui, Storage storage) throws JeffException {
		if (index >= tasks.size() || index < 0) {
			throw new JeffException(JeffException.ErrorType.IDX_OUTOFBOUNDS, "");
		}
		Task taskToDelete = tasks.get(index);
		tasks.remove(taskToDelete);
		taskToDelete.printDeleted(tasks);
	}
}
