import java.util.Scanner;

public class WeightConversion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        double weightInPounds = scanner.nextDouble();
        double weightInKg = weightInPounds * 2.2;
        
        System.out.println("The weight of the person in pounds is " + weightInPounds + " and in kg is " + weightInKg);
    }
}
