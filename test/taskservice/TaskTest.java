package taskservice;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


 //Unit tests for the Task model class.
 
public class TaskTest {

    @Test
    public void testConstructor_withValidInputs_objectCreated() {
        Task task = new Task("1234567890", "Test Name", "Test Description");
        assertEquals("1234567890", task.getTaskID());
    }

    @Test
    public void testConstructor_withNullTaskID_throwsException() {
        assertThrows(IllegalArgumentException.class, () -> new Task(null, "Name", "Desc"));
    }

    @Test
    public void testConstructor_withLongTaskID_throwsException() {
        assertThrows(IllegalArgumentException.class, () -> new Task("12345678901", "Name", "Desc"));
    }

    @Test
    public void testConstructor_withNullName_throwsException() {
        assertThrows(IllegalArgumentException.class, () -> new Task("12345", null, "Desc"));
    }

    @Test
    public void testConstructor_withLongName_throwsException() {
        assertThrows(IllegalArgumentException.class, () -> new Task("12345", "This name is way too long for the limit", "Desc"));
    }

    @Test
    public void testConstructor_withNullDescription_throwsException() {
        assertThrows(IllegalArgumentException.class, () -> new Task("12345", "Name", null));
    }

    @Test
    public void testConstructor_withLongDescription_throwsException() {
        assertThrows(IllegalArgumentException.class, () -> new Task("12345", "Name", "This description is over fifty characters long which is not allowed by the spec."));
    }

    @Test
    public void testSetName_withValidInput_nameUpdated() {
        Task task = new Task("12345", "OldName", "Description");
        task.setName("NewName");
        assertEquals("NewName", task.getName());
    }

    @Test
    public void testSetDescription_withValidInput_descriptionUpdated() {
        Task task = new Task("12345", "Name", "OldDesc");
        task.setDescription("NewDesc");
        assertEquals("NewDesc", task.getDescription());
    }
}
