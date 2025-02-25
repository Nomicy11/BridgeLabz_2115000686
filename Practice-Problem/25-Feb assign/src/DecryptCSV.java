import java.io.*;

public class DecryptCSV {
    public static void main(String[] args) {
        String csvFile = "encrypted_employees.csv";

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            String line = br.readLine(); // Read header
            System.out.println(line);

            while ((line = br.readLine()) != null) {
                String[] columns = line.split(",");
                String decryptedSalary = EncryptDecryptUtil.decrypt(columns[3]);
                String decryptedEmail = EncryptDecryptUtil.decrypt(columns[4]);

                System.out.println(columns[0] + "," + columns[1] + "," + columns[2] + "," +
                        decryptedSalary + "," + decryptedEmail);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
