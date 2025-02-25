import java.io.*;
import java.util.*;

public class MergeCSV {
    public static void main(String[] args) {
        String file1 = "students1.csv";
        String file2 = "students2.csv";
        String outputFile = "merged_students.csv";
        Map<String, String[]> studentData = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(file1))) {
            br.readLine();
            String line;
            while ((line = br.readLine()) != null) {
                String[] columns = line.split(",");
                studentData.put(columns[0], columns);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedReader br = new BufferedReader(new FileReader(file2));
             BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile))) {

            br.readLine();
            bw.write("ID,Name,Age,Marks,Grade\n");
            String line;
            while ((line = br.readLine()) != null) {
                String[] columns = line.split(",");
                if (studentData.containsKey(columns[0])) {
                    String[] studentInfo = studentData.get(columns[0]);
                    bw.write(String.join(",", studentInfo) + "," + columns[1] + "," + columns[2] + "\n");
                }
            }
            System.out.println("Merged CSV created successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
