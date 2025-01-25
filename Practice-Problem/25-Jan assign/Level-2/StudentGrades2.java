import java.util.*;

public class StudentGrade2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of students: ");
        int numberOfStudents = sc.nextInt();

        int[][] marks = new int[numberOfStudents][3];
        double[] percentages = new double[numberOfStudents];
        char[] grades = new char[numberOfStudents];

        for (int i = 0; i < numberOfStudents; i++) {
            System.out.println("\nEnter marks for Student " + (i + 1) + ":");

            for (int j = 0; j < 3; j++) {
                while (true) {
                    String subject = (j == 0) ? "Physics" : (j == 1) ? "Chemistry" : "Maths";
                    System.out.print("Enter marks for " + subject + " (0-100): ");
                    int mark = sc.nextInt();
                    if (mark >= 0 && mark <= 100) {
                        marks[i][j] = mark;
                        break;
                    }
                }
            }

            percentages[i] = (marks[i][0] + marks[i][1] + marks[i][2]) / 3.0;

            if (percentages[i] >= 80) {
                grades[i] = 'A';
            } else if (percentages[i] >= 70) {
                grades[i] = 'B';
            } else if (percentages[i] >= 60) {
                grades[i] = 'C';
            } else if (percentages[i] >= 50) {
                grades[i] = 'D';
            } else if (percentages[i] >= 40) {
                grades[i] = 'E';
            } else {
                grades[i] = 'R';
            }
        }

        System.out.println("\n--- Student Report ---");
        for (int i = 0; i < numberOfStudents; i++) {
            System.out.println("Student " + (i + 1) + ":");
            System.out.println("Physics: " + marks[i][0] + ", Chemistry: " + marks[i][1] + ", Maths: " + marks[i][2]);
            System.out.printf("Percentage: %.2f%%\n", percentages[i]);
            System.out.println("Grade: " + grades[i]);
            System.out.println();
        }

      
    }
}
