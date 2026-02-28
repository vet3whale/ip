package jeff.command;

import jeff.assets.Task;
import jeff.assets.TaskList;
import jeff.storage.Storage;
import jeff.ui.Ui;

public class FindCommand extends Command{
	private String stringToFind;
	public FindCommand(String stringToFind) {
		this.stringToFind = stringToFind;
	}
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
