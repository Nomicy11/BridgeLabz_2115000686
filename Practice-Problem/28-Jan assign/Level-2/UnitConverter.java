public class UnitConverter {

    public static void main(String[] args) {
        double km = 5.0;
        double miles = convertKmToMiles(km);
        System.out.println(km + " kilometers is " + miles + " miles.");

        double milesValue = 3.0;
        double kmValue = convertMilesToKm(milesValue);
        System.out.println(milesValue + " miles is " + kmValue + " kilometers.");

        double meters = 10.0;
        double feet = convertMetersToFeet(meters);
        System.out.println(meters + " meters is " + feet + " feet.");

        double feetValue = 15.0;
        double metersValue = convertFeetToMeters(feetValue);
        System.out.println(feetValue + " feet is " + metersValue + " meters.");
    }

    public static double convertKmToMiles(double km) {
        return km * 0.621371;
    }

    public static double convertMilesToKm(double miles) {
        return miles * 1.60934;
    }

    public static double convertMetersToFeet(double meters) {
        return meters * 3.28084;
    }

    public static double convertFeetToMeters(double feet) {
        return feet * 0.3048;
    }
}
