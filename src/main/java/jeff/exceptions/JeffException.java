package jeff.exceptions;

/**
 * Represents a custom exception class for the Jeff chatbot.
 * Handles specific error types that occur during the execution of commands.
 */
public class JeffException extends Exception {
	
	/**
	 * Defines the types of errors that can occur in the application.
	 */
	public enum ErrorType {
		INCOMPLETE_COMMAND,
		UNKNOWN_COMMAND,
		IDX_OUTOFBOUNDS
	}

	private ErrorType type;
	private String command;

	/**
	 * Constructs a JeffException with the specified error type and command string.
	 * Automatically triggers the display of the appropriate error message to the user interface.
	 *
	 * @param type    The specific type of error that occurred.
	 * @param command The command string that caused the error.
	 */
	public JeffException(ErrorType type, String command) {
		this.type = type;
		this.command = command;
		showError(type, command);
	}

	/**
	 * Displays the appropriate error message to the user based on the error type.
	 *
	 * @param type    The specific type of error that occurred.
	 * @param command The command string associated with the error.
	 */
	private void showError(ErrorType type, String command) {
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

	/**
	 * Retrieves the type of error associated with this exception.
	 *
	 * @return The error type.
	 */
	public ErrorType getType() {
		return type;
	}

	/**
	 * Retrieves the command string that triggered this exception.
	 *
	 * @return The command string.
	 */
	public String getCommand() {
		return command;
	}
}