package Reflection;

import java.lang.reflect.Field;
import java.util.Map;

class User {
    public String name;
    public int age;
}

public class ObjectMapper {
    public static <T> T toObject(Class<T> clazz, Map<String, Object> properties) {
        try {
            T obj = clazz.getDeclaredConstructor().newInstance();

            for (Map.Entry<String, Object> entry : properties.entrySet()) {
                try {
                    Field field = clazz.getDeclaredField(entry.getKey());
                    field.setAccessible(true);

                    Object value = entry.getValue();

                    // Convert value to match field type if needed
                    if (value != null && !field.getType().isInstance(value)) {
                        value = convertValue(field.getType(), value);
                    }

                    field.set(obj, value);
                } catch (NoSuchFieldException e) {
                    System.out.println("Warning: Field '" + entry.getKey() + "' not found in class " + clazz.getName());
                }
            }
            return obj;
        } catch (Exception e) {
            throw new RuntimeException("Failed to map object: " + e.getMessage(), e);
        }
    }

    private static Object convertValue(Class<?> fieldType, Object value) {
        if (fieldType == int.class || fieldType == Integer.class) {
            return Integer.parseInt(value.toString());
        } else if (fieldType == double.class || fieldType == Double.class) {
            return Double.parseDouble(value.toString());
        } else if (fieldType == boolean.class || fieldType == Boolean.class) {
            return Boolean.parseBoolean(value.toString());
        }
        return value; // Return as is if no conversion is required
    }

    public static void main(String[] args) {
        Map<String, Object> properties = Map.of("name", "Alice", "age", "30");

        User user = toObject(User.class, properties);
        System.out.println("User Name: " + user.name);
        System.out.println("User Age: " + user.age);
    }
}
