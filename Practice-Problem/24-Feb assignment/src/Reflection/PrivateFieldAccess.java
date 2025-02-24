package Reflection;

import java.lang.reflect.Field;

class Person {
    private int age = 25;
}

public class PrivateFieldAccess {
    public static void main(String[] args) throws Exception {
        Person person = new Person();
        Class<?> cls = person.getClass();

        Field ageField = cls.getDeclaredField("age");
        ageField.setAccessible(true);

        System.out.println("Old Age: " + ageField.get(person));

        ageField.set(person, 30);

        System.out.println("New Age: " + ageField.get(person));
    }
}

