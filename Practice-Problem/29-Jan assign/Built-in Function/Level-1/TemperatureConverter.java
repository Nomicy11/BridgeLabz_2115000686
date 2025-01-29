import java.util.Scanner;

public class TemperatureConverter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Temperature Converter");
        System.out.print("Enter the temperature value: ");
        double temperature = sc.nextDouble();
        
        System.out.print("Enter the unit (C for Celsius, F for Fahrenheit): ");
        char unit = sc.next().charAt(0);
        
        if (unit == 'C' || unit == 'c') {
            double fahrenheit = celsiusToFahrenheit(temperature);
            System.out.println(temperature + " Celsius = " + fahrenheit + " Fahrenheit");
        } else if (unit == 'F' || unit == 'f') {
            double celsius = fahrenheitToCelsius(temperature);
            System.out.println(temperature + " Fahrenheit = " + celsius + " Celsius");
        } else {
            System.out.println("Invalid unit. Please enter 'C' for Celsius or 'F' for Fahrenheit.");
        }
        
       
    }

    public static double celsiusToFahrenheit(double celsius) {
        return (celsius * 9/5) + 32;
    }

    public static double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5/9;
    }
}
