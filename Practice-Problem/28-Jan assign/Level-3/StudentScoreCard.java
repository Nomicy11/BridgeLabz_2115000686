import java.util.Random;
import java.util.Scanner;

public class StudentScoreCard {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter the number of students: ");
        int numStudents = sc.nextInt();
        
        int[][] scores = generateRandomScores(numStudents);
        double[][] results = calculateResults(scores);
        
        displayScoreCard(scores, results);
    }

    static int[][] generateRandomScores(int numStudents) {
        Random random = new Random();
        int[][] scores = new int[numStudents][3];

        for (int i = 0; i < numStudents; i++) {
            scores[i][0] = 50 + random.nextInt(51); // Physics (50-100)
            scores[i][1] = 50 + random.nextInt(51); // Chemistry (50-100)
            scores[i][2] = 50 + random.nextInt(51); // Maths (50-100)
        }
        return scores;
    }

    static double[][] calculateResults(int[][] scores) {
        double[][] results = new double[scores.length][3];

        for (int i = 0; i < scores.length; i++) {
            int total = scores[i][0] + scores[i][1] + scores[i][2];
            double average = total / 3.0;
            double percentage = (total / 300.0) * 100;

            results[i][0] = total;
            results[i][1] = Math.round(average * 100.0) / 100.0; // Rounding to 2 decimal places
            results[i][2] = Math.round(percentage * 100.0) / 100.0; // Rounding to 2 decimal places
        }
        return results;
    }

    static void displayScoreCard(int[][] scores, double[][] results) {
        System.out.println("-----------------------------------------------------------");
        System.out.printf("%-5s %-8s %-8s %-8s %-8s %-8s %-8s\n", "ID", "Physics", "Chemistry", "Math", "Total", "Avg", "Percentage");
        System.out.println("-----------------------------------------------------------");

        for (int i = 0; i < scores.length; i++) {
            System.out.printf("%-5d %-8d %-8d %-8d %-8.2f %-8.2f %-8.2f\n",
                    (i + 1), scores[i][0], scores[i][1], scores[i][2],
                    results[i][0], results[i][1], results[i][2]);
        }
    }
}
