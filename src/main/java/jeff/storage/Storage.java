package jeff.storage;

import jeff.assets.Deadlines;
import jeff.assets.Events;
import jeff.assets.Task;
import jeff.assets.ToDos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Handles the loading and storing of tasks to a persistent text file.
 */
public class Storage {
	protected static String filePath;

	/**
	 * Constructs a Storage object with the specified file path.
	 *
	 * @param filePath The path of the file used for saving tasks.
	 */
	public Storage(String filePath) {
		this.setFilePath(filePath);
	}

	/**
	 * Sets the file path for storage.
	 *
	 * @param filePath The new file path to set.
	 */
	public static void setFilePath(String filePath) {
		Storage.filePath = filePath;
	}

	/**
	 * Loads tasks from the storage file into the provided task list.
	 * Creates the necessary directories and file if they do not exist.
	 *
	 * @param tasks The list where loaded tasks will be stored.
	 */
	public static void loadTasks(ArrayList<Task> tasks) {
		File file = new File(filePath);
		if (!file.getParentFile().exists()) {
			file.getParentFile().mkdirs(); // doesnt exist, so create folder
		}

		try (Scanner s = new Scanner(file)) {
			while (s.hasNextLine()) {
				String taskString = s.nextLine();
				addTask(taskString, tasks);
			}
		} catch (FileNotFoundException e) {
			System.out.println(" no saved tasks file—starting fresh.");
		}
	}

	/**
	 * Saves the current list of tasks to the storage file.
	 *
	 * @param tasks The list of tasks to be saved.
	 * @throws RuntimeException If an error occurs while writing to the file.
	 */
	public static void storeTasks(ArrayList<Task> tasks) {
		File file = new File(filePath);
		if (!file.getParentFile().exists()) {
			file.getParentFile().mkdirs(); // doesnt exist, so create folder
		}
		try (FileWriter fw = new FileWriter(file)) {
			for (Task task : tasks) {
				fw.write(task.loadingString() + "\n");
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * Parses a string representation of a task from the storage file and adds it to the task list.
	 *
	 * @param taskString The formatted string representing a task.
	 * @param tasks      The list where the task will be added.
	 */
	public static void addTask(String taskString, ArrayList<Task> tasks) {
		// parts[0] = taskType char, parts[1] = done flag, parts[2] = desc,
		// parts[3] = by (Deadline) OR from (Event), parts[4] = to (Event)
		// Example: E| | go for run|5pm|6pm
		String[] parts = taskString.split("\\|", -1);

		char taskType = parts[0].trim().charAt(0);
		boolean isDone = parts[1].trim().equals("X");
		String desc = parts[2];

		Task task;
		switch (taskType) {
		case 'T':
			task = new ToDos(desc);
			break;
		case 'D':
			String by = parts[3];
			task = new Deadlines(desc + " /by " + by);
			break;
		case 'E':
			String from = parts[3];
			String to = parts[4];
			task = new Events(desc + " /from " + from + " /to " + to);
			break;
		default:
			task = new Task(desc);
		}

		if (isDone) {
			task.setDone();
		}
		tasks.add(task);
	}

}
