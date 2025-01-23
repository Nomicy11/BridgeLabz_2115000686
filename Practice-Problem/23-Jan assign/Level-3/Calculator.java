
import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the first number: ");
        double num1 = sc.nextDouble();

        System.out.print("Enter the operator (+, -, *, /): ");
        String op = sc.next();

        System.out.print("Enter the second number: ");
        double num2 = sc.nextDouble();

        double result = 0;
        boolean validOperator = true;

        switch (op) {
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "*":
                result = num1 * num2;
                break;
            case "/":
                if (num2 != 0) {
                    result = num1 / num2;
                } else {
                    System.out.println("Error: Division by zero is not allowed.");
                    validOperator = false;
                }
                break;
            default:
                System.out.println("Invalid Operator");
                validOperator = false;
        }

        if (validOperator) {
            System.out.println("The result is: " + result);
        }

  
    }
}

