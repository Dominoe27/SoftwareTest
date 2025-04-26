package taskservice;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;


 // Tests for TaskService.
 
public class TaskServiceTest {
    private TaskService taskService;

    @BeforeEach
    public void setUp() {
        taskService = new TaskService();
    }

    @Test
    public void testAddTask_withValidInputs_returnsCreatedTask() {
        Task newTask = new Task("TEMPID", "TaskName", "TaskDescription");
        Task added = taskService.addTask(newTask);

        // Assert object is stored
        Task fetched = taskService.getTask(added.getTaskID());
        assertNotNull(fetched);
        assertEquals("TaskName", fetched.getName());
        assertEquals("TaskDescription", fetched.getDescription());
    }

    @Test
    public void testDeleteTask_withExistingTask_returnsNullOnGet() {
        Task newTask = new Task("TEMPID", "NameToDelete", "DescToDelete");
        Task added = taskService.addTask(newTask);

        taskService.deleteTask(added.getTaskID());

        assertNull(taskService.getTask(added.getTaskID()));
    }

    @Test
    public void testUpdateTask_withValidFields_updatesCorrectly() {
        Task added = taskService.addTask(new Task("TEMPID", "OldName", "OldDesc"));
        Task updated = new Task("IGNORED", "NewName", "NewDesc");

        taskService.updateTask(added.getTaskID(), updated);
        Task fetched = taskService.getTask(added.getTaskID());

        assertEquals("NewName", fetched.getName());
        assertEquals("NewDesc", fetched.getDescription());
    }

    @Test
    public void testDeleteTask_withInvalidID_throwsException() {
        assertThrows(NoSuchElementException.class, () -> taskService.deleteTask("fakeID"));
    }

    @Test
    public void testUpdateTask_withInvalidID_throwsException() {
        Task fakeUpdate = new Task("XXX", "Name", "Desc");
        assertThrows(NoSuchElementException.class, () -> taskService.updateTask("badID", fakeUpdate));
    }

    @Test
    public void testGetTask_withInvalidID_returnsNull() {
        assertNull(taskService.getTask("missingID"));
    }
}
