import java.util.Scanner;

class Task {
    int id, priority;
    String name, dueDate;
    Task next;

    Task(int id, String name, int priority, String dueDate) {
        this.id = id;
        this.name = name;
        this.priority = priority;
        this.dueDate = dueDate;
    }
}

class TaskScheduler {
    private Task head = null, tail = null, currentTask = null;

    void addAtBeginning(int id, String name, int priority, String dueDate) {
        Task newTask = new Task(id, name, priority, dueDate);
        if (head == null) {
            head = tail = newTask;
            tail.next = head; 
        } else {
            newTask.next = head;
            head = newTask;
            tail.next = head; 
        }
    }

    void addAtEnd(int id, String name, int priority, String dueDate) {
        Task newTask = new Task(id, name, priority, dueDate);
        if (head == null) {
            head = tail = newTask;
            tail.next = head;
        } else {
            tail.next = newTask;
            tail = newTask;
            tail.next = head; 
        }
    }

    void addAtPosition(int id, String name, int priority, String dueDate, int position) {
        if (position <= 1) {
            addAtBeginning(id, name, priority, dueDate);
            return;
        }
        Task newTask = new Task(id, name, priority, dueDate);
        Task temp = head;
        for (int i = 1; temp.next != head && i < position - 1; i++) {
            temp = temp.next;
        }
        newTask.next = temp.next;
        temp.next = newTask;
        if (temp == tail) {
            tail = newTask; 
        }
        tail.next = head; 
    }

    void removeTask(int id) {
        if (head == null) return;
        Task temp = head, prev = null;
        do {
            if (temp.id == id) {
                if (temp == head) {
                    head = head.next;
                    tail.next = head;
                } else if (temp == tail) {
                    prev.next = head;
                    tail = prev;
                } else {
                    prev.next = temp.next;
                }
                return;
            }
            prev = temp;
            temp = temp.next;
        } while (temp != head);
    }

    Task searchTaskByPriority(int priority) {
        if (head == null) return null;
        Task temp = head;
        do {
            if (temp.priority == priority) return temp;
            temp = temp.next;
        } while (temp != head);
        return null;
    }

    void viewCurrentTask() {
        if (currentTask == null) {
            currentTask = head;
        }
        if (currentTask != null) {
            System.out.println("Current Task: " + currentTask.name + " | Priority: " + currentTask.priority);
            currentTask = currentTask.next;
        }
    }

    void displayTasks() {
        if (head == null) {
            System.out.println("No tasks available.");
            return;
        }
        Task temp = head;
        do {
            System.out.println(temp.id + " | " + temp.name + " | " + temp.priority + " | " + temp.dueDate);
            temp = temp.next;
        } while (temp != head);
    }
}

public class TaskManager {
    public static void main(String[] args) {
        TaskScheduler scheduler = new TaskScheduler();
        Scanner sc = new Scanner(System.in);

        scheduler.addAtBeginning(1, "Design UI", 3, "2024-03-01");
        scheduler.addAtEnd(2, "Implement Backend", 1, "2024-03-10");
        scheduler.displayTasks();

        System.out.print("Enter Task ID to Remove: ");
        scheduler.removeTask(sc.nextInt());
        scheduler.displayTasks();

        System.out.println("Viewing Tasks in Circular Order:");
        scheduler.viewCurrentTask();
        scheduler.viewCurrentTask();
    }
}
