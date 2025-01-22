import java.util.Scanner;

public class TemperatureConversion2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double temperatureInFahrenheit = scanner.nextDouble();
        double temperatureInCelsius = (temperatureInFahrenheit - 32) * 5 / 9;
        System.out.println("The " + temperatureInFahrenheit + " Fahrenheit is " + temperatureInCelsius + " Celsius.");
    }
}
