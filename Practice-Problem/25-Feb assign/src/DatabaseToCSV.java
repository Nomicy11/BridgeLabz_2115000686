import java.io.*;
import java.sql.*;

public class DatabaseToCSV {
    public static void main(String[] args) {
        String jdbcURL = "jdbc:mysql://localhost:3306/company"; // Change DB details
        String username = "root"; // Your database username
        String password = "password"; // Your database password
        String csvFile = "employee_report.csv";

        try (Connection conn = DriverManager.getConnection(jdbcURL, username, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT EmployeeID, Name, Department, Salary FROM employees");
             BufferedWriter writer = new BufferedWriter(new FileWriter(csvFile))) {

            writer.write("EmployeeID,Name,Department,Salary\n"); // Write headers

            while (rs.next()) {
                String row = rs.getInt("EmployeeID") + "," +
                        rs.getString("Name") + "," +
                        rs.getString("Department") + "," +
                        rs.getDouble("Salary") + "\n";
                writer.write(row);
            }

            System.out.println("CSV Report Generated: " + csvFile);
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }
}
