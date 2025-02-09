import java.util.Scanner;

abstract class Employee {
    private String employeeId;
    private String name;
    private double baseSalary;

    public Employee(String employeeId, String name, double baseSalary) {
        this.employeeId = employeeId;
        this.name = name;
        this.baseSalary = baseSalary;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public String getName() {
        return name;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        if (baseSalary < 0) {
            System.out.println("Invalid salary. Setting to 0.");
            this.baseSalary = 0;
        } else {
            this.baseSalary = baseSalary;
        }
    }

    public abstract double calculateSalary();

    public void displayDetails() {
        System.out.println("Employee ID: " + employeeId);
        System.out.println("Name: " + name);
        System.out.println("Base Salary: $" + baseSalary);
        System.out.println("Final Salary: $" + calculateSalary());
    }
}

interface Department {
    void assignDepartment(String department);
    String getDepartmentDetails();
}

class FullTimeEmployee extends Employee implements Department {
    private String department;

    public FullTimeEmployee(String employeeId, String name, double baseSalary) {
        super(employeeId, name, baseSalary);
    }

    @Override
    public double calculateSalary() {
        return getBaseSalary();
    }

    @Override
    public void assignDepartment(String department) {
        this.department = department;
    }

    @Override
    public String getDepartmentDetails() {
        return "Department: " + department;
    }
}

class PartTimeEmployee extends Employee implements Department {
    private int hoursWorked;
    private double hourlyRate;
    private String department;

    public PartTimeEmployee(String employeeId, String name, double hourlyRate, int hoursWorked) {
        super(employeeId, name, 0);
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }

    @Override
    public double calculateSalary() {
        return hoursWorked * hourlyRate;
    }

    @Override
    public void assignDepartment(String department) {
        this.department = department;
    }

    @Override
    public String getDepartmentDetails() {
        return "Department: " + department;
    }
}

public class EmployeeManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Full-Time Employee details:");
        System.out.print("ID: ");
        String ftId = scanner.next();
        System.out.print("Name: ");
        String ftName = scanner.next();
        System.out.print("Base Salary: ");
        double ftSalary = scanner.nextDouble();
        FullTimeEmployee emp1 = new FullTimeEmployee(ftId, ftName, ftSalary);

        System.out.print("Enter Department: ");
        String ftDept = scanner.next();
        emp1.assignDepartment(ftDept);

        System.out.println("\nEnter Part-Time Employee details:");
        System.out.print("ID: ");
        String ptId = scanner.next();
        System.out.print("Name: ");
        String ptName = scanner.next();
        System.out.print("Hourly Rate: ");
        double hourlyRate = scanner.nextDouble();
        System.out.print("Hours Worked: ");
        int hoursWorked = scanner.nextInt();
        PartTimeEmployee emp2 = new PartTimeEmployee(ptId, ptName, hourlyRate, hoursWorked);

        System.out.print("Enter Department: ");
        String ptDept = scanner.next();
        emp2.assignDepartment(ptDept);

        System.out.println("\nEmployee Details:");
        emp1.displayDetails();
        System.out.println(emp1.getDepartmentDetails());
        System.out.println("--------------------------");
        emp2.displayDetails();
        System.out.println(emp2.getDepartmentDetails());

        scanner.close();
    }
}
