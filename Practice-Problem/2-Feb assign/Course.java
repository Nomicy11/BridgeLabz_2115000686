class Course {
    private String courseName;
    private int duration;
    private double fee;
    private static String instituteName = "Tech Academy";

    public Course(String courseName, int duration, double fee) {
        this.courseName = courseName;
        this.duration = duration;
        this.fee = fee;
    }

    public void displayCourseDetails() {
        System.out.println("Course Name: " + courseName);
        System.out.println("Duration: " + duration + " months");
        System.out.println("Fee: $" + fee);
        System.out.println("Institute: " + instituteName);
    }

    public static void updateInstituteName(String newName) {
        instituteName = newName;
    }

    public static void main(String[] args) {
        Course c1 = new Course("Java Programming", 6, 499.99);
        Course c2 = new Course("Web Development", 4, 399.99);
        
        c1.displayCourseDetails();
        c2.displayCourseDetails();
        
        Course.updateInstituteName("Code Academy");
        
        c1.displayCourseDetails();
        c2.displayCourseDetails();
    }
}
