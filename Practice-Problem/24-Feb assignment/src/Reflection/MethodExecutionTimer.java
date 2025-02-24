package Reflection;

import java.lang.annotation.*;
import java.lang.reflect.Method;

// Step 1: Define @LogExecutionTime Annotation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface LogExecutionTime {}

// Step 2: Create a Sample Class with Methods to Test
class SampleTask {

    @LogExecutionTime
    public void fastMethod() {
        System.out.println("Fast method executed.");
    }

    @LogExecutionTime
    public void slowMethod() {
        try {
            Thread.sleep(500); // Simulating a slow operation
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Slow method executed.");
    }
}

// Step 3: Create Reflection-based Execution Timer
public class MethodExecutionTimer {
    public static void main(String[] args) throws Exception {
        SampleTask task = new SampleTask();
        Class<?> cls = task.getClass();

        for (Method method : cls.getDeclaredMethods()) {
            if (method.isAnnotationPresent(LogExecutionTime.class)) {
                long startTime = System.nanoTime();
                method.invoke(task); // Invoke the method dynamically
                long endTime = System.nanoTime();

                long executionTime = (endTime - startTime) / 1_000_000; // Convert to milliseconds
                System.out.println("Execution Time of " + method.getName() + ": " + executionTime + " ms\n");
            }
        }
    }
}
