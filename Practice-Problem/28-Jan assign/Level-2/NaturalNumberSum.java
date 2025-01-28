import java.util.Scanner;

public class NaturalNumberSum {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a positive natural number (n): ");
        int n = sc.nextInt();

        if (n <= 0) {
            System.out.println("Error: Please enter a positive natural number.");
            return;
        }

        int sumRecursive = sumUsingRecursion(n);
        int sumFormula = sumUsingFormula(n);

        System.out.println("Sum of first " + n + " natural numbers using recursion: " + sumRecursive);
        System.out.println("Sum of first " + n + " natural numbers using formula: " + sumFormula);

        if (sumRecursive == sumFormula) {
            System.out.println("Both methods produce the same result. Calculation is correct!");
        } else {
            System.out.println("The results from the two methods do not match. There is an error.");
        }
    }

    public static int sumUsingRecursion(int n) {
        if (n == 1) {
            return 1;
        }
        return n + sumUsingRecursion(n - 1);
    }

    public static int sumUsingFormula(int n) {
        return n * (n + 1) / 2;
    }
}
