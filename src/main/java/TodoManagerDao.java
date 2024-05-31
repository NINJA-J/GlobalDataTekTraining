import java.util.ArrayList;
import java.util.List;

public class TodoManagerDao {
    private final List<Task> tasks = new ArrayList<>();

    private int nextId = 0;

    public void addTask(String taskTitle, String taskText) {
        Task task = new Task();
        task.setTaskId(nextId++);
        task.setTaskTitle(taskTitle);
        task.setTaskText(taskText);
        task.setAssignedTo(null);
        tasks.add(task);
    }

    public void delTask(String taskTitle) {
        tasks.removeIf(t -> taskTitle.equals(t.getTaskTitle()));
    }

    public Task getTask(String taskTitle) {
        return tasks.stream().filter(t -> taskTitle.equals(t.getTaskTitle())).findAny().orElse(null);
    }

    public List<Task> getTasks() {
        return tasks;
    }
}
