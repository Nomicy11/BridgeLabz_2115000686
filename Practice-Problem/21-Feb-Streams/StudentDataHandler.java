import java.io.*;

class Student {
    int rollNumber;
    String name;
    double gpa;

    public Student(int rollNumber, String name, double gpa) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.gpa = gpa;
    }
}

public class StudentDataHandler {
    public static void main(String[] args) {
        String dataFile = "students.dat";

       
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(dataFile))) {
            dos.writeInt(101);
            dos.writeUTF("Alice");
            dos.writeDouble(3.8);

            dos.writeInt(102);
            dos.writeUTF("Bob");
            dos.writeDouble(3.6);

            dos.writeInt(103);
            dos.writeUTF("Charlie");
            dos.writeDouble(3.9);

            System.out.println("Student data stored successfully in binary file.");
        } catch (IOException e) {
            System.out.println("Error: Unable to write student data.");
            e.printStackTrace();
        }

      
        try (DataInputStream dis = new DataInputStream(new FileInputStream(dataFile))) {
            System.out.println("Retrieved Student Data:");
            while (dis.available() > 0) {
                int rollNumber = dis.readInt();
                String name = dis.readUTF();
                double gpa = dis.readDouble();
                System.out.println("Roll Number: " + rollNumber + ", Name: " + name + ", GPA: " + gpa);
            }
        } catch (IOException e) {
            System.out.println("Error: Unable to read student data.");
            e.printStackTrace();
        }
    }
}
