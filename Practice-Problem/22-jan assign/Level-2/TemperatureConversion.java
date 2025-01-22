import java.util.Scanner;

public class TemperatureConversion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double temperatureInCelsius = scanner.nextDouble();
        double temperatureInFahrenheit = (temperatureInCelsius * 9 / 5) + 32;
        System.out.println("The " + temperatureInCelsius + " Celsius is " + temperatureInFahrenheit + " Fahrenheit.");

    }
}