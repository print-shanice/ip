package kiki;

import task.Task;
import task.ToDo;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TaskListTest {

    @Test
    public void addTask_valid_taskAddedSuccessfully() {
        TaskList list = new TaskList(new ArrayList<>());
        Task todo = new ToDo("eat");
        list.addTask(todo);
        assertEquals(1, list.size());
        assertEquals(todo, list.getTask(0));
    }

    @Test
    public void deleteTask_invalidIndex_throwsException() {
        TaskList list = new TaskList(new ArrayList<>());
        assertThrows(IndexOutOfBoundsException.class, () -> {
            list.removeTask(0);
        });
    }
}
