import java.util.ArrayList;
import java.util.List;

abstract class JobRole {
    private String roleName;

    public JobRole(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleName() {
        return roleName;
    }

    public abstract void evaluateResume();
}


class SoftwareEngineer extends JobRole {
    public SoftwareEngineer() {
        super("Software Engineer");
    }

    @Override
    public void evaluateResume() {
        System.out.println("Evaluating resume for Software Engineer: Requires coding skills, problem-solving, and system design.");
    }
}

class DataScientist extends JobRole {
    public DataScientist() {
        super("Data Scientist");
    }

    @Override
    public void evaluateResume() {
        System.out.println("Evaluating resume for Data Scientist: Requires machine learning, statistics, and data analysis.");
    }
}

class ProductManager extends JobRole {
    public ProductManager() {
        super("Product Manager");
    }

    @Override
    public void evaluateResume() {
        System.out.println("Evaluating resume for Product Manager: Requires business strategy, leadership, and product vision.");
    }
}


class Resume<T extends JobRole> {
    private String candidateName;
    private T jobRole;

    public Resume(String candidateName, T jobRole) {
        this.candidateName = candidateName;
        this.jobRole = jobRole;
    }

    public void processResume() {
        System.out.println("\nProcessing Resume for: " + candidateName);
        jobRole.evaluateResume();
    }
}


class ResumeScreeningSystem {
    public static void screenResumes(List<? extends JobRole> jobRoles) {
        System.out.println("\nStarting AI-driven Resume Screening...");
        for (JobRole job : jobRoles) {
            job.evaluateResume();
        }
    }
}


public class ResumeScreening {
    public static void main(String[] args) {
 
        SoftwareEngineer seRole = new SoftwareEngineer();
        DataScientist dsRole = new DataScientist();
        ProductManager pmRole = new ProductManager();


        Resume<SoftwareEngineer> seResume = new Resume<>("Alice", seRole);
        Resume<DataScientist> dsResume = new Resume<>("Bob", dsRole);
        Resume<ProductManager> pmResume = new Resume<>("Charlie", pmRole);


        seResume.processResume();
        dsResume.processResume();
        pmResume.processResume();

   
        System.out.println("\nRunning AI Screening for Multiple Job Roles:");
        List<JobRole> jobRoles = new ArrayList<>();
        jobRoles.add(seRole);
        jobRoles.add(dsRole);
        jobRoles.add(pmRole);

        ResumeScreeningSystem.screenResumes(jobRoles);
    }
}
