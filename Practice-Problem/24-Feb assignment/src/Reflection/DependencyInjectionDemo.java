package Reflection;

import java.lang.annotation.*;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

// Step 1: Define @Inject Annotation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface Inject {}

// Step 2: Define Service Class
class Service {
    public void serve() {
        System.out.println("Service is running...");
    }
}

// Step 3: Define Controller Class with @Inject Annotation
class Controller {
    @Inject
    private Service service;

    public void handleRequest() {
        service.serve();
        System.out.println("Controller handling request.");
    }
}

// Step 4: Create DI Container to Inject Dependencies
class DIContainer {
    private final Map<Class<?>, Object> instances = new HashMap<>();

    public DIContainer() {
        instances.put(Service.class, new Service()); // Register default instances
    }

    public <T> T getInstance(Class<T> clazz) throws Exception {
        T obj = clazz.getDeclaredConstructor().newInstance(); // Create instance

        for (Field field : clazz.getDeclaredFields()) {
            if (field.isAnnotationPresent(Inject.class)) {
                Class<?> fieldType = field.getType();
                Object dependency = instances.computeIfAbsent(fieldType, k -> {
                    try {
                        return fieldType.getDeclaredConstructor().newInstance();
                    } catch (Exception e) {
                        throw new RuntimeException("Failed to create dependency: " + fieldType, e);
                    }
                });

                field.setAccessible(true);
                field.set(obj, dependency);
            }
        }
        return obj;
    }
}

// Step 5: Main Method to Demonstrate DI in Action
public class DependencyInjectionDemo {
    public static void main(String[] args) throws Exception {
        DIContainer container = new DIContainer();

        // Get an instance of Controller with dependencies injected
        Controller controller = container.getInstance(Controller.class);
        controller.handleRequest();  // Should work without explicitly setting the service
    }
}
