import java.util.Stack;

class QueueUsingStacks {
    private Stack<Integer> stack1; 
    private Stack<Integer> stack2; 

    public QueueUsingStacks() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void enqueue(int item) {
        stack1.push(item);
    }

   
    public int dequeue() {
        if (stack2.isEmpty()) { 
            if (stack1.isEmpty()) {
                throw new RuntimeException("Queue is empty");
            }
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop(); 
    }

    public int peek() {
        if (stack2.isEmpty()) {
            if (stack1.isEmpty()) {
                throw new RuntimeException("Queue is empty");
            }
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.peek();
    }


    public boolean isEmpty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }

   
    public static void main(String[] args) {
        QueueUsingStacks queue = new QueueUsingStacks();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        System.out.println(queue.dequeue()); // Output: 1
        System.out.println(queue.dequeue()); // Output: 2
        queue.enqueue(4);
        System.out.println(queue.dequeue()); // Output: 3
        System.out.println(queue.peek());    // Output: 4
        System.out.println(queue.isEmpty()); // Output: false
        System.out.println(queue.dequeue()); // Output: 4
        System.out.println(queue.isEmpty()); // Output: true
    }
}
