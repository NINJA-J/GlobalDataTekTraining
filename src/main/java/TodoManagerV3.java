import java.util.Scanner;

public class TodoManagerV3 {

    private final Scanner scanner = new Scanner(System.in);

    private final TodoManagerDao dao = new TodoManagerDao();

    public TodoManagerV3() {
    }

    public void addTask() {
        System.out.print("Task Title: ");
        String title = scanner.next();
        System.out.print("Task Text: ");
        String text = scanner.nextLine();
        dao.addTask(title, text);
    }

    public void delTask() {
        System.out.print("Task Title: ");
        dao.delTask(scanner.next());
    }

    public void updateTask() {
        System.out.print("Task Title: ");
        Task task = dao.getTask(scanner.next());
        if (task == null) {
            System.out.println("Task " + task + " doesn't not exist");
            return;
        }
        System.out.print("Update Title? Y/N: ");
        if (scanner.next().equals("Y")) {
            System.out.print("New Title: ");
            task.setTaskTitle(scanner.nextLine());
        }

        System.out.print("Update Text? Y/N: ");
        if (scanner.next().equals("Y")) {
            System.out.print("New Text: ");
            task.setTaskText(scanner.nextLine());
        }
    }

    public void findTasks() {
        System.out.print("Task Title: ");
        Task task = dao.getTask(scanner.next());
        if (task == null) {
            System.out.println("Task " + task + " doesn't not exist");
            return;
        }
        System.out.println("Task ID        : " + task.getTaskId());
        System.out.println("Task Title     : " + task.getTaskTitle());
        System.out.println("Task Text      : " + task.getTaskText());
        System.out.println("Task Assignment: " + task.getAssignedTo());
    }

    public void assignTask() {
        System.out.print("Task Title: ");
        Task task = dao.getTask(scanner.next());
        if (task == null) {
            System.out.println("Task " + task + " doesn't not exist");
            return;
        }
        System.out.print("Assign To: ");
        task.setAssignedTo(scanner.nextLine());
    }

    public void showTasks() {
        for (Task t : dao.getTasks()) {
            System.out.println("Task ID        : " + t.getTaskId());
            System.out.println("Task Title     : " + t.getTaskTitle());
            System.out.println("Task Text      : " + t.getTaskText());
            System.out.println("Task Assignment: " + t.getAssignedTo());

        }
    }

    public void menu() {
        boolean isContinue = true;
        while (isContinue) {
            System.out.println("===============================");
            System.out.println("==     Todo Manager Menu     ==");
            System.out.println("== 1. Add Task               ==");
            System.out.println("== 2. Delete Task            ==");
            System.out.println("== 3. Update Task            ==");
            System.out.println("== 4. Search Task            ==");
            System.out.println("== 5. Print Task             ==");
            System.out.println("== 5. Assign Task            ==");
            System.out.println("== 0. Exit                   ==");
            System.out.println("===============================");
            System.out.print("Selection: ");
            int opt;
            try {
                opt = scanner.nextInt();
                if (opt < -1 || opt > 6) {
                    System.out.println("Invalid selection");
                    continue;
                }
            } catch (Exception e) {
                System.out.println("Invalid selection");
                continue;
            }
            switch (opt) {
                case 1:
                    addTask();
                    break;
                case 2:
                    delTask();
                    break;
                case 3:
                    updateTask();
                    break;
                case 4:
                    findTasks();
                    break;
                case 5:
                    showTasks();
                    break;
                case 6:
                    assignTask();
                    break;
                case 0:
                default:
                    isContinue = false;
                    break;
            }
        }
    }

    public static void main(String[] args) {
        new TodoManagerV3().menu();
    }
}
