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

	// Setters
	public void setCompletionStatus(String command) {
		command = command.toLowerCase();
		if (command.equals("mark")) {
			this.isDone = true;
			System.out.println("\t____________________________________________________________");
			System.out.println("\t niceee, i have marked this task done:");
			System.out.println("\t  [" + this.getStatusIcon() + "] " + this.getDescription());
			System.out.println("\t____________________________________________________________");
		} else if (command.equals("unmark")) {
			this.isDone = false;
			System.out.println("\t____________________________________________________________");
			System.out.println("\t ok, i have marked this task as not done yet:");
			System.out.println("\t  [" + this.getStatusIcon() + "] " + this.getDescription());
			System.out.println("\t____________________________________________________________");
		} else {
			System.out.println("\t____________________________________________________________");
			System.out.println("\t fat fingers fella. command does not exist. try again...");
			System.out.println("\t____________________________________________________________");
		}
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
