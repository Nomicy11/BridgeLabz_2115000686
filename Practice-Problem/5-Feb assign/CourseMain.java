class Course {
    String courseName;
    Student[] enrolledStudents;
    int studentCount = 0;

    public Course(String courseName) {
        this.courseName = courseName;
        this.enrolledStudents = new Student[10];
    }

    public void enrollStudent(Student student) {
        enrolledStudents[studentCount++] = student;
        student.enrollInCourse(this);
    }

    public void showEnrolledStudents() {
        System.out.println("Students enrolled in " + courseName + ":");
        for (int i = 0; i < studentCount; i++) {
            System.out.println("- " + enrolledStudents[i].name);
        }
    }
}

class Student {
    String name;
    Course[] enrolledCourses;
    int courseCount = 0;

    public Student(String name) {
        this.name = name;
        this.enrolledCourses = new Course[10];
    }

    public void enrollInCourse(Course course) {
        enrolledCourses[courseCount++] = course;
    }

    public void showEnrolledCourses() {
        System.out.println(name + " is enrolled in:");
        for (int i = 0; i < courseCount; i++) {
            System.out.println("- " + enrolledCourses[i].courseName);
        }
    }
}

class School {
    String schoolName;
    Student[] students;
    int studentCount = 0;

    public School(String schoolName) {
        this.schoolName = schoolName;
        this.students = new Student[10];
    }

    public void addStudent(Student student) {
        students[studentCount++] = student;
    }

    public void showStudents() {
        System.out.println("Students at " + schoolName + ":");
        for (int i = 0; i < studentCount; i++) {
            System.out.println("- " + students[i].name);
        }
    }
}

public class CourseMain {
    public static void main(String[] args) {
        School school = new School("Greenwood High");
        
        Student alice = new Student("Alice");
        Student bob = new Student("Bob");
        
        school.addStudent(alice);
        school.addStudent(bob);
        
        Course math = new Course("Mathematics");
        Course science = new Course("Science");
        
        alice.enrollInCourse(math);
        alice.enrollInCourse(science);
        bob.enrollInCourse(math);
        
        school.showStudents();
        alice.showEnrolledCourses();
        bob.showEnrolledCourses();
        
        math.showEnrolledStudents();
        science.showEnrolledStudents();
    }
}
