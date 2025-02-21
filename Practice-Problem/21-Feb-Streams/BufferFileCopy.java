import java.io.*;

public class BufferFileCopy {
    public static void main(String[] args) {
        String sourceFile = "buffersource.txt";
        String destinationFile = "bufferdestination.txt";

        try (FileOutputStream fos = new FileOutputStream(sourceFile)) {
            byte[] content = new byte[10 * 1024 * 1024]; // 10MB of data
            for (int i = 0; i < content.length; i++) {
                content[i] = (byte) (i % 256);
            }
            fos.write(content);
        } catch (IOException e) {
            System.out.println("Error: Unable to write to source file.");
            e.printStackTrace();
        }

        
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(sourceFile));
             BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destinationFile))) {
            
            byte[] buffer = new byte[4096]; 
            int bytesRead;
            long startTime = System.nanoTime();
            
            while ((bytesRead = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, bytesRead);
            }
            
            long endTime = System.nanoTime();
            System.out.println("Buffered copy completed in: " + (endTime - startTime) / 1_000_000 + " ms");
        } catch (FileNotFoundException e) {
            System.out.println("Error: Source file not found.");
        } catch (IOException e) {
            System.out.println("Error: An I/O error occurred.");
            e.printStackTrace();
        }

        
        try (FileInputStream fis = new FileInputStream(sourceFile);
             FileOutputStream fos = new FileOutputStream(destinationFile)) {
            
            int byteData;
            long startTime = System.nanoTime();
            
            while ((byteData = fis.read()) != -1) {
                fos.write(byteData);
            }
            
            long endTime = System.nanoTime();
            System.out.println("Unbuffered copy completed in: " + (endTime - startTime) / 1_000_000 + " ms");
        } catch (FileNotFoundException e) {
            System.out.println("Error: Source file not found.");
        } catch (IOException e) {
            System.out.println("Error: An I/O error occurred.");
            e.printStackTrace();
        }
    }
}
