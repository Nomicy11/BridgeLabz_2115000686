package Annotation;

import java.lang.annotation.*;
import java.lang.reflect.Field;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface JsonField {
    String name();
}

class User1 {
    @JsonField(name = "user_name")
    private String username = "john_doe";
}

public class JsonSerializer {
    public static void main(String[] args) throws Exception {
        User1 user = new User1();
        Field[] fields = user.getClass().getDeclaredFields();
        StringBuilder json = new StringBuilder("{");

        for (Field field : fields) {
            if (field.isAnnotationPresent(JsonField.class)) {
                field.setAccessible(true);
                JsonField annotation = field.getAnnotation(JsonField.class);
                json.append("\"").append(annotation.name()).append("\": \"").append(field.get(user)).append("\", ");
            }
        }

        json = new StringBuilder(json.substring(0, json.length() - 2) + "}");
        System.out.println(json);
    }
}
