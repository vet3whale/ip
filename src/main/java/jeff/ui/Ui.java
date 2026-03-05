package jeff.ui;

import jeff.assets.Task;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Handles all user interface interactions, including reading inputs and displaying outputs.
 */
public class Ui {
	private static Scanner in;

	/**
	 * Constructs a Ui object and initializes the scanner for reading standard input.
     */
	public Ui() {
		in = new Scanner(System.in);
	}

	/**
	 * Reads a command entered by the user.
	 *
	 * @return The full command string input by the user.
	 */
	public static String readCommand(){
		String response = in.nextLine();
		return response;
	}

	/**
	 * Displays a greeting message to the user when the application starts.
	 *
	 * @param chatbotName The name of the chatbot to display in the greeting.
	 */
	public static void helloGreeting(String chatbotName) {
		showLine();
		System.out.println("Hello, myname " + chatbotName);
		System.out.println("       __  _______  _______  _______");
		System.out.println("      |   ||      ||       ||       |");
		System.out.println("      |   ||    __||    ___||    ___|");
		System.out.println("      |   ||   |__ |   |___ |   |___");
		System.out.println("   ___|   ||    __||    ___||    ___|");
		System.out.println("  |       ||   |___|   |    |   |");
		System.out.println("  |_______||_______|___|    |___|");
		System.out.println("What can I do for you?");
		showLine();
	}

	/**
	 * Displays a horizontal separator line for visual clarity.
	 */
	public static void showLine() {
		System.out.println("____________________________________________________________");
	}

	/**
	 * Displays a goodbye message when the application terminates.
	 */
	public static void byeGreeting() {
		showLine();
		System.out.println("Bye. Hope to see you again soon!");
		showLine();
	}

	/**
	 * Prints all the tasks currently stored in the task list.
	 *
	 * @param tasks The list of tasks to print.
	 */
	public static void printList(ArrayList<Task> tasks){
		showLine();
		for (Task task : tasks) {
			System.out.println(" " + tasks.indexOf(task) + ". " + task.taskString());
		}
		if (tasks.isEmpty()) {
			System.out.println(" wow such empty. not bad.");
		}
		showLine();
	}

}
