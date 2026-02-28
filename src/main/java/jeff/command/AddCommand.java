package jeff.command;

import jeff.assets.Task;
import jeff.assets.TaskList;
import jeff.storage.Storage;
import jeff.ui.Ui;

public class AddCommand extends Command {
	private Task taskToAdd;
	public AddCommand(Task taskToAdd) {
		this.taskToAdd = taskToAdd;
	}

	@Override
	public void execute(TaskList tasks, Ui ui, Storage storage) {
		tasks.add(taskToAdd);
		taskToAdd.printAdded();
	}
}
