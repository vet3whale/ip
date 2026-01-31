public class Deadlines extends Task{
	protected String by;
	public Deadlines(String taskDescription) {
		super(taskDescription.substring(taskDescription.indexOf(" "),taskDescription.indexOf("/")-1));

		int byStartIndex = taskDescription.indexOf("/") + 4;
		int byEndIndex = taskDescription.length();
		by = taskDescription.substring(byStartIndex, byEndIndex);
	}
	@Override
	public String taskString() {
		return "[D]" + super.taskString() + " (by: " + this.by + ")";
	}

	@Override
	public void printAdded() {
		System.out.println("\t____________________________________________________________");
		System.out.println("\t shagg. need to get this done asap. ok added:\n\t   " + taskString());
		String singularOrPlural = getTotalTasks() == 1 ? " task" : " tasks";
		System.out.println("\t now you have " + getTotalTasks() + singularOrPlural + " in your list!");
		System.out.println("\t____________________________________________________________");
	}
}
