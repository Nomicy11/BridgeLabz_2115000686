package Reflection;

import java.lang.reflect.Field;

class Product {
    public String name = "Laptop";
    public double price = 1000.99;
}

public class JSONGenerator {
    public static void main(String[] args) throws IllegalAccessException {
        Product product = new Product();
        Class<?> cls = product.getClass();
        StringBuilder json = new StringBuilder("{");

        for (Field field : cls.getDeclaredFields()) {
            field.setAccessible(true);
            json.append("\"").append(field.getName()).append("\": \"")
                    .append(field.get(product)).append("\", ");
        }

        json.setLength(json.length() - 2);
        json.append("}");
        System.out.println(json);
    }
}
