package Annotation;

import java.lang.annotation.*;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface RoleAllowed {
    String value();
}

class SecureService {
    @RoleAllowed("ADMIN")
    public void adminTask() {
        System.out.println("Admin task executed.");
    }
}

public class RoleAccessTest {
    public static void main(String[] args) throws Exception {
        String userRole = "USER"; // Simulate user role

        SecureService service = new SecureService();
        Method method = service.getClass().getMethod("adminTask");

        if (method.isAnnotationPresent(RoleAllowed.class)) {
            RoleAllowed annotation = method.getAnnotation(RoleAllowed.class);
            if (annotation.value().equals(userRole)) {
                method.invoke(service);
            } else {
                System.out.println("Access Denied!");
            }
        }
    }
}

