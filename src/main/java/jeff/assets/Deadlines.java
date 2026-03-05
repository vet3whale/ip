package jeff.assets;

/**
 * Represents a task with a deadline.
 * A deadline task contains a description and a specific time by which it must be completed.
 */
public class Deadlines extends Task{
	protected String by;
	/**
	 * Returns the formatted suffix containing the deadline time.
	 *
	 * @return A string representing the deadline suffix.
	 */
	public String getSuffix() {
		return " (by: " + this.by + ")";
	}

	/**
	 * Constructs a Deadlines task from the specified description.
	 * The description must contain the task details followed by a "/by" delimiter and the deadline time.
	 *
	 * @param taskDescription The full description of the deadline task.
	 */
	public Deadlines(String taskDescription) {
		super(taskDescription.substring(taskDescription.indexOf(" "),taskDescription.indexOf("/")-1));

		int byStartIndex = taskDescription.indexOf("/") + 4;
		int byEndIndex = taskDescription.length();
		by = taskDescription.substring(byStartIndex, byEndIndex);
		super.prefix = "D";
		super.suffix = getSuffix();
	}

	/**
	 * Retrieves the deadline time string.
	 *
	 * @return The time the task is due.
	 */
	public String getBy() {
		return by;
	}

	/**
	 * Sets a new deadline time for the task.
	 *
	 * @param by The new deadline time to set.
	 */
	public void setBy(String by) {
		this.by = by;
	}

	/**
	 * Returns the string representation of the deadline task for display purposes.
	 *
	 * @return The formatted string representation of the task.
	 */
	@Override
	public String taskString() {
		return "[D]" + super.taskString() + getSuffix();
	}

	/**
	 * Returns the string representation of the deadline task formatted for saving to a file.
	 *
	 * @return The formatted string for file storage.
	 */
	@Override
	public String loadingString() {
		String doneStatus = this.isDone ? "X" : " ";
		return prefix + "|" + doneStatus + "|" + this.description + "|" +  this.by;
	}

	/**
	 * Prints a confirmation message indicating that the deadline task has been successfully added.
	 */
	@Override
	public void printAdded() {
		System.out.println("____________________________________________________________");
		System.out.println(" shagg. need to get this done asap. ok added:\n   " + taskString());
		String singularOrPlural = getTotalTasks() == 1 ? " task" : " tasks";
		System.out.println(" now you have " + getTotalTasks() + singularOrPlural + " in your list!");
		System.out.println("____________________________________________________________");
	}
}
