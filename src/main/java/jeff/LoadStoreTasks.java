package jeff;

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

public class LoadStoreTasks{
	protected static final String filePath = "data/tasks.txt";
	// Load & Store Tasks to File
	public static void loadTasks(ArrayList<Task> tasks) {
		File file = new File(filePath);
		if (!file.getParentFile().exists()) {
			file.getParentFile().mkdirs();
		}
		try (Scanner s = new Scanner(file)) {
			while (s.hasNextLine()) {
				String taskString = s.nextLine();
				addTask(taskString, tasks);
			}
		} catch (FileNotFoundException e) {
			System.out.println("\t no saved tasks file—starting fresh.");
		}
	}

	public static void storeTasks(ArrayList<Task> tasks) {
		File file = new File(filePath);
		if (!file.getParentFile().exists()) {
			file.getParentFile().mkdirs();
		}
		try (FileWriter fw = new FileWriter(file)) {
			for (Task task : tasks) {
				fw.write(task.loadingString() + "\n");
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public static void addTask(String taskString, ArrayList<Task> tasks) {
		int taskTypeIdx = 0;
		int doneIdx = taskString.indexOf("|") + 1;
		int descStart = taskString.indexOf("|", doneIdx)+1;
		int descEnd = taskString.indexOf("|", descStart);
		descEnd = descEnd == -1 ? taskString.length(): descEnd;

		char taskType = taskString.charAt(taskTypeIdx);
		String desc = taskString.substring(descStart, descEnd);
		boolean isDone = taskString.charAt(doneIdx) == 'X';

		Task task;
		switch (taskType) {
		case 'T':
			task = new ToDos(desc);
			break;
		case 'D':
			int byStart = taskString.indexOf("|", descEnd) + 1;
			String by = taskString.substring(byStart).trim();
			task = new Deadlines(desc + " /by " + by);
			break;
		case 'E':
			int fromStart = taskString.indexOf("|", descEnd) + 1;
			int toStart = taskString.lastIndexOf("|", taskString.length() - 1);
			String from = taskString.substring(fromStart, toStart).trim();
			String to = taskString.substring(toStart + 1).trim();
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
