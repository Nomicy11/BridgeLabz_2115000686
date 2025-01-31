import java.util.Scanner;

class Employee {
    public String name;
    public int id;
    public double salary;

   
    public Employee(String name, int id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    
    public void displayDetails() {
        System.out.println("Employee Details:");
        System.out.println("Name: " + name);
        System.out.println("ID: " + id);
        System.out.println("Salary: " + salary);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
  
        System.out.print("Enter Employee Name: ");
        String name = sc.nextLine();
        
        System.out.print("Enter Employee ID: ");
        int id = sc.nextInt();
        
        System.out.print("Enter Employee Salary: ");
        double salary = sc.nextDouble();
        
       
        Employee emp = new Employee(name, id, salary);
        
    
        emp.displayDetails();
        

    }
}
