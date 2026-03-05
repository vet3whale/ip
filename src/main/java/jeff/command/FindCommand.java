package jeff.command;

import jeff.assets.Task;
import jeff.assets.TaskList;
import jeff.storage.Storage;
import jeff.ui.Ui;

/**
 * Represents a command to find tasks that match a given keyword.
 */
public class FindCommand extends Command{
	private String stringToFind;

	/**
	 * Constructs a FindCommand with the specified search string.
	 *
	 * @param stringToFind The keyword to search for in task descriptions.
	 */
	public FindCommand(String stringToFind) {
		this.stringToFind = stringToFind;
	}

	/**
	 * Executes the find command by searching for tasks containing the keyword and printing the results.
	 *
	 * @param tasks   The list of existing tasks.
	 * @param ui      The user interface to display the matching tasks.
	 * @param storage The storage component.
	 */
	@Override
	public void execute(TaskList tasks, Ui ui, Storage storage) {

		ui.showLine();
		System.out.println("here are the matching tasks in your list:");
		int count = 0;
		for (Task task : tasks) {
			String taskDescription = task.getDescription();
			if (taskDescription.contains(stringToFind)) {
				count++;
				System.out.println(" " + task.taskString());
			}
		}
		if (count == 0) {
			System.out.println(" sike, we found nothing");
		}
		ui.showLine();
	}
}
