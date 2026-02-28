package jeff.command;

import jeff.assets.TaskList;
import jeff.storage.Storage;
import jeff.ui.Ui;

public class ByeCommand extends Command {
	public ByeCommand() {
		this.isExit = true;
	}
	@Override
	public void execute(TaskList tasks, Ui ui, Storage storage){

	}
}
