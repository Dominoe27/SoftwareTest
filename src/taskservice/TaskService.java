package taskservice;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.UUID;


 //Service for managing tasks in-memory using unique IDs.
 
public class TaskService {
    // Make the data structure private.
    private final Map<String, Task> tasks = new HashMap<>();

    
     //Adds a new Task object with generating a unique ID.
     //Returns the created Task for testing.
     
    public Task addTask(Task task) {
        String id;
        do {
            id = UUID.randomUUID().toString().substring(0, 10);
        } while (tasks.containsKey(id));

        Task newTask = new Task(id, task.getName(), task.getDescription());
        tasks.put(id, newTask);
        return newTask;
    }

    
     //Deletes a task by ID.
     
    public void deleteTask(String taskID) {
        if (!tasks.containsKey(taskID)) {
            throw new NoSuchElementException("Task ID not found");
        }
        tasks.remove(taskID);
    }

    
     //Updates name and description of a task using a new Task object.
     
    public void updateTask(String taskID, Task updatedTask) {
        Task task = tasks.get(taskID);
        if (task == null) {
            throw new NoSuchElementException("Task ID not found");
        }
        task.setName(updatedTask.getName());
        task.setDescription(updatedTask.getDescription());
    }

    
     //Retrieves a task by ID or returns null.
     
    public Task getTask(String taskID) {
        return tasks.getOrDefault(taskID, null);
    }

    
     //Returns current count of tasks.
     
    public int getTaskCount() {
        return tasks.size();
    }
}
