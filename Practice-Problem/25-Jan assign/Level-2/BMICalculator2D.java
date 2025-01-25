import java.util.Scanner;

public class BMICalculator2D {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of persons: ");
        int numberOfPersons = sc.nextInt();

        double[][] personData = new double[numberOfPersons][3]; // 0: height, 1: weight, 2: BMI
        String[] weightStatus = new String[numberOfPersons];

        for (int i = 0; i < numberOfPersons; i++) {
            System.out.println("Enter height (in meters) of person " + (i + 1) + ": ");
            double height = sc.nextDouble();
            while (height <= 0) {
                System.out.println("Height must be positive. Please enter again: ");
                height = sc.nextDouble();
            }
            personData[i][0] = height;

            System.out.println("Enter weight (in kilograms) of person " + (i + 1) + ": ");
            double weight = sc.nextDouble();
            while (weight <= 0) {
                System.out.println("Weight must be positive. Please enter again: ");
                weight = sc.nextDouble();
            }
            personData[i][1] = weight;

            personData[i][2] = weight / (height * height); // Calculate BMI
            weightStatus[i] = getWeightStatus(personData[i][2]); // Determine weight status
        }

        System.out.println("\nResults:");
        System.out.println("Height    Weight    BMI       Status");
        for (int i = 0; i < numberOfPersons; i++) {
            System.out.println(personData[i][0] + "       " + personData[i][1] + "       " + personData[i][2] + "       " + weightStatus[i]);
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
