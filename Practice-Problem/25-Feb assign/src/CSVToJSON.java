import org.json.JSONArray;
import org.json.JSONObject;
import java.io.*;

public class CSVToJSON {
    public static void main(String[] args) {
        String csvFile = "students.csv";
        String jsonFile = "students.json";

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile));
             BufferedWriter bw = new BufferedWriter(new FileWriter(jsonFile))) {

            String[] headers = br.readLine().split(","); // Read header
            JSONArray studentsArray = new JSONArray();
            String line;

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                JSONObject student = new JSONObject();
                for (int i = 0; i < headers.length; i++) {
                    student.put(headers[i], data[i]);
                }
                studentsArray.put(student);
            }

            bw.write(studentsArray.toString(4)); // Pretty print JSON
            System.out.println("CSV converted to JSON: " + jsonFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
