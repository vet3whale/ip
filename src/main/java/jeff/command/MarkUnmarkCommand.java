package jeff.command;

import jeff.assets.Task;
import jeff.assets.TaskList;
import jeff.exceptions.JeffException;
import jeff.storage.Storage;
import jeff.ui.Ui;

/**
 * Represents a command to mark a task as done or unmark a task as not done yet.
 */
public class MarkUnmarkCommand extends Command {
	private int index;
	private boolean isMark;

	/**
	 * Constructs a MarkUnmarkCommand for the task at the specified index.
	 *
	 * @param index  The zero-based index of the task to mark or unmark.
	 * @param isMark True if the task should be marked as done, false if it should be unmarked.
	 */
	public MarkUnmarkCommand(int index, boolean isMark) {
		this.index = index;
		this.isMark = isMark;
	}

	/**
	 * Executes the mark or unmark command and prints a corresponding confirmation message.
	 *
	 * @param tasks   The list of existing tasks.
	 * @param ui      The user interface to display the status change.
	 * @param storage The storage component for saving the updated list.
	 * @throws JeffException If the provided index is out of bounds.
	 */
	@Override
	public void execute(TaskList tasks, Ui ui, Storage storage) throws JeffException {
		if (index < 0 || index >= tasks.size()) {
			throw new JeffException(JeffException.ErrorType.IDX_OUTOFBOUNDS, "");
		}

		Task targetTask = tasks.get(index);

		if (this.isMark) {
			targetTask.setCompletionStatus("mark");
		} else {
			targetTask.setCompletionStatus("unmark");
		}
	}
}
