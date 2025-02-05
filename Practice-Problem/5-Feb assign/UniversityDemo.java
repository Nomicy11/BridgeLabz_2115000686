class Department {
    private String name;

    public Department(String name) {
        this.name = name;
        System.out.println("Department " + this.name + " created.");
    }

    public void delete() {
        System.out.println("Department " + this.name + " deleted.");
    }
}

class Faculty {
    private String name;

    public Faculty(String name) {
        this.name = name;
        System.out.println("Faculty member " + this.name + " created.");
    }

    public void delete() {
        System.out.println("Faculty member " + this.name + " deleted.");
    }
}

class University {
    private String name;
    private Department department1;
    private Department department2;

    public University(String name, Department dept1, Department dept2) {
        this.name = name;
        this.department1 = dept1;
        this.department2 = dept2;
        System.out.println("University " + this.name + " created.");
    }

    public void delete() {
        // Composition: Delete all departments when the university is deleted
        if (department1 != null) department1.delete();
        if (department2 != null) department2.delete();
        System.out.println("University " + this.name + " deleted.");
    }
}

public class UniversityDemo {
    public static void main(String[] args) {
       
        Faculty faculty1 = new Faculty("Dr. Alice");
        Faculty faculty2 = new Faculty("Dr. Bob");

       
        Department department1 = new Department("Computer Science");
        Department department2 = new Department("Mathematics");

        
        University university = new University("Tech University", department1, department2);

        
        university.delete();

        
        faculty1.delete();
        faculty2.delete();
    }
}
