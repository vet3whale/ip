package jeff.exceptions;

public class JeffException extends Exception {

	public enum ErrorType {
		INCOMPLETE_COMMAND,
		UNKNOWN_COMMAND,
		IDX_OUTOFBOUNDS
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
			System.out.println("____________________________________________________________");
			System.out.println(" " + command + "? " + command + " what? please complete your command!");
			System.out.println("____________________________________________________________");
			break;
		case UNKNOWN_COMMAND:
			System.out.println("____________________________________________________________");
			System.out.println(" \"random nonsense go\" fella. invalid command. try again...");
			System.out.println("____________________________________________________________");
			break;
		case IDX_OUTOFBOUNDS:
			System.out.println("____________________________________________________________");
			System.out.println(" delusional fella. task does not exist. try again...");
			System.out.println("____________________________________________________________");
			break;
		default:
			System.out.println("____________________________________________________________");
			System.out.println(" error! try again...");
			System.out.println("____________________________________________________________");
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