package jeff.assets;

import jeff.ui.Ui;

import java.util.ArrayList;

/**
 * Represents a generic task with a description and completion status.
 * This is the base class for more specific task types like ToDos, Deadlines, and Events.
 */
public class Task {
	private static Ui ui;
	protected String description;
	protected boolean isDone = false;
	protected String prefix = "";
	protected String suffix = "";

	public static int totalTasks = 0;

	/**
	 * Constructs a generic Task with the given description.
	 *
	 * @param taskDescription The description of the task.
	 */
	public Task(String taskDescription) {
		description = taskDescription;
		isDone = false;
		totalTasks++;
	}

	/**
	 * Returns the status icon indicating whether the task is done.
	 *
	 * @return "X" if the task is done, otherwise a blank space " ".
	 */
	public String getStatusIcon() {
		return (isDone ? "X" : " ");
	}

	/**
	 * Retrieves the description of the task.
	 *
	 * @return The task description.
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Retrieves the total number of tasks created so far.
	 *
	 * @return The total task count.
	 */
	public static int getTotalTasks() {
		return totalTasks;
	}

	/**
	 * Sets the completion status of the task based on the user command.
	 *
	 * @param command The string command, either "mark" or "unmark".
	 */
	public void setCompletionStatus(String command) {
		command = command.toLowerCase();
		if (command.equals("mark")) {
			this.isDone = true;
			printTaskMarked();
		} else if (command.equals("unmark")) {
			this.isDone = false;
			printTaskUnmarked();
		} else {
			printWrongCommand();
		}
	}
	/**
	 * Marks the task as completed without printing a message (useful for loading tasks).
	 */
	public void setDone() {
		this.isDone = true;
	}
	/**
	 * Returns the basic string representation of the task for display.
	 *
	 * @return The formatted string representation.
	 */
	public String taskString() {
		return "[" + this.getStatusIcon() + "]" + this.getDescription();
	}
	/**
	 * Returns the basic string representation of the task formatted for file storage.
	 *
	 * @return The formatted string for file storage.
	 */
	public String loadingString() {
		return "|" + this.getStatusIcon() + "|" + this.getDescription();
	}
	/**
	 * Updates the description of the task.
	 *
	 * @param description The new description to set.
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Prints a message confirming the task has been marked as done.
	 */
	public void printTaskMarked() {
		System.out.println("____________________________________________________________");
		System.out.println(" niceee, i have marked this task done:");
		System.out.println(" [" + prefix +  "][" + this.getStatusIcon() + "]" + this.getDescription() + suffix);
		System.out.println("____________________________________________________________");
	}
	/**
	 * Prints a message confirming the task has been marked as not done yet.
	 */
	public void printTaskUnmarked() {
		System.out.println("____________________________________________________________");
		System.out.println(" ok, i have marked this task as not done yet:");
		System.out.println(" [" + prefix +  "][" + this.getStatusIcon() + "]" + this.getDescription() + suffix);
		System.out.println("____________________________________________________________");
	}
	/**
	 * Prints an error message when an unrecognized command is given for marking tasks.
	 */
	public void printWrongCommand() {
		System.out.println("____________________________________________________________");
		System.out.println(" fat fingers fella. command does not exist. try again...");
		System.out.println("____________________________________________________________");
	}
	/**
	 * Prints a simple message confirming a task was added.
	 */
	public void printAdded() {
		System.out.println("____________________________________________________________");
		System.out.println(" added: " + this.description);
		System.out.println("____________________________________________________________");
	}
	/**
	 * Prints a confirmation message indicating the task has been deleted.
	 *
	 * @param tasks The current list of tasks to get the remaining size.
	 */
	public void printDeleted(ArrayList<Task> tasks) {
		ui.showLine();
		System.out.println(" noted, following task has been deleted:");
		System.out.println("  " + this.taskString());
		System.out.println(" now you have " + tasks.size() + " tasks in the list.");
		ui.showLine();
	}
}
