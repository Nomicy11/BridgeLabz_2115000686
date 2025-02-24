package Annotation;

import java.lang.annotation.*;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface ImportantMethod {
    String level() default "HIGH";
}

class Demo {
    @ImportantMethod(level = "HIGH")
    public void criticalProcess() {
        System.out.println("Executing critical process...");
    }

    @ImportantMethod(level = "MEDIUM")
    public void minorProcess() {
        System.out.println("Executing minor process...");
    }
}

public class ImportantMethodProcessor {
    public static void main(String[] args) throws Exception {
        Method[] methods = Demo.class.getDeclaredMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(ImportantMethod.class)) {
                ImportantMethod annotation = method.getAnnotation(ImportantMethod.class);
                System.out.println("Method: " + method.getName() + " - Importance Level: " + annotation.level());
            }
        }
    }
}
