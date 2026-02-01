public class Task {
	protected String description;
	protected boolean isDone = false;
	protected String prefix = "";
	protected String suffix = "";

	public static int totalTasks = 0;

	// Constructors
	public Task(String taskDescription) {
		description = taskDescription;
		isDone = false;
		totalTasks++;
	}

	// Getters
	public String getStatusIcon() {
		return (isDone ? "X" : " ");
	}

	public String getDescription() {
		return description;
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

	// Printing Methods
	public void printTaskMarked() {
		System.out.println("\t____________________________________________________________");
		System.out.println("\t niceee, i have marked this task done:");
		System.out.println("\t [" + prefix +  "][" + this.getStatusIcon() + "] " + this.getDescription() + suffix);
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
	public void printAdded() {
		System.out.println("\t____________________________________________________________");
		System.out.println("\t added: " + this.description);
		System.out.println("\t____________________________________________________________");
	}

}
