import java.io.*;

public class SearchEmployee {
    public static void main(String[] args) {
        String filePath = "employees.csv";
        String searchName = "Jane Smith";  // Change this value to search dynamically

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] columns = line.split(",");
                if (columns[1].equalsIgnoreCase(searchName)) {
                    System.out.println("Department: " + columns[2] + ", Salary: " + columns[3]);
                    return;
                }
            }
            System.out.println("Employee not found.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
