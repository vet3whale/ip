package jeff;

import jeff.assets.Deadlines;
import jeff.assets.Events;
import jeff.assets.Task;
import jeff.assets.ToDos;
import jeff.exceptions.JeffException;

import java.util.ArrayList;

public class Parser {
	private static final String[] commandStrings = {
			"todo", "deadline", "event", "mark", "unmark", "list", "delete", "bye"
	};
	enum CommandType {
		TODO, DEADLINE, EVENT, MARK, UNMARK, LIST, DELETE, BYE
	}

	private static Ui ui;

	public Parser() {
		ui = new Ui();
	}

	// this parses commands that user inputs
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

	public static String verifyDeadline(String response) {
		if (!response.contains("/by")) {
			response += " /by tbd";
		} else if (response.indexOf("/by")+2 == response.length()-1){
			response += " tbd";
		}
		return response;
	}

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
	public static boolean readResponse(String response, ArrayList<Task> tasks) {
		boolean isExit = false;
		try {
			String[] words = response.split(" ");
			String command = words[0];
			CommandType cmdType = parseCommand(command);
			int idx;

			switch (cmdType) {
			case TODO:
				if (words.length < 2) {
					throw new JeffException(JeffException.ErrorType.INCOMPLETE_COMMAND, "todo");
				}
				tasks.add(new ToDos(response));
				tasks.get(tasks.size()-1).printAdded();
				break;
			case DEADLINE:
				if (words.length < 2) {
					throw new JeffException(JeffException.ErrorType.INCOMPLETE_COMMAND, "deadline");
				}
				response = verifyDeadline(response);
				tasks.add(new Deadlines(response));
				tasks.get(tasks.size()-1).printAdded();
				break;
			case EVENT:
				if (words.length < 2) {
					throw new JeffException(JeffException.ErrorType.INCOMPLETE_COMMAND, "event");
				}
				response = verifyEvent(response);
				tasks.add(new Events(response));
				tasks.get(tasks.size()-1).printAdded();
				break;
			case DELETE:
				if (words.length < 2) {
					throw new JeffException(JeffException.ErrorType.INCOMPLETE_COMMAND, "delete");
				}
				idx = Integer.parseInt(words[1]);
				if (idx >= tasks.size()) {
					throw new JeffException(JeffException.ErrorType.IDX_OUTOFBOUNDS, "");
				} else {
					Task taskToDelete = tasks.get(idx);
					tasks.remove(taskToDelete);
					ui.printDeletedStatus(taskToDelete, tasks);
				}
				break;
			case MARK:
			case UNMARK:
				if (words.length > 1 && isDigit(words[1])) {
					idx = Integer.parseInt(words[1]);
					if (idx >= tasks.size()) {
						throw new JeffException(JeffException.ErrorType.IDX_OUTOFBOUNDS, "");
					} else {
						tasks.get(idx).setCompletionStatus(command);
					}
				} else {
					throw new JeffException(JeffException.ErrorType.IDX_OUTOFBOUNDS, "");
				}
				break;
			case LIST:
				ui.printList(tasks);
				break;
			case BYE:
				isExit = true;
			}
		} catch (JeffException e) {
		}
		return isExit;
	}
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
