import java.io.*;
import java.util.ArrayList;
import java.util.List;

class Employee implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private String name;
    private String department;
    private double salary;

    public Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return id + "," + name + "," + department + "," + salary;
    }
}

public class ImageByteArrayConverter {
    public static void main(String[] args) {
        String sourceImage = "s11.jpg";
        String destinationImage = "d11.jpg";

        try {
           
            byte[] imageBytes;
            try (ByteArrayOutputStream baos = new ByteArrayOutputStream();
                 FileInputStream fis = new FileInputStream(sourceImage)) {
                byte[] buffer = new byte[1024];
                int bytesRead;
                while ((bytesRead = fis.read(buffer)) != -1) {
                    baos.write(buffer, 0, bytesRead);
                }
                imageBytes = baos.toByteArray();
            }

            
            try (ByteArrayInputStream bais = new ByteArrayInputStream(imageBytes);
                 FileOutputStream fos = new FileOutputStream(destinationImage)) {
                byte[] buffer = new byte[1024];
                int bytesRead;
                while ((bytesRead = bais.read(buffer)) != -1) {
                    fos.write(buffer, 0, bytesRead);
                }
            }

            System.out.println("Image successfully copied using ByteArray Streams.");
        } catch (IOException e) {
            System.out.println("Error: Unable to process the image file.");
            e.printStackTrace();
        }
    }
}
