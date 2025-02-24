package Annotation;

import java.lang.annotation.*;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Repeatable(BugReports.class)
@interface BugReport {
    String description();
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface BugReports {
    BugReport[] value();
}

class BugTracker {
    @BugReport(description = "NullPointerException on null input")
    @BugReport(description = "Performance issue with large datasets")
    public void process() {
        System.out.println("Processing...");
    }
}

public class BugReportProcessor {
    public static void main(String[] args) throws Exception {
        Method method = BugTracker.class.getMethod("process");
        BugReports bugReports = method.getAnnotation(BugReports.class);
        if (bugReports != null) {
            for (BugReport report : bugReports.value()) {
                System.out.println("Bug: " + report.description());
            }
        }
    }
}
