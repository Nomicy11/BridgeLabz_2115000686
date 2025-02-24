package Reflection;

import java.lang.reflect.Constructor;

class Student {
    private String name;

    public Student() {
        this.name = "Default Student";
    }

    public void display() {
        System.out.println("Student Name: " + name);
    }
}

public class DynamicObjectCreation {
    public static void main(String[] args) throws Exception {
        Class<?> cls = Student.class;

        Constructor<?> constructor = cls.getConstructor();
        Student student = (Student) constructor.newInstance();

        student.display();
    }
}
