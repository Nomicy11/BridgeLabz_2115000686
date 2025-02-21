import java.io.*;
import java.util.ArrayList;
import java.util.List;

class Employee implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private String name;
    private String department;
    private double salary;

    public Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return id + "," + name + "," + department + "," + salary;
    }
}

public class EmployeeFileHandler {
    public static void main(String[] args) {
        String employeeFile = "employees.txt";

        // Create employee list
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1, "Alice", "HR", 50000));
        employees.add(new Employee(2, "Bob", "IT", 60000));
        employees.add(new Employee(3, "Charlie", "Finance", 70000));

        // Write employee list to a text file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(employeeFile))) {
            for (Employee emp : employees) {
                writer.write(emp.toString());
                writer.newLine();
            }
            System.out.println("Employee data saved successfully to text file.");
        } catch (IOException e) {
            System.out.println("Error: Unable to write employee data to file.");
            e.printStackTrace();
        }

        // Read and display employee list from the text file
        try (BufferedReader reader = new BufferedReader(new FileReader(employeeFile))) {
            System.out.println("Deserialized Employee Data:");
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error: Unable to read employee data from file.");
            e.printStackTrace();
        }
    }
}
