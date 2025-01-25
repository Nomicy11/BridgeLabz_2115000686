import java.util.Scanner;

public class BMICalculator {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of persons: ");
        int numPersons = sc.nextInt();

        double[] heights = new double[numPersons];
        double[] weights = new double[numPersons];
        double[] bmis = new double[numPersons];
        String[] statuses = new String[numPersons];

        for (int i = 0; i < numPersons; i++) {
            System.out.println("Enter height (in meters) of person " + (i + 1) + ": ");
            heights[i] = sc.nextDouble();

            System.out.println("Enter weight (in kilograms) of person " + (i + 1) + ": ");
            weights[i] = sc.nextDouble();
        }

        for (int i = 0; i < numPersons; i++) {
            bmis[i] = weights[i] / (heights[i] * heights[i]);
            statuses[i] = getWeightStatus(bmis[i]);
        }

        System.out.println("\nResults:");
        System.out.println("Height    Weight    BMI       Status");
        for (int i = 0; i < numPersons; i++) {
            System.out.println(heights[i] + "       " + weights[i] + "       " + bmis[i] + "       " + statuses[i]);
        }

    }

    public static String getWeightStatus(double bmi) {
        if (bmi < 18.5) {
            return "Underweight";
        } else if (bmi < 24.9) {
            return "Normal weight";
        } else if (bmi <= 39.9) {
            return "Overweight";
        } else {
            return "Obese";
        }
    }
}
