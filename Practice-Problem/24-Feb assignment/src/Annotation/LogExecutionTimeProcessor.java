package Annotation;

import java.lang.annotation.*;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface LogExecutionTime {}

class PerformanceTest {
    @LogExecutionTime
    public void longRunningTask() throws InterruptedException {
        long start = System.nanoTime();
        Thread.sleep(500);
        long end = System.nanoTime();
        System.out.println("Execution time: " + (end - start) / 1_000_000 + " ms");
    }
}

public class LogExecutionTimeProcessor {
    public static void main(String[] args) throws Exception {
        PerformanceTest test = new PerformanceTest();
        Method method = test.getClass().getMethod("longRunningTask");
        if (method.isAnnotationPresent(LogExecutionTime.class)) {
            method.invoke(test);
        }
    }
}

