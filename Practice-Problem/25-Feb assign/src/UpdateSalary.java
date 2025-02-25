import java.io.*;
import java.util.*;

public class UpdateSalary {
    public static void main(String[] args) {
        String inputFile = "employees.csv";
        String outputFile = "updated_employees.csv";

        try (BufferedReader br = new BufferedReader(new FileReader(inputFile));
             BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile))) {

            String line = br.readLine();
            bw.write(line + "\n"); // Write header

            while ((line = br.readLine()) != null) {
                String[] columns = line.split(",");
                if (columns[2].equalsIgnoreCase("IT")) {
                    int newSalary = (int) (Integer.parseInt(columns[3]) * 1.1); // Increase by 10%
                    columns[3] = String.valueOf(newSalary);
                }
                bw.write(String.join(",", columns) + "\n");
            }

            System.out.println("Salary updated and saved to " + outputFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
