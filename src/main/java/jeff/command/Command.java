package jeff.command;

import jeff.assets.TaskList;
import jeff.exceptions.JeffException;
import jeff.storage.Storage;
import jeff.ui.Ui;

public abstract class Command {
	protected static boolean isExit = false;
	public abstract void execute(TaskList tasks, Ui ui, Storage storage) throws JeffException;

	public static boolean isExit(){
		return isExit;
	}
}
