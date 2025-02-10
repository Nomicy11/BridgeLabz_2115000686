//Hierarchial Inheritance
class Person {
    public String name;
    public int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

   
    public void displayDetails() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }

    
    public void displayRole() {
        System.out.println("General Person Role");
    }
}

class Teacher extends Person {
    private String subject;

    public Teacher(String name, int age, String subject) {
        super(name, age);
        this.subject = subject;
    }

    public void displayRole() {
        System.out.println("Role: Teacher");
        System.out.println("Subject: " + subject);
    }
}


class Student extends Person {
    private int grade;

    public Student(String name, int age, int grade) {
        super(name, age);
        this.grade = grade;
    }

    public void displayRole() {
        System.out.println("Role: Student");
        System.out.println("Grade: " + grade);
    }
}

class Staff extends Person {
    private String department;

    public Staff(String name, int age, String department) {
        super(name, age);
        this.department = department;
    }

    public void displayRole() {
        System.out.println("Role: Staff Member");
        System.out.println("Department: " + department);
    }
}


public class SchoolSystem {
    public static void main(String[] args) {
       
        Teacher teacher = new Teacher("Sanjana", 35, "Mathematics");
        teacher.displayDetails();
        teacher.displayRole();
        System.out.println("----------------------");

      
        Student student = new Student("Nomicy", 16, 10);
        student.displayDetails();
        student.displayRole();
        System.out.println("----------------------");


        Staff staff = new Staff("Vrinda", 40, "Administration");
        staff.displayDetails();
        staff.displayRole();
    }
}
