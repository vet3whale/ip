package jeff.command;

import jeff.assets.TaskList;
import jeff.storage.Storage;
import jeff.ui.Ui;

/**
 * Represents a command to exit the application.
 */
public class ByeCommand extends Command {
	/**
	 * Constructs a ByeCommand and sets the termination flag to true.
	 */
	public ByeCommand() {
		this.isExit = true;
	}

	/**
	 * Executes the bye command. No specific action is required here as the exit flag handles termination.
	 *
	 * @param tasks   The list of existing tasks.
	 * @param ui      The user interface component.
	 * @param storage The storage component.
	 */
	@Override
	public void execute(TaskList tasks, Ui ui, Storage storage){}
}
