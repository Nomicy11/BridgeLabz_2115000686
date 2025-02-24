package Annotation;
import java.lang.annotation.*;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface Todo {
    String task();
    String assignedTo();
    String priority() default "MEDIUM";
}

class FeatureDevelopment2 {
    @Todo(task = "Implement login feature", assignedTo = "Alice", priority = "HIGH")
    public void developLogin() {
        System.out.println("Developing login...");
    }

    @Todo(task = "Optimize database queries", assignedTo = "Bob")
    public void optimizeDB() {
        System.out.println("Optimizing database...");
    }
}

public class TodoProcessor2 {
    public static void main(String[] args) throws Exception {
        Method[] methods = FeatureDevelopment2.class.getDeclaredMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(Todo.class)) {
                Todo annotation = method.getAnnotation(Todo.class);
                System.out.println("Task: " + annotation.task() + " | Assigned to: " + annotation.assignedTo() +
                        " | Priority: " + annotation.priority());
            }
        }
    }
}
