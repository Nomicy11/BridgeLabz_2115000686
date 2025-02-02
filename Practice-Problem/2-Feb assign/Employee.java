class Employee {
    public int employeeID;
    protected String department;
    private double salary;

    public Employee(int employeeID, String department, double salary) {
        this.employeeID = employeeID;
        this.department = department;
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        if (salary >= 0) {
            this.salary = salary;
        } else {
            System.out.println("Salary cannot be negative.");
        }
    }

    public void displayEmployeeDetails() {
        System.out.println("Employee ID: " + employeeID);
        System.out.println("Department: " + department);
        System.out.println("Salary: $" + salary);
    }
}

class Manager extends Employee {
    private String teamName;

    public Manager(int employeeID, String department, double salary, String teamName) {
        super(employeeID, department, salary);
        this.teamName = teamName;
    }

    public void displayManagerDetails() {
        System.out.println("Manager Details:");
        System.out.println("Employee ID: " + employeeID);
        System.out.println("Department: " + department);
        System.out.println("Team Name: " + teamName);
    }

    public static void main(String[] args) {
        Employee emp = new Employee(101, "IT", 60000.0);
        emp.displayEmployeeDetails();
        emp.setSalary(65000.0);
        System.out.println("Updated Salary: $" + emp.getSalary());

        Manager mgr = new Manager(102, "HR", 80000.0, "Recruitment Team");
        mgr.displayManagerDetails();
    }
}
