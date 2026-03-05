package jeff.parser;

import jeff.command.*;
import jeff.ui.Ui;
import jeff.assets.Deadlines;
import jeff.assets.Events;
import jeff.assets.Task;
import jeff.assets.ToDos;
import jeff.exceptions.JeffException;

import java.util.ArrayList;

/**
 * Parses user input into executable commands.
 */
public class Parser {
	private static final String[] commandStrings = {
			"todo", "deadline", "event", "mark", "unmark", "list", "delete", "bye", "find"
	};
	enum CommandType {
		TODO, DEADLINE, EVENT, MARK, UNMARK, LIST, DELETE, BYE, FIND
	}

	private static Ui ui;

	/**
	 * Constructs a Parser and initializes the user interface.
	 */
	public Parser() {
		ui = new Ui();
	}

	/**
	 * Parses the initial command word from the user input to determine the command type.
	 * @param input The raw input string from the user.
	 * @return The CommandType corresponding to the input.
	 * @throws JeffException If the command is empty or unrecognized.
	 */
	private static CommandType parseCommand(String input) throws JeffException {
		if (input == null || input.isBlank()) {
			throw new JeffException(JeffException.ErrorType.INCOMPLETE_COMMAND, "command");
		}

		String[] words = input.trim().split(" ");
		String cmd = words[0].toLowerCase();
		int count = 0;
		for (String commandString : commandStrings) {
			if (commandString.equals(cmd)) {
				return CommandType.values()[count];
			}
			count++;
		}
		throw new JeffException(JeffException.ErrorType.UNKNOWN_COMMAND, cmd);
	}

	/**
	 * Verifies and formats the deadline command input to ensure it contains a valid /by clause.
	 *
	 * @param response The user's input string for a deadline.
	 * @return The formatted deadline string.
	 */
	public static String verifyDeadline(String response) {
		if (!response.contains("/by")) {
			response += " /by tbd";
		} else if (response.indexOf("/by")+2 == response.length()-1){
			response += " tbd";
		}
		return response;
	}

	/**
	 * Verifies and formats the event command input to ensure it contains valid /from and /to clauses.
	 *
	 * @param response The user's input string for an event.
	 * @return The formatted event string.
	 */
	public static String verifyEvent(String response) {
		if (!response.contains("/from") && !response.contains("/to")){
			response += " /from tbd /to tbd";
		} else if (!response.contains("/to")) {
			response += " /to tbd";
		} else if (!response.contains("/from")) {
			String[] words = response.split("/to");
			response = words[0] + "/from tbd /to" + words[1];
		} else if (response.indexOf("/to")+2 == response.length()-1){
			response += " tbd";
		}
		return response;
	}

	/**
	 * Reads the full user input and translates it into the corresponding Command object.
	 *
	 * @param response The full command string entered by the user.
	 * @param tasks    The current list of tasks.
	 * @return The Command corresponding to the user's input.
	 * @throws JeffException If the command has incorrect formatting or incomplete arguments.
	 */
	public static Command readResponse(String response, ArrayList<Task> tasks) throws JeffException {
		String[] words = response.split(" ");
		String command = words[0];
		CommandType cmdType = parseCommand(command);
		int idx;

		switch (cmdType) {
		case TODO:
			if (words.length < 2) {
				throw new JeffException(JeffException.ErrorType.INCOMPLETE_COMMAND, "todo");
			}
			return new AddCommand(new ToDos(response));
		case DEADLINE:
			if (words.length < 2) {
				throw new JeffException(JeffException.ErrorType.INCOMPLETE_COMMAND, "deadline");
			}
			return new AddCommand(new Deadlines(verifyDeadline(response)));
		case EVENT:
			if (words.length < 2) {
				throw new JeffException(JeffException.ErrorType.INCOMPLETE_COMMAND, "event");
			}
			return new AddCommand(new Events(verifyEvent(response)));
		case DELETE:
			if (words.length < 2) {
				throw new JeffException(JeffException.ErrorType.INCOMPLETE_COMMAND, "delete");
			}
			return new DeleteCommand(Integer.parseInt(words[1]));
		case FIND:
			if (words.length < 2) {
				throw new JeffException(JeffException.ErrorType.INCOMPLETE_COMMAND, "find");
			}
			int firstSpace = response.indexOf(" ");
			return new FindCommand(response.substring(firstSpace+1).trim());
		case MARK:
		case UNMARK:
			if (words.length < 2 || !isDigit(words[1])) {
				throw new JeffException(JeffException.ErrorType.INCOMPLETE_COMMAND, command);
			}
			return new MarkUnmarkCommand(Integer.parseInt(words[1]), command.equals("mark"));
		case LIST:
			return new ListCommand();
		case BYE:
			return new ByeCommand();
		default:
			throw new JeffException(JeffException.ErrorType.UNKNOWN_COMMAND, command);
		}
	}

	/**
	 * Checks if a given string represents a valid integer.
	 *
	 * @param word The string to check.
	 * @return True if the string is a valid integer, false otherwise.
	 */
	public static boolean isDigit(String word) {
		if (word == null) {
			return false;
		}
		try {
			Integer.parseInt(word);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}
}
