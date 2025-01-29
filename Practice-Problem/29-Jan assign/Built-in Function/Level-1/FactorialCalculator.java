import java.util.Scanner;

public class FactorialCalculator {

    public static int getInput() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number to calculate its factorial: ");
        return sc.nextInt();
    }

    public static int calculateFactorial(int n) {
        if (n == 0) {
            return 1;
        } else {
            return n * calculateFactorial(n - 1);
        }
    }

    public static void displayOutput(int result) {
        System.out.println("The factorial is: " + result);
    }

    public static void main(String[] args) {
        int number = getInput();
        int factorial = calculateFactorial(number);
        displayOutput(factorial);
    }
}
