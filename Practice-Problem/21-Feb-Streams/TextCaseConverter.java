import java.io.*;

public class TextCaseConverter {
    public static void main(String[] args) {
        String sourceFile = "source.txt";
        String destinationFile = "destination3.txt";

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(sourceFile), "UTF-8"));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(destinationFile), "UTF-8"))) {
            
            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line.toLowerCase());
                writer.newLine();
            }
            
            System.out.println("File converted successfully from uppercase to lowercase.");
        } catch (IOException e) {
            System.out.println("Error: Unable to process the file.");
            e.printStackTrace();
        }
    }
}
