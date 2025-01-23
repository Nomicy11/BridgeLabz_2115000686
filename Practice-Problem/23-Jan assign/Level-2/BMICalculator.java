import java.util.Scanner;

public class BMICalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter weight in kilograms: ");
        double weight = sc.nextDouble();
        
        System.out.print("Enter height in centimeters: ");
        double heightInCm = sc.nextDouble();
        
        double heightInM = heightInCm / 100;
        
        double bmi = weight / (heightInM * heightInM);
        
        System.out.printf("Your BMI is: %.2f\n", bmi);
        
        if (bmi < 18.5) {
            System.out.println("Underweight");
        } else if (bmi >= 18.5 && bmi < 24.9) {
            System.out.println("Normal weight");
        } else if (bmi >= 25 && bmi <= 39.9) {
            System.out.println("Overweight");
        } else if (bmi >= 40) {
            System.out.println("Obese");
        }
        
        
    }
}
