import java.io.*;

public class LargeFileReadingEfficiency {

   
    public static void readFileUsingFileReader(String filePath) throws IOException {
        FileReader fileReader = new FileReader(filePath);
        int character;
        while ((character = fileReader.read()) != -1) {
       
        }
        fileReader.close();
    }


    public static void readFileUsingInputStreamReader(String filePath) throws IOException {
        InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(filePath));
        int character;
        while ((character = inputStreamReader.read()) != -1) {
     
        }
        inputStreamReader.close();
    }

    public static void main(String[] args) {
        String filePath = "large_test_file.txt";
        
        try {
            
            long startTime = System.nanoTime();
            readFileUsingFileReader(filePath);
            long endTime = System.nanoTime();
            System.out.println("FileReader Time: " + (endTime - startTime) / 1000000 + " ms");

     
            startTime = System.nanoTime();
            readFileUsingInputStreamReader(filePath);
            endTime = System.nanoTime();
            System.out.println("InputStreamReader Time: " + (endTime - startTime) / 1000000 + " ms");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
