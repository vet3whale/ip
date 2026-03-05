package jeff.assets;

/**
 * Represents a todo task that does not have any date or time attached to it.
 */
public class ToDos extends Task {
	/**
	 * Constructs a ToDos task with the specified description.
	 * * @param taskDescription The description of the todo task.
	 */
	public ToDos(String taskDescription) {
		super(taskDescription.substring(taskDescription.indexOf(' ')));
		super.prefix = "T";
	}

	/**
	 * Returns the string representation of the todo task for display purposes.
	 *
	 * @return The formatted string representation of the task.
	 */
	@Override
	public String taskString() {
		return "[T]" + super.taskString();
	}

	/**
	 * Returns the string representation of the todo task formatted for saving to a file.
	 *
	 * @return The formatted string for file storage.
	 */
	@Override
	public String loadingString() {
		String doneStatus = this.isDone ? "X" : " ";
		return prefix + "|" + doneStatus + "|" + this.description;
	}

	/**
	 * Prints a confirmation message indicating that the todo task has been successfully added.
	 */
	@Override
	public void printAdded() {
		System.out.println("____________________________________________________________");
		System.out.println(" sheeshh. new task. ok added:\n   " + taskString());
		String singularOrPlural = getTotalTasks() == 1 ? " task" : " tasks";
		System.out.println(" now you have " + getTotalTasks() + singularOrPlural + " in your list!");
		System.out.println("____________________________________________________________");
	}

}
