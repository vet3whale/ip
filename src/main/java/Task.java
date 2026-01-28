
public class Task {
	private static boolean isDone;
	private static String description;

	// Constructors
	public Task(String taskDescription, boolean done) {
		description = taskDescription;
		isDone = done;
	}

	// Getters
	public static String  getStatusIcon() {
		return (isDone ? "X" : " ");
	}

	public static String getDescription() {
		return description;
	}

	// Setters
	public static void markAsDone() {
		Task.isDone = true;
	}

	public static void unmarkDone() {
		Task.isDone = false;
	}

	public static void setDescription(String description) {
		Task.description = description;
	}
}
