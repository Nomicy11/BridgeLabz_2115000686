import org.json.JSONArray;
import org.json.JSONObject;
import java.io.*;

public class JSONToCSV {
    public static void main(String[] args) {
        String jsonFile = "students.json";
        String csvFile = "students.csv";

        try (BufferedReader br = new BufferedReader(new FileReader(jsonFile));
             BufferedWriter bw = new BufferedWriter(new FileWriter(csvFile))) {

            StringBuilder jsonContent = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                jsonContent.append(line);
            }

            JSONArray students = new JSONArray(jsonContent.toString());
            bw.write("ID,Name,Age,Marks\n");

            for (int i = 0; i < students.length(); i++) {
                JSONObject student = students.getJSONObject(i);
                String row = student.getInt("ID") + "," +
                        student.getString("Name") + "," +
                        student.getInt("Age") + "," +
                        student.getInt("Marks") + "\n";
                bw.write(row);
            }

            System.out.println("JSON converted to CSV: " + csvFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
