public class Task {
	protected String description;
	protected boolean isDone = false;

	// Constructors
	public Task(String taskDescription, boolean done) {
		description = taskDescription;
		isDone = done;
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
