import java.util.*;

public class SimpleInterest {
    public static void main(String[] args) {
       
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the Principal amount: ");
        double principal = scanner.nextDouble();

       
        System.out.print("Enter the Rate of interest: ");
        double rate = scanner.nextDouble();

        System.out.print("Enter the Time period (in years): ");
        double time = scanner.nextDouble();

        double interest = (principal * rate * time) / 100;
        System.out.printf("The Simple Interest is: %.2f%n", interest);
    }
}
