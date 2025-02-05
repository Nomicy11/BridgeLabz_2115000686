import java.util.List;

class Course {
    private String name;
    private Professor professor;
    private List<Student> students;

    public Course(String name) {
        this.name = name;
        System.out.println("Course " + this.name + " created.");
    }

    public void assignProfessor(Professor professor) {
        this.professor = professor;
        System.out.println("Professor " + professor.getName() + " assigned to Course " + this.name);
    }

    public void enrollStudent(Student student) {
        students.add(student);
        System.out.println("Student " + student.getName() + " enrolled in Course " + this.name);
    }

    public String getName() {
        return this.name;
    }
}

class Student {
    private String name;

    public Student(String name) {
        this.name = name;
        System.out.println("Student " + this.name + " created.");
    }

    public void enrollCourse(Course course) {
        course.enrollStudent(this);
    }

    public String getName() {
        return this.name;
    }
}

class Professor {
    private String name;

    public Professor(String name) {
        this.name = name;
        System.out.println("Professor " + this.name + " created.");
    }

    public void assignProfessorToCourse(Course course) {
        course.assignProfessor(this);
    }

    public String getName() {
        return this.name;
    }
}

public class UniversityManagementSystem {
    public static void main(String[] args) {
        
        Student student1 = new Student("Alice");
        Student student2 = new Student("Bob");

       
        Professor professor1 = new Professor("Dr. Smith");
        Professor professor2 = new Professor("Dr. Johnson");

        
        Course course1 = new Course("Computer Science");
        Course course2 = new Course("Mathematics");

        
        professor1.assignProfessorToCourse(course1);
        professor2.assignProfessorToCourse(course2);

        
        student1.enrollCourse(course1);
        student2.enrollCourse(course2);
    }
}
