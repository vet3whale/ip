package jeff.assets;

public class Events extends Task{
	protected String from;
	protected String to;
	public String getSuffix() {
		return " (from: " + this.from + " to: " + this.to + ")";
	}
	public Events(String taskDescription) {
		super(taskDescription.substring(taskDescription.indexOf(" "),taskDescription.indexOf("/")-1));
		from = taskDescription.substring(taskDescription.indexOf("/from")+6, taskDescription.indexOf("/to")-1);
		to = taskDescription.substring(taskDescription.indexOf("/to")+4);
		super.prefix = "E";
		super.suffix = getSuffix();
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	@Override
	public String taskString() {
		return "[" + prefix + "]" + super.taskString() + getSuffix();
	}

	@Override
	public String loadingString() {
		String doneStatus = this.isDone ? "X" : " ";
		return prefix + "|" + doneStatus + "|" + this.description + "|" + this.from + "|" + this.to;
	}

	@Override
	public void printAdded() {
		System.out.println("\t____________________________________________________________");
		System.out.println("\t new event! ok added:\n\t   " + taskString());
		String singularOrPlural = getTotalTasks() == 1 ? " task" : " tasks";
		System.out.println("\t now you have " + getTotalTasks() + singularOrPlural + " in your list!");
		System.out.println("\t____________________________________________________________");
	}
}
