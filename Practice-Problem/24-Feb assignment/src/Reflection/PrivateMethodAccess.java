package Reflection;

import java.lang.reflect.Method;

class Calculator {
    private int multiply(int a, int b) {
        return a * b;
    }
}

public class PrivateMethodAccess {
    public static void main(String[] args) throws Exception {
        Calculator calculator = new Calculator();
        Class<?> cls = calculator.getClass();

        Method method = cls.getDeclaredMethod("multiply", int.class, int.class);
        method.setAccessible(true);

        int result = (int) method.invoke(calculator, 5, 10);
        System.out.println("Multiplication Result: " + result);
    }
}
