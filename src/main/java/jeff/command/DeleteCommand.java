package jeff.command;

import jeff.assets.Task;
import jeff.assets.TaskList;
import jeff.exceptions.JeffException;
import jeff.storage.Storage;
import jeff.ui.Ui;

public class DeleteCommand extends Command {
	private int index;

	public DeleteCommand(int index) {
		this.index = index;
	}

	@Override
	public void execute(TaskList tasks, Ui ui, Storage storage) throws JeffException {
		if (index >= tasks.size() || index < 0) {
			throw new JeffException(JeffException.ErrorType.IDX_OUTOFBOUNDS, "");
		}
		Task taskToDelete = tasks.get(index);
		tasks.remove(taskToDelete);
		ui.printDeletedStatus(taskToDelete, tasks);
	}
}
