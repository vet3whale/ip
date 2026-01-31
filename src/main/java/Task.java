public class Task {
	protected String description;
	protected boolean isDone = false;

	public static int totalTasks = 0;

	// Constructors
	public Task(String taskDescription, boolean done) {
		description = taskDescription;
		isDone = done;
		totalTasks++;
		printAdded(taskDescription);
	}

	// Getters
	public String getStatusIcon() {
		return (isDone ? "X" : " ");
	}

	public String getDescription() {
		return description;
	}

	public void printTaskMarked() {
		System.out.println("\t____________________________________________________________");
		System.out.println("\t niceee, i have marked this task done:");
		System.out.println("\t  [" + this.getStatusIcon() + "] " + this.getDescription());
		System.out.println("\t____________________________________________________________");
	}
	public void printTaskUnmarked() {
		System.out.println("\t____________________________________________________________");
		System.out.println("\t ok, i have marked this task as not done yet:");
		System.out.println("\t  [" + this.getStatusIcon() + "] " + this.getDescription());
		System.out.println("\t____________________________________________________________");
	}
	public void printWrongCommand() {
		System.out.println("\t____________________________________________________________");
		System.out.println("\t fat fingers fella. command does not exist. try again...");
		System.out.println("\t____________________________________________________________");
	}
	public void printAdded(String taskDescription) {
		System.out.println("\t____________________________________________________________");
		System.out.println("\t added: " + taskDescription);
		System.out.println("\t____________________________________________________________");
	}

	public static int getTotalTasks() {
		return totalTasks;
	}

	// Setters
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
	public String taskString() {
		return "[" + this.getStatusIcon() + "] " + this.getDescription();
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
