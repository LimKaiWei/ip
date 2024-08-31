package utility;

import org.junit.jupiter.api.Test;

import utility.TaskList;
import task.Task;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TaskListTest {

    @Test
    public void indexingTest() {
        TaskList taskList = new TaskList();
        assertEquals(0, taskList.size());
        assertFalse(taskList.isValidIndex(0));
        taskList = taskList.addTask(new Task("test"));
        assertFalse(taskList.isValidIndex(1));
        assertTrue(taskList.isValidIndex(0));
    }
}
