package jeff.assets;

public class Deadlines extends Task{
	protected String by;
	public String getSuffix() {
		return " (by: " + this.by + ")";
	}
	public Deadlines(String taskDescription) {
		super(taskDescription.substring(taskDescription.indexOf(" "),taskDescription.indexOf("/")-1));

		int byStartIndex = taskDescription.indexOf("/") + 4;
		int byEndIndex = taskDescription.length();
		by = taskDescription.substring(byStartIndex, byEndIndex);
		super.prefix = "D";
		super.suffix = getSuffix();
	}

	public String getBy() {
		return by;
	}

	public void setBy(String by) {
		this.by = by;
	}

	@Override
	public String taskString() {
		return "[D]" + super.taskString() + getSuffix();
	}

	@Override
	public String loadingString() {
		String doneStatus = this.isDone ? "X" : " ";
		return prefix + "|" + doneStatus + "|" + this.description + "|" +  this.by;
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
