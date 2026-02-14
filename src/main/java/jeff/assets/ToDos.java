package jeff.assets;

public class ToDos extends Task {
	public ToDos(String taskDescription) {
		super(taskDescription.substring(taskDescription.indexOf(' ')));
		super.prefix = "T";
	}

	@Override
	public String taskString() {
		return "[T]" + super.taskString();
	}

	@Override
	public String loadingString() {
		String doneStatus = this.isDone ? "X" : " ";
		return prefix + "|" + doneStatus + "|" + this.description;
	}

	@Override
	public void printAdded() {
		System.out.println("\t____________________________________________________________");
		System.out.println("\t sheeshh. new task. ok added:\n\t   " + taskString());
		String singularOrPlural = getTotalTasks() == 1 ? " task" : " tasks";
		System.out.println("\t now you have " + getTotalTasks() + singularOrPlural + " in your list!");
		System.out.println("\t____________________________________________________________");
	}

}
