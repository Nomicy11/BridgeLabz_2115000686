import java.util.Scanner;

public class TrigonometricFunctions {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the angle in degrees: ");
        double angle = sc.nextDouble();

        double[] results = calculateTrigonometricFunctions(angle);
        System.out.printf("Sine of %.2f: %.4f%n", angle, results[0]);
        System.out.printf("Cosine of %.2f: %.4f%n", angle, results[1]);
        System.out.printf("Tangent of %.2f: %.4f%n", angle, results[2]);
    }

    public static double[] calculateTrigonometricFunctions(double angle) {
        double radians = Math.toRadians(angle);
        double sine = Math.sin(radians);
        double cosine = Math.cos(radians);
        double tangent = Math.tan(radians);

        return new double[]{sine, cosine, tangent};
    }
}
