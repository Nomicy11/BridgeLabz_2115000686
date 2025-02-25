import java.io.*;
import java.util.*;

public class SortEmployees {
    public static void main(String[] args) {
        String filePath = "employees.csv";
        List<String[]> employeeList = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String header = br.readLine();
            System.out.println(header);
            String line;

            while ((line = br.readLine()) != null) {
                employeeList.add(line.split(","));
            }

            employeeList.sort((a, b) -> Integer.parseInt(b[3]) - Integer.parseInt(a[3]));

            for (int i = 0; i < Math.min(5, employeeList.size()); i++) {
                System.out.println(String.join(",", employeeList.get(i)));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
