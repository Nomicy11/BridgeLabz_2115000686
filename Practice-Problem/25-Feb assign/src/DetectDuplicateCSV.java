import java.io.*;
import java.util.*;

public class DetectDuplicateCSV {
    public static void main(String[] args) {
        String filePath = "students.csv"; // Replace with your actual file
        Map<String, String> recordMap = new HashMap<>();
        Set<String> duplicates = new HashSet<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line = br.readLine(); // Read header
            System.out.println("Duplicate Records:");

            while ((line = br.readLine()) != null) {
                String[] columns = line.split(",");
                String id = columns[0];

                if (recordMap.containsKey(id)) {
                    duplicates.add(line);
                } else {
                    recordMap.put(id, line);
                }
            }

            // Print duplicate records
            for (String duplicate : duplicates) {
                System.out.println(duplicate);
            }

            if (duplicates.isEmpty()) {
                System.out.println("No duplicates found.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
