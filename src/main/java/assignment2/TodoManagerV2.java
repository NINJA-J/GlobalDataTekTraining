package assignment2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TodoManagerV2 {
    private final List<String> tasks = new ArrayList<>();

    private final Scanner scanner = new Scanner(System.in);

    public TodoManagerV2() {
    }

    public void addTask(String task) {
        tasks.add(task);
    }

    public void delTask(String task) {
        if (tasks.remove(task)) {
            System.out.println(task + " removed");
        } else {
            System.out.println(task + " does not exist");
        }
    }

    public void updateTask(String from, String to) {
        int index = tasks.indexOf(from);
        if (index == -1) {
            System.out.println(from + " not found");
        } else {
            tasks.set(index, to);
            System.out.println(from + " is updated to ");
        }
    }

    public void findTasks(String task) {
        if (tasks.contains(task)) {
            System.out.println(task + " found");
        } else {
            System.out.println(task + " not found");
        }
    }

    public void showTasks() {
        System.out.println(tasks);
    }

    public void menu() {
        boolean isContinue = true;
        while (isContinue) {
            System.out.println("===============================");
            System.out.println("==     Todo Manager Menu     ==");
            System.out.println("== 1. Add assignment3.Task               ==");
            System.out.println("== 2. Delete assignment3.Task            ==");
            System.out.println("== 3. Update assignment3.Task            ==");
            System.out.println("== 4. Search assignment3.Task            ==");
            System.out.println("== 5. Print assignment3.Task             ==");
            System.out.println("== 0. Exit                   ==");
            System.out.println("===============================");
            System.out.print("Selection: ");
            int opt;
            try {
                opt = scanner.nextInt();
                if (opt < -1 || opt > 5) {
                    System.out.println("Invalid selection");
                    continue;
                }
            } catch (Exception e) {
                System.out.println("Invalid selection");
                continue;
            }
            switch (opt) {
                case 1:
                    System.out.print("assignment3.Task Name: ");
                    addTask(scanner.next());
                    break;
                case 2:
                    System.out.print("assignment3.Task Name: ");
                    delTask(scanner.next());
                    break;
                case 3:
                    System.out.print("Old assignment3.Task Name: ");
                    String old = scanner.next();
                    System.out.print("New assignment3.Task Name: ");
                    String newName = scanner.next();
                    updateTask(old, newName);
                    break;
                case 4:
                    System.out.print("assignment3.Task Name:");
                    findTasks(scanner.next());
                    break;
                case 5:
                    showTasks();
                    break;
                case 0:
                default:
                    isContinue = false;
                    break;
            }
        }
    }

    public static void main(String[] args) {
        new TodoManagerV2().menu();
    }
}
