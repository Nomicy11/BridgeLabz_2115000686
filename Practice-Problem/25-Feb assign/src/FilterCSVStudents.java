import java.io.*;

public class FilterCSVStudents {
    public static void main(String[] args) {
        String filePath = "students.csv";

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line = br.readLine(); // Read header
            System.out.println(line);

            while ((line = br.readLine()) != null) {
                String[] columns = line.split(",");
                int marks = Integer.parseInt(columns[3]);

                if (marks > 80) {
                    System.out.println(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
