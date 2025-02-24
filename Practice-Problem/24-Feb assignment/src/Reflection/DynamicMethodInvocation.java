package Reflection;

import java.lang.reflect.Method;
import java.util.Scanner;

class MathOperations {
    public int add(int a, int b) { return a + b; }
    public int subtract(int a, int b) { return a - b; }
    public int multiply(int a, int b) { return a * b; }
}

public class DynamicMethodInvocation {
    public static void main(String[] args) throws Exception {
        MathOperations obj = new MathOperations();
        Class<?> cls = obj.getClass();

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter method name (add, subtract, multiply): ");
        String methodName = scanner.nextLine();

        Method method = cls.getMethod(methodName, int.class, int.class);
        int result = (int) method.invoke(obj, 5, 3);
        System.out.println("Result: " + result);
    }
}
