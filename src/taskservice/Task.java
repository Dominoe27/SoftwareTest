package taskservice;


 //Represents a task with a unique ID, name, and description.
 //Validates all fields on assignment.
 
public class Task {
    private final String taskID;
    private String name;
    private String description;

    // Constants for validation constraints
    private static final int MAX_ID_LENGTH = 10;
    private static final int MAX_NAME_LENGTH = 20;
    private static final int MAX_DESC_LENGTH = 50;

    
     //Constructor uses setters to enforce validation.
     
    public Task(String taskID, String name, String description) {
        if (taskID == null || taskID.length() > MAX_ID_LENGTH)
            throw new IllegalArgumentException("Invalid task ID");
        this.taskID = taskID;
        setName(name);
        setDescription(description);
    }

    public String getTaskID() {
        return taskID;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    
     //Sets the task name with validation.
     
    public void setName(String name) {
        if (name == null || name.length() > MAX_NAME_LENGTH)
            throw new IllegalArgumentException("Invalid name");
        this.name = name;
    }

    
    //Sets the task description with validation.
     
    public void setDescription(String description) {
        if (description == null || description.length() > MAX_DESC_LENGTH)
            throw new IllegalArgumentException("Invalid description");
        this.description = description;
    }
}
