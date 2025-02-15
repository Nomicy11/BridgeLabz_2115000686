import java.io.*;

public class PerformanceComparison {
    public static void main(String[] args) {
        compareStringConcatenation();
        countWordsInFile("large_text_file.txt"); 
    }

    // Task 1: Compare StringBuilder vs StringBuffer for concatenation
    public static void compareStringConcatenation() {
        int iterations = 1_000_000;
        String text = "hello";

        // Measure time for StringBuilder
        long startTimeBuilder = System.nanoTime();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < iterations; i++) {
            sb.append(text);
        }
        long endTimeBuilder = System.nanoTime();
        long durationBuilder = (endTimeBuilder - startTimeBuilder) / 1_000_000; // Convert to milliseconds

        // Measure time for StringBuffer
        long startTimeBuffer = System.nanoTime();
        StringBuffer sbf = new StringBuffer();
        for (int i = 0; i < iterations; i++) {
            sbf.append(text);
        }
        long endTimeBuffer = System.nanoTime();
        long durationBuffer = (endTimeBuffer - startTimeBuffer) / 1_000_000; // Convert to milliseconds

        System.out.println("StringBuilder time: " + durationBuilder + " ms");
        System.out.println("StringBuffer time: " + durationBuffer + " ms");
    }

    // Task 2: Read large file and count words using FileReader and InputStreamReader
    public static void countWordsInFile(String filePath) {
        int wordCount = 0;

        try (FileInputStream fileInputStream = new FileInputStream(filePath);
             InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "UTF-8");
             BufferedReader bufferedReader = new BufferedReader(inputStreamReader)) {

            long startTime = System.nanoTime();
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                String[] words = line.split("\\s+"); // Split on whitespace
                wordCount += words.length;
            }
            long endTime = System.nanoTime();
            long duration = (endTime - startTime) / 1_000_000; // Convert to milliseconds

            System.out.println("Total words in file: " + wordCount);
            System.out.println("File reading time: " + duration + " ms");

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
