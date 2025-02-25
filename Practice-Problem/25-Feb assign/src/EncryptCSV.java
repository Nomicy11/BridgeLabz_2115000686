import java.io.*;

public class EncryptCSV {
    public static void main(String[] args) {
        String csvFile = "encrypted_employees.csv";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(csvFile))) {
            writer.write("EmployeeID,Name,Department,Salary,Email\n");

            String[] employees = {
                    "101,John Doe,IT,60000,john.doe@example.com",
                    "102,Jane Smith,HR,50000,jane.smith@example.com"
            };

            for (String emp : employees) {
                String[] details = emp.split(",");
                String encryptedSalary = EncryptDecryptUtil.encrypt(details[3]);
                String encryptedEmail = EncryptDecryptUtil.encrypt(details[4]);

                writer.write(details[0] + "," + details[1] + "," + details[2] + "," +
                        encryptedSalary + "," + encryptedEmail + "\n");
            }

            System.out.println("Encrypted CSV created: " + csvFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
