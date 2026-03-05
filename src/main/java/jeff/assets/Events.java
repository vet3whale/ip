package jeff.assets;

/**
 * Represents an event task that occurs within a specific time frame.
 * It contains a start time and an end time.
 */
public class Events extends Task{
	protected String from;
	protected String to;
	/**
	 * Returns the formatted suffix containing the start and end times of the event.
	 *
	 * @return A string representing the event time suffix.
	 */
	public String getSuffix() {
		return " (from: " + this.from + " to: " + this.to + ")";
	}

	/**
	 * Constructs an Events task from the specified description.
	 * The description must contain the task details followed by "/from" and "/to" delimiters.
	 *
	 * @param taskDescription The full description of the event task, including times.
	 */
	public Events(String taskDescription) {
		super(taskDescription.substring(taskDescription.indexOf(" "),taskDescription.indexOf("/")-1));
		from = taskDescription.substring(taskDescription.indexOf("/from")+6, taskDescription.indexOf("/to")-1);
		to = taskDescription.substring(taskDescription.indexOf("/to")+4);
		super.prefix = "E";
		super.suffix = getSuffix();
	}

	/**
	 * Retrieves the start time of the event.
	 *
	 * @return The start time.
	 */
	public String getFrom() {
		return from;
	}

	/**
	 * Sets a new start time for the event.
	 *
	 * @param from The new start time to set.
	 */
	public void setFrom(String from) {
		this.from = from;
	}

	/**
	 * Retrieves the end time of the event.
	 *
	 * @return The end time.
	 */
	public String getTo() {
		return to;
	}

	/**
	 * Sets a new end time for the event.
	 *
	 * @param to The new end time to set.
	 */
	public void setTo(String to) {
		this.to = to;
	}

	/**
	 * Returns the string representation of the event task for display purposes.
	 *
	 * @return The formatted string representation of the task.
	 */
	@Override
	public String taskString() {
		return "[" + prefix + "]" + super.taskString() + getSuffix();
	}

	/**
	 * Returns the string representation of the event task formatted for saving to a file.
	 *
	 * @return The formatted string for file storage.
	 */
	@Override
	public String loadingString() {
		String doneStatus = this.isDone ? "X" : " ";
		return prefix + "|" + doneStatus + "|" + this.description + "|" + this.from + "|" + this.to;
	}

	/**
	 * Prints a confirmation message indicating that the event task has been successfully added.
	 */
	@Override
	public void printAdded() {
		System.out.println("____________________________________________________________");
		System.out.println(" new event! ok added:\n   " + taskString());
		String singularOrPlural = getTotalTasks() == 1 ? " task" : " tasks";
		System.out.println(" now you have " + getTotalTasks() + singularOrPlural + " in your list!");
		System.out.println("____________________________________________________________");
	}
}
