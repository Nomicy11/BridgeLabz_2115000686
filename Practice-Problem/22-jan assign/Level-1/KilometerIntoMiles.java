import java.util.Scanner;

public class KilometerIntoMiles {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);

        
        double kilometers = scanner.nextDouble();

        double miles = kilometers * 1.6;

        System.out.println("The total miles is "+miles+" mile for the given "+kilometers+" km");
    }
}
