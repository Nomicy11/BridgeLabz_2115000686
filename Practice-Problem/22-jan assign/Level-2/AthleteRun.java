import java.util.Scanner;

public class AthleteRun {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        double side1 = scanner.nextDouble();
        double side2 = scanner.nextDouble();
        double side3 = scanner.nextDouble();
        
        double perimeter = side1 + side2 + side3;
        double distanceToRun = 5000;
        double rounds = distanceToRun / perimeter;
        
        System.out.println("The total number of rounds the athlete will run is " + rounds);
    }
}
