package jeff.assets;

import java.util.ArrayList;

/**
 * Represents a list of tasks.
 * This class serves as a wrapper for {@code ArrayList<Task>},
 * allowing for future extensions and abstractions of list operations.
 */
public class TaskList extends ArrayList<Task> {
	ArrayList<Task> tasks;

	/**
	 * Constructs an empty TaskList.
	 */
	public TaskList(){
		tasks = new ArrayList<Task>();
	}
}
