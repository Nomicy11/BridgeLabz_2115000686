//MultiLevel Inheritance
class Course {
    protected String courseName;
    public int duration; 

    public Course(String courseName, int duration) {
        this.courseName = courseName;
        this.duration = duration;
    }

    
    public void displayCourseDetails() {
        System.out.println("Course Name: " + courseName);
        System.out.println("Duration: " + duration + " weeks");
    }
}


class OnlineCourse extends Course {
    private String platform;
    private boolean isRecorded;

    public OnlineCourse(String courseName, int duration, String platform, boolean isRecorded) {
        super(courseName, duration);
        this.platform = platform;
        this.isRecorded = isRecorded;
    }

  
    public void displayCourseDetails() {
        super.displayCourseDetails();
        System.out.println("Platform: " + platform);
        System.out.println("Recorded: " + (isRecorded ? "Yes" : "No"));
    }
}


class PaidOnlineCourse extends OnlineCourse {
    private double fee;
    private double discount; 

    public PaidOnlineCourse(String courseName, int duration, String platform, boolean isRecorded, double fee, double discount) {
        super(courseName, duration, platform, isRecorded);
        this.fee = fee;
        this.discount = discount;
    }

    public double getFinalPrice() {
        return fee - (fee * (discount / 100));
    }

 
    public void displayCourseDetails() {
        super.displayCourseDetails();
        System.out.println("Course Fee: $" + fee);
        System.out.println("Discount: " + discount + "%");
        System.out.println("Final Price: $" + getFinalPrice());
    }
}


public class CourseManagement {
    public static void main(String[] args) {
        
        Course basicCourse = new Course("Introduction to Programming", 6);
        basicCourse.displayCourseDetails();
        System.out.println("----------------------");

        
        OnlineCourse onlineCourse = new OnlineCourse("Java for Beginners", 8, "Udemy", true);
        onlineCourse.displayCourseDetails();
        System.out.println("----------------------");


        PaidOnlineCourse paidCourse = new PaidOnlineCourse("Advanced Java", 10, "Coursera", true, 200, 20);
        paidCourse.displayCourseDetails();
    }
}
