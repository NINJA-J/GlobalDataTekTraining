package assignment1;

import java.util.*;

public class TaskManager {
    private List<String> tasks = new ArrayList<>();
    private Map<String, Integer> cnt = new HashMap<>();

    public TaskManager() {
    }

    public void addTask(String task) {
        tasks.add(task);
        cnt.put(task, cnt.getOrDefault(task, 0) + 1);
    }

    public void printAscending() {
        List<String> cpy = new ArrayList<>(tasks);
        cpy.sort(String::compareTo);
        System.out.println("Tasks in Ascending Order: " + cpy);
    }

    public void printDescending() {
        List<String> cpy = new ArrayList<>(tasks);
        cpy.sort(Comparator.reverseOrder());
        System.out.println("Tasks in Descending Order: " + cpy);
    }

    public void printRepeatedTasks() {
        System.out.println("assignment3.Task repeat information:");
        for (Map.Entry<String, Integer> e: cnt.entrySet()) {
            if (e.getValue() == 1) {
                System.out.println("    assignment3.Task " + e.getKey() + " has no repeated tasks");
            } else {
                System.out.println("    assignment3.Task " + e.getKey() + " repeated " + e.getValue() + " times");
            }
        }
    }

    public static void main(String[] args) {
        TaskManager manager = new TaskManager();
        manager.addTask("t1");
        manager.addTask("t2");
        manager.addTask("t4");
        manager.addTask("t2");
        manager.addTask("t3");
        manager.addTask("t1");
        manager.addTask("t5");

        manager.printAscending();
        manager.printDescending();
        manager.printRepeatedTasks();
    }
}
