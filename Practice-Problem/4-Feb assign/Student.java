class Student {
    private static String universityName = "GLA University";
    private static int totalStudents = 0;

    private final int rollNumber;
    private String name;
    private String grade;

    public Student(int rollNumber, String name, String grade) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.grade = grade;
        totalStudents++;
    }

    public static void displayTotalStudents() {
        System.out.println("Total Students Enrolled: " + totalStudents);
    }

    public void updateGrade(String newGrade) {
        if (this instanceof Student) {
            this.grade = newGrade;
            System.out.println("\nGrade updated for " + name);
        }
    }

    public void displayStudentDetails() {
        if (this instanceof Student) {
            System.out.println("\n--- Student Details ---");
            System.out.println("University: " + universityName);
            System.out.println("Roll Number: " + rollNumber);
            System.out.println("Name: " + name);
            System.out.println("Grade: " + grade);
        }
    }

    public static void main(String[] args) {
        Student s1 = new Student(101, "Vrinda", "A");
        Student s2 = new Student(102, "Nomicy", "B");

        s1.displayStudentDetails();
        s2.displayStudentDetails();

        displayTotalStudents();

        s2.updateGrade("A");

        s2.displayStudentDetails();
    }
}
