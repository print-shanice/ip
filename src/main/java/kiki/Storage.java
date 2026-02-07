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
 * Represents storage for loading and saving data for Kiki chatbot
 */

public class Storage {
    private static final String DATA_DIRECTORY = "data";
    private static final String DATA_FILE = "data/kiki.txt";

    public static ArrayList<Task> load() {
        ArrayList<Task> tasks = new ArrayList<>();

        try {
            Path path = Paths.get(DATA_FILE);

            if (!Files.exists(path)) {
                Files.createDirectories(Paths.get(DATA_DIRECTORY));
                Files.createFile(path);
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

    private static Task parseTask(String line) {
        String[] parts = line.split(" \\| ");
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

    public static void save(ArrayList<Task> tasks) {
        try {
            BufferedWriter writer = Files.newBufferedWriter(Paths.get(DATA_FILE));

            for (Task task : tasks) {
                writer.write(task.toFileString());
                writer.newLine();
            }
            writer.close();
        } catch (IOException e)  {
            System.out.println(" failed to save tasks");
        }
    }
}
