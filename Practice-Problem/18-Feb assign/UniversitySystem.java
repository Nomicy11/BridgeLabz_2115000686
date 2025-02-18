import java.util.ArrayList;
import java.util.List;


abstract class CourseType {
    private String name;

    public CourseType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract void showEvaluationMethod();
}


class ExamCourse extends CourseType {
    public ExamCourse(String name) {
        super(name);
    }

    @Override
    public void showEvaluationMethod() {
        System.out.println(getName() + " is evaluated based on Exams.");
    }
}

class AssignmentCourse extends CourseType {
    public AssignmentCourse(String name) {
        super(name);
    }

    @Override
    public void showEvaluationMethod() {
        System.out.println(getName() + " is evaluated based on Assignments.");
    }
}

class ResearchCourse extends CourseType {
    public ResearchCourse(String name) {
        super(name);
    }

    @Override
    public void showEvaluationMethod() {
        System.out.println(getName() + " is evaluated based on Research Papers.");
    }
}


class Course<T extends CourseType> {
    private String courseName;
    private T courseType;

    public Course(String courseName, T courseType) {
        this.courseName = courseName;
        this.courseType = courseType;
    }

    public void displayCourseInfo() {
        System.out.println("Course: " + courseName);
        courseType.showEvaluationMethod();
    }
}


class CourseManager {
    public static void displayAllCourses(List<? extends CourseType> courses) {
        for (CourseType course : courses) {
            course.showEvaluationMethod();
        }
    }
}


public class UniversitySystem {
    public static void main(String[] args) {
      
        ExamCourse math = new ExamCourse("Mathematics");
        AssignmentCourse programming = new AssignmentCourse("Java Programming");
        ResearchCourse aiResearch = new ResearchCourse("AI Research");

    
        Course<ExamCourse> mathCourse = new Course<>("Math 101", math);
        Course<AssignmentCourse> javaCourse = new Course<>("Java 201", programming);
        Course<ResearchCourse> aiCourse = new Course<>("AI 301", aiResearch);

        
        mathCourse.displayCourseInfo();
        javaCourse.displayCourseInfo();
        aiCourse.displayCourseInfo();

        
        System.out.println("\nDisplaying all courses dynamically:");
        List<CourseType> allCourses = new ArrayList<>();
        allCourses.add(math);
        allCourses.add(programming);
        allCourses.add(aiResearch);

        CourseManager.displayAllCourses(allCourses);
    }
}
