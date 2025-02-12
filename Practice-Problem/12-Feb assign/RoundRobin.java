import java.util.Scanner;

class Process {
    int id, burstTime, remainingTime;
    Process next;

    Process(int id, int burstTime) {
        this.id = id;
        this.burstTime = burstTime;
        this.remainingTime = burstTime;
    }
}

class RoundRobinScheduler {
    private Process head = null, tail = null;
    private int timeQuantum;

    RoundRobinScheduler(int timeQuantum) {
        this.timeQuantum = timeQuantum;
    }

    void addProcess(int id, int burstTime) {
        Process newProcess = new Process(id, burstTime);
        if (head == null) {
            head = tail = newProcess;
            tail.next = head; // Circular linkage
        } else {
            tail.next = newProcess;
            tail = newProcess;
            tail.next = head; // Maintain circular link
        }
    }

    void removeProcess(int id) {
        if (head == null) return;
        Process temp = head, prev = null;
        do {
            if (temp.id == id) {
                if (temp == head && temp == tail) {
                    head = tail = null;
                } else {
                    if (temp == head) {
                        head = head.next;
                        tail.next = head;
                    } else if (temp == tail) {
                        prev.next = head;
                        tail = prev;
                    } else {
                        prev.next = temp.next;
                    }
                }
                return;
            }
            prev = temp;
            temp = temp.next;
        } while (temp != head);
    }

    void executeProcesses() {
        if (head == null) {
            System.out.println("No processes to execute.");
            return;
        }

        int currentTime = 0, totalWaitTime = 0, totalTurnaroundTime = 0, processCount = 0;
        Process temp = head;

        System.out.println("\nExecuting Processes (Round-Robin, Time Quantum = " + timeQuantum + "):");
        while (head != null) {
            do {
                if (temp.remainingTime > 0) {
                    int executedTime = Math.min(timeQuantum, temp.remainingTime);
                    temp.remainingTime -= executedTime;
                    currentTime += executedTime;

                    if (temp.remainingTime == 0) {
                        int turnaroundTime = currentTime;
                        int waitingTime = turnaroundTime - temp.burstTime;
                        totalWaitTime += waitingTime;
                        totalTurnaroundTime += turnaroundTime;
                        processCount++;

                        System.out.println("Process " + temp.id + " completed | TAT: " + turnaroundTime + " | WT: " + waitingTime);
                        removeProcess(temp.id);
                    }
                }
                temp = temp.next;
            } while (temp != head);
        }

        // Calculate and display averages
        System.out.println("\nAverage Waiting Time: " + (double) totalWaitTime / processCount);
        System.out.println("Average Turnaround Time: " + (double) totalTurnaroundTime / processCount);
    }

    void displayProcesses() {
        if (head == null) {
            System.out.println("No processes in queue.");
            return;
        }
        Process temp = head;
        System.out.print("Process Queue: ");
        do {
            System.out.print("[P" + temp.id + " | " + temp.remainingTime + "ms] -> ");
            temp = temp.next;
        } while (temp != head);
        System.out.println("(back to head)");
    }
}

public class RoundRobin {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Time Quantum: ");
        int quantum = sc.nextInt();
        RoundRobinScheduler scheduler = new RoundRobinScheduler(quantum);

        // Sample process addition
        scheduler.addProcess(1, 10);
        scheduler.addProcess(2, 5);
        scheduler.addProcess(3, 8);
        scheduler.displayProcesses();

        // Execute Round Robin Scheduling
        scheduler.executeProcesses();
    }
}
