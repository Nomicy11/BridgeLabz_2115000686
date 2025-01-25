import java.util.*;

public class StudentGrades {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of students: ");
        int numberOfStudents = sc.nextInt();

        int[] physicsMarks = new int[numberOfStudents];
        int[] chemistryMarks = new int[numberOfStudents];
        int[] mathsMarks = new int[numberOfStudents];
        double[] percentages = new double[numberOfStudents];
        char[] grades = new char[numberOfStudents];

        for (int i = 0; i < numberOfStudents; i++) {
            System.out.println("\nEnter marks for Student " + (i + 1) + ":");

            int marks;
            while (true) {
                System.out.print("Enter marks for Physics (0-100): ");
                marks = sc.nextInt();
                if (marks >= 0 && marks <= 100) {
                    physicsMarks[i] = marks;
                    break;
                }
            }
            while (true) {
                System.out.print("Enter marks for Chemistry (0-100): ");
                marks = sc.nextInt();
                if (marks >= 0 && marks <= 100) {
                    chemistryMarks[i] = marks;
                    break;
                }
            }
            while (true) {
                System.out.print("Enter marks for Maths (0-100): ");
                marks = sc.nextInt();
                if (marks >= 0 && marks <= 100) {
                    mathsMarks[i] = marks;
                    break;
                }
            }

            percentages[i] = (physicsMarks[i] + chemistryMarks[i] + mathsMarks[i]) / 3.0;

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
            System.out.println("Physics: " + physicsMarks[i] + ", Chemistry: " + chemistryMarks[i] + ", Maths: " + mathsMarks[i]);
            System.out.printf("Percentage: %.2f%%\n", percentages[i]);
            System.out.println("Grade: " + grades[i]);
            System.out.println();
        }

    }
}
