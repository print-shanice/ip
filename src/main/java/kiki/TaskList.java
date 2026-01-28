package kiki;

import task.Task;
import java.util.ArrayList;

/**
 * Represents a list of all tasks for processing via commands in the Kiki chatbot
 */

public class TaskList {
    private ArrayList<Task> tasks;

    public TaskList() {
        this.tasks = new ArrayList<>();
    }

    public TaskList(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }

    public void addTask(Task task) {
        this.tasks.add(task);
    }

    public void removeTask(int index) {
        this.tasks.remove(index);
    }

    public Task getTask(int index) {
        return this.tasks.get(index);
    }

    public ArrayList<Task> getTasks() {
        return this.tasks;
    }

    public int size() {
        return this.tasks.size();
    }

    public void listTasks(Ui ui) {
        ui.showLine();
        if (tasks.isEmpty()) {
            System.out.println(" no tasks added");
        } else {
            for (int i = 0; i < tasks.size(); i ++) {
                System.out.println(" " + (i + 1) + ". " + tasks.get(i));
            }
        }
        ui.showLine();
    }

    public ArrayList<Task> findTasks(String keyword) {
        ArrayList<Task> result = new ArrayList<>();
        for (Task t : tasks) {
            if (t.getName().toLowerCase().contains(keyword.toLowerCase())) {
                result.add(t);
            }
        }
        return result;
    }
}
