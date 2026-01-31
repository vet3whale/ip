public class ToDos extends Task {
	public ToDos(String taskDescription, boolean done) {
		super(taskDescription,done);
	}
	@Override
	public String taskString() {
		return "[T]" + super.taskString();
	}

	@Override
	public void printAdded(String taskDescription) {
		System.out.println("\t____________________________________________________________");
		System.out.println("\t sheeshh. new task. ok added:\n\t   " + taskString());
		String singularOrPlural = super.getTotalTasks() == 1 ? " task" : " tasks";
		System.out.println("\t now you have " + super.getTotalTasks() + singularOrPlural + " in your list!");
		System.out.println("\t____________________________________________________________");
	}
}
