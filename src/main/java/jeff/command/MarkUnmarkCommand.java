package jeff.command;

import jeff.assets.Task;
import jeff.assets.TaskList;
import jeff.exceptions.JeffException;
import jeff.storage.Storage;
import jeff.ui.Ui;

public class MarkUnmarkCommand extends Command {
	private int index;
	private boolean isMark;

	public MarkUnmarkCommand(int index, boolean isMark) {
		this.index = index;
		this.isMark = isMark;
	}

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
