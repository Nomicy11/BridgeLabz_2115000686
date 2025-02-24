package Annotation;

import java.lang.annotation.*;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface Todo2 {
    String task();
    String assignedTo();
    String priority() default "MEDIUM";
}

class FeatureDevelopment{
    @Todo2(task = "Implement login feature", assignedTo = "Alice", priority = "HIGH")
    public void developLogin() {
        System.out.println("Developing login...");
    }

    @Todo2(task = "Optimize database queries", assignedTo = "Bob")
    public void optimizeDB() {
        System.out.println("Optimizing database...");
    }
}

public class TodoProcessor {
    public static void main(String[] args) throws Exception {
        Method[] methods = FeatureDevelopment.class.getDeclaredMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(Todo.class)) {
                Todo annotation = method.getAnnotation(Todo.class);
                System.out.println("Task: " + annotation.task() + " | Assigned to: " + annotation.assignedTo() +
                        " | Priority: " + annotation.priority());
            }
        }
    }
}

