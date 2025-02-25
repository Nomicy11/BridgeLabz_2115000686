import java.io.*;
import java.util.*;

class Student {
    String id, name, age, marks;

    public Student(String id, String name, String age, String marks) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.marks = marks;
    }

    @Override
    public String toString() {
        return id + " " + name + " " + age + " " + marks;
    }
}

public class ConvertCSVToObjects {
    public static void main(String[] args) {
        String filePath = "students.csv";
        List<Student> students = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            br.readLine(); // Skip header
            String line;
            while ((line = br.readLine()) != null) {
                String[] columns = line.split(",");
                students.add(new Student(columns[0], columns[1], columns[2], columns[3]));
            }

            for (Student student : students) {
                System.out.println(student);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
