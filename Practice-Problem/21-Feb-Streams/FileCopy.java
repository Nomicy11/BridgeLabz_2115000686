import java.io.*;

public class FileCopy {
    public static void main(String[] args) {
        String sourceFile = "source.txt";
        String destinationFile = "destination.txt";

        
        try (FileOutputStream fos = new FileOutputStream(sourceFile)) {
            String content = "This is a sample text file.\nIt contains multiple lines of text.";
            fos.write(content.getBytes());
        } catch (IOException e) {
            System.out.println("Error: Unable to write to source file.");
            e.printStackTrace();
        }

    
        try (FileInputStream fis = new FileInputStream(sourceFile);
             FileOutputStream fos = new FileOutputStream(destinationFile)) {
            
            int byteData;
            while ((byteData = fis.read()) != -1) {
                fos.write(byteData);
            }
            
            System.out.println("File copied successfully.");
        } catch (FileNotFoundException e) {
            System.out.println("Error: Source file not found.");
        } catch (IOException e) {
            System.out.println("Error: An I/O error occurred.");
            e.printStackTrace();
        }
    }
}
