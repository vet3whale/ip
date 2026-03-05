package jeff.command;

import jeff.assets.TaskList;
import jeff.storage.Storage;
import jeff.ui.Ui;

/**
 * Represents a command to display a help menu detailing all available commands.
 */
public class HelpCommand extends Command {

	/**
	 * Executes the help command and prints out a guide on how to use Jeff.
	 *
	 * @param tasks   The list of existing tasks.
	 * @param ui      The user interface to display the help message.
	 * @param storage The storage component (unused in this command).
	 */
	@Override
	public void execute(TaskList tasks, Ui ui, Storage storage) {
		ui.showLine();
		System.out.println(" this guy can't remember nothing. here is a list of what i can do:");
		System.out.println("  1. todo <description> : adds a basic todo task.");
		System.out.println("  2. deadline <description> /by <time> : adds a deadline task.");
		System.out.println("  3. event <description> /from <start> /to <end> : adds an event.");
		System.out.println("  4. list : shows all your tasks.");
		System.out.println("  5. mark <index> : marks a task as done.");
		System.out.println("  6. unmark <index> : unmarks a task.");
		System.out.println("  7. delete <index> : delete a task.");
		System.out.println("  8. find <keyword> : searches for a task.");
		System.out.println("  9. help : you are looking at it.");
		System.out.println("  10. bye : if you wanna leave the app.");
		System.out.println("\n don't make me repeat myself.");
		ui.showLine();
	}
}