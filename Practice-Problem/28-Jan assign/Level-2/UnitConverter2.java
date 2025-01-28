public class UnitConverter2 {

    public static void main(String[] args) {
        double fahrenheit = 98.6;
        double celsiusFromFahrenheit = convertFahrenheitToCelsius(fahrenheit);
        System.out.println(fahrenheit + "°F is " + celsiusFromFahrenheit + "°C.");

        double celsius = 37.0;
        double fahrenheitFromCelsius = convertCelsiusToFahrenheit(celsius);
        System.out.println(celsius + "°C is " + fahrenheitFromCelsius + "°F.");

        double pounds = 150.0;
        double kilogramsFromPounds = convertPoundsToKilograms(pounds);
        System.out.println(pounds + " pounds is " + kilogramsFromPounds + " kilograms.");

        double kilograms = 70.0;
        double poundsFromKilograms = convertKilogramsToPounds(kilograms);
        System.out.println(kilograms + " kilograms is " + poundsFromKilograms + " pounds.");

        double gallons = 10.0;
        double litersFromGallons = convertGallonsToLiters(gallons);
        System.out.println(gallons + " gallons is " + litersFromGallons + " liters.");

        double liters = 25.0;
        double gallonsFromLiters = convertLitersToGallons(liters);
        System.out.println(liters + " liters is " + gallonsFromLiters + " gallons.");
    }

    public static double convertFahrenheitToCelsius(double fahrenheit) {
        double fahrenheit2celsius = (fahrenheit - 32) * 5 / 9;
        return fahrenheit2celsius;
    }

    public static double convertCelsiusToFahrenheit(double celsius) {
        double celsius2fahrenheit = (celsius * 9 / 5) + 32;
        return celsius2fahrenheit;
    }

    public static double convertPoundsToKilograms(double pounds) {
        double pounds2kilograms = 0.453592;
        return pounds * pounds2kilograms;
    }

    public static double convertKilogramsToPounds(double kilograms) {
        double kilograms2pounds = 2.20462;
        return kilograms * kilograms2pounds;
    }

    public static double convertGallonsToLiters(double gallons) {
        double gallons2liters = 3.78541;
        return gallons * gallons2liters;
    }

    public static double convertLitersToGallons(double liters) {
        double liters2gallons = 0.264172;
        return liters * liters2gallons;
    }
}
