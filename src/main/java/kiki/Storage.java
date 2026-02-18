package kiki;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import task.Task;
import task.ToDo;
import task.Deadline;
import task.Event;

/**
 * Handles loading and saving of task data for the Kiki chatbot.
 * Tasks are persisted to a plain-text file using a pipe-delimited format.
 */
public class Storage {
    /** The directory in which the data file is stored. */
    private static final String DATA_DIRECTORY = "data";

    /** The path to the data file. */
    private static final String DATA_FILE = "data/kiki.txt";

    /**
     * Loads tasks from the data file and returns them as an ArrayList.
     * If the data file does not exist, it is created along with its parent directory.
     * Lines that cannot be parsed are silently skipped.
     *
     * @return An ArrayList of tasks loaded from the data file, or an empty list if none exist.
     */
    public static ArrayList<Task> load() {
        ArrayList<Task> tasks = new ArrayList<>();

        try {
            Path path = Paths.get(DATA_FILE);

            if (!Files.exists(path)) {
                Files.createDirectories(Paths.get(DATA_DIRECTORY));
                Files.createFile(path);
                assert Files.exists(path) : "Data file should be created";
                return tasks;
            }

            BufferedReader reader = Files.newBufferedReader(path);
            String line;

            while ((line = reader.readLine()) != null) {
                try {
                    Task task = parseTask(line);
                    tasks.add(task);
                } catch (Exception e) {
                    continue;
                }
            }
            reader.close();
        } catch (IOException e) {
            System.out.println(" failed to load saved tasks");
        }
        return tasks;
    }

    /**
     * Parses a single line from the data file and returns the corresponding Task.
     *
     * @param line A pipe-delimited string representing a saved task.
     * @return The Task decoded from the given line.
     * @throws IllegalArgumentException If the line does not correspond to a valid task type.
     */
    private static Task parseTask(String line) {
        String[] parts = line.split(" \\| ");
        assert parts.length >= 3 : "Saved task in data file must have at least 3 parts";
        String type = parts[0];
        boolean isDone = parts[1].equals("1");
        Task task;

        switch (type) {
        case "T":
            task = new ToDo(parts[2]);
            break;
        case "D":
            task = new Deadline(parts[2], parts[3]);
            break;
        case "E":
            task = new Event(parts[2], parts[3], parts[4]);
            break;
        default:
            throw new IllegalArgumentException("invalid task type");
        }

        if (isDone) {
            task.markDone();
        }
        return task;
    }

    /**
     * Saves the current list of tasks to the data file, overwriting any existing content.
     * Each task is written on its own line using its {@link Task#toFileString()} representation.
     *
     * @param tasks An ArrayList of tasks to be saved. No task in the list may be {@code null}.
     */
    public static void save(ArrayList<Task> tasks) {
        try {
            BufferedWriter writer = Files.newBufferedWriter(Paths.get(DATA_FILE));

            for (Task task : tasks) {
                assert task != null : "Task to be saved should not be null";
                writer.write(task.toFileString());
                writer.newLine();
            }
            writer.close();
        } catch (IOException e) {
            System.out.println(" failed to save tasks");
        }
    }
}
