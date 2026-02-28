package jeff.ui;

import jeff.assets.Task;

import java.util.ArrayList;
import java.util.Scanner;

public class Ui {
	private static Scanner in;
	public Ui() {
		in = new Scanner(System.in);
	}
	public static String readCommand(){
		String response = in.nextLine();
		return response;
	}

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

	public static void showLine() {
		System.out.println("____________________________________________________________");
	}

	public static void byeGreeting() {
		showLine();
		System.out.println("Bye. Hope to see you again soon!");
		showLine();
	}
	public static void printDeletedStatus(Task task, ArrayList<Task> tasks) {
		showLine();
		System.out.println(" noted, following task has been deleted:");
		System.out.println("  " + task.taskString());
		System.out.println(" now you have " + tasks.size() + " tasks in the list.");
		showLine();
	}

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
