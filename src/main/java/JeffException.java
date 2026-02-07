public class JeffException extends Exception {

	public enum ErrorType {
		INCOMPLETE_COMMAND,
		UNKNOWN_COMMAND
	}

	private ErrorType type;
	private String command = "";

	String incompleteCommandMessage =
			("\t____________________________________________________________")
					+ "\t" + this.command + "?" + this.command + " what? please complete your command"
					+  ("\t____________________________________________________________");
	String unknownCommandMessage =
			("\t____________________________________________________________")
					+  ("\t \"random nonsense go\" fella. invalid command. try again...")
					+  ("\t____________________________________________________________");
	
	String defaultErrorMessage =
			("\t____________________________________________________________")
					+  ("\t error! try again...")
					+  ("\t____________________________________________________________");
	
	public JeffException(ErrorType type, String command) {
		this.type = type;
		this.command = command;
		buildMessage(type, command);
	}

	private void buildMessage(ErrorType type, String command) {
		switch (type) {
			case INCOMPLETE_COMMAND:
				System.out.println(incompleteCommandMessage);
			case UNKNOWN_COMMAND:
				System.out.println(unknownCommandMessage);
			default:
				System.out.println(defaultErrorMessage);
		};
	}

	public ErrorType getType() {
		return type;
	}

	public String getCommand() {
		return command;
	}
}

