import java.io.*;
import java.util.regex.*;

public class ValidateCSV {
    public static void main(String[] args) {
        String filePath = "employees.csv";
        Pattern emailPattern = Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");
        Pattern phonePattern = Pattern.compile("^\\d{10}$");

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line = br.readLine();
            while ((line = br.readLine()) != null) {
                String[] columns = line.split(",");
                if (!emailPattern.matcher(columns[4]).matches()) {
                    System.out.println("Invalid Email: " + columns[4]);
                }
                if (!phonePattern.matcher(columns[5]).matches()) {
                    System.out.println("Invalid Phone Number: " + columns[5]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
