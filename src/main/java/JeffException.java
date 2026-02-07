public class JeffException extends Exception {

	public enum ErrorType {
		INCOMPLETE_COMMAND,
		UNKNOWN_COMMAND
	}

	private ErrorType type;
	private String command;

	public JeffException(ErrorType type, String command) {
		this.type = type;
		this.command = command;
		buildMessage(type, command);
	}

	private void buildMessage(ErrorType type, String command) {
		switch (type) {
		case INCOMPLETE_COMMAND:
			System.out.println("\t____________________________________________________________");
			System.out.println("\t " + command + "? " + command + " what? please complete your command!");
			System.out.println("\t____________________________________________________________");
			break;
		case UNKNOWN_COMMAND:
			System.out.println("\t____________________________________________________________");
			System.out.println("\t \"random nonsense go\" fella. invalid command. try again...");
			System.out.println("\t____________________________________________________________");
			break;
		default:
			System.out.println("\t____________________________________________________________");
			System.out.println("\t error! try again...");
			System.out.println("\t____________________________________________________________");
			break;
		}
	}

	public ErrorType getType() {
		return type;
	}

	public String getCommand() {
		return command;
	}
}