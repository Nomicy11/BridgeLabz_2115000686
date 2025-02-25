import java.io.*;

public class ReadLargeCSV {
    public static void main(String[] args) {
        String filePath = "large_data.csv"; // Replace with your actual file
        int batchSize = 100; // Process 100 lines at a time
        int totalRecords = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            int count = 0;

            while ((line = br.readLine()) != null) {
                count++;
                totalRecords++;

                // Process the line (Here, we just print every 100th line as an example)
                if (count % batchSize == 0) {
                    System.out.println("Processed " + totalRecords + " records so far...");
                }
            }

            System.out.println("Total records processed: " + totalRecords);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
