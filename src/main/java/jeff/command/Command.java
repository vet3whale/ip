package jeff.command;

import jeff.assets.TaskList;
import jeff.exceptions.JeffException;
import jeff.storage.Storage;
import jeff.ui.Ui;

/**
 * Represents an abstract command that can be executed by the user.
 * Subclasses define specific command behaviors (e.g., adding, deleting, listing tasks).
 */
public abstract class Command {
	protected static boolean isExit = false;

	/**
	 * Executes the specific command. This method must be implemented by subclasses.
	 *
	 * @param tasks   The list of tasks.
	 * @param ui      The user interface component.
	 * @param storage The storage component for saving data.
	 * @throws JeffException If an error occurs during command execution.
	 */
	public abstract void execute(TaskList tasks, Ui ui, Storage storage) throws JeffException;

	/**
	 * Returns whether this command should terminate the application.
	 *
	 * @return True if the application should exit, false otherwise.
	 */
	public static boolean isExit(){
		return isExit;
	}
}
