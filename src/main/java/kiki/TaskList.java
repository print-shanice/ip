package kiki;

import task.Task;
import java.util.ArrayList;

/**
 * Represents a list of all tasks for processing via commands in the Kiki chatbot
 */

public class TaskList {
    private ArrayList<Task> tasks;

    /**
     * Constructs an empty Tasklist
     */
    public TaskList() {
        this.tasks = new ArrayList<>();
    }

    /**
     * Constructs a Tasklist with the given tasks
     *
     * @param tasks A list of tasks
     * @return The tasklist containing tasks
     */
    public TaskList(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }

    public void addTask(Task task) {
        assert task != null: "Task to be added cannot be null";
        this.tasks.add(task);
    }

    /**
     * Removes the task from the Tasklist at the given index
     * @param index The index of the task to be removed
     */
    public void removeTask(int index) {
        this.tasks.remove(index);
    }

    /**
     * Returns the task from the Tasklist at the given index
     * @param index The index of the task to get
     * @return The task at the given index
     */
    public Task getTask(int index) {
        return this.tasks.get(index);
    }

    /**
     * Returns all tasks in the TaskList
     *
     * @return An Arraylist containing all tasks in the TaskList
     */
    public ArrayList<Task> getTasks() {
        return this.tasks;
    }

    /**
     * Returns the number of tasks in the TaskList
     * @return The size of the TaskList
     */
    public int size() {
        return this.tasks.size();
    }

    /**
     * Prints all tasks in the TaskList to the console
     * @param ui The UI used to display the messages
     */
    public void listTasks(Ui ui) {
        if (tasks.isEmpty()) {
            System.out.println(" no tasks added");
        } else {
            for (int i = 0; i < tasks.size(); i ++) {
                System.out.println(" " + (i + 1) + ". " + tasks.get(i));
            }
        }
    }

    /**
     * Finds all tasks that contains the given keyword
     * @param keyword The keyword to search for
     * @return A list of tasks that contain the keyword
     */
    public ArrayList<Task> findTasks(String keyword) {
        assert !keyword.isEmpty(): "Search keyword should not be empty";
        ArrayList<Task> result = new ArrayList<>();
        for (Task t : tasks) {
            if (t.getName().toLowerCase().contains(keyword.toLowerCase())) {
                result.add(t);
            }
        }
        return result;
    }
}
