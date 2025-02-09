import java.util.Scanner;

abstract class Vehicle {
    private String vehicleId;
    private String driverName;
    private double ratePerKm;

    public Vehicle(String vehicleId, String driverName, double ratePerKm) {
        this.vehicleId = vehicleId;
        this.driverName = driverName;
        this.ratePerKm = ratePerKm;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public String getDriverName() {
        return driverName;
    }

    public double getRatePerKm() {
        return ratePerKm;
    }

    public abstract double calculateFare(double distance);

    public void getVehicleDetails() {
        System.out.println("Vehicle ID: " + vehicleId);
        System.out.println("Driver Name: " + driverName);
        System.out.println("Rate per Km: $" + ratePerKm);
    }
}

interface GPS {
    void getCurrentLocation();
    void updateLocation(String newLocation);
}

class Car extends Vehicle implements GPS {
    private String location;

    public Car(String vehicleId, String driverName, double ratePerKm, String location) {
        super(vehicleId, driverName, ratePerKm);
        this.location = location;
    }

    @Override
    public double calculateFare(double distance) {
        return distance * getRatePerKm();
    }

    @Override
    public void getCurrentLocation() {
        System.out.println("Car is currently at: " + location);
    }

    @Override
    public void updateLocation(String newLocation) {
        location = newLocation;
        System.out.println("Car location updated to: " + location);
    }
}

class Bike extends Vehicle implements GPS {
    private String location;

    public Bike(String vehicleId, String driverName, double ratePerKm, String location) {
        super(vehicleId, driverName, ratePerKm);
        this.location = location;
    }

    @Override
    public double calculateFare(double distance) {
        return distance * getRatePerKm();
    }

    @Override
    public void getCurrentLocation() {
        System.out.println("Bike is currently at: " + location);
    }

    @Override
    public void updateLocation(String newLocation) {
        location = newLocation;
        System.out.println("Bike location updated to: " + location);
    }
}

class Auto extends Vehicle implements GPS {
    private String location;

    public Auto(String vehicleId, String driverName, double ratePerKm, String location) {
        super(vehicleId, driverName, ratePerKm);
        this.location = location;
    }

    @Override
    public double calculateFare(double distance) {
        return distance * getRatePerKm();
    }

    @Override
    public void getCurrentLocation() {
        System.out.println("Auto is currently at: " + location);
    }

    @Override
    public void updateLocation(String newLocation) {
        location = newLocation;
        System.out.println("Auto location updated to: " + location);
    }
}

public class RideHailingApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Creating a Car
        System.out.println("Enter Car details:");
        System.out.print("Vehicle ID: ");
        String carId = scanner.next();
        System.out.print("Driver Name: ");
        String carDriver = scanner.next();
        System.out.print("Rate per Km: ");
        double carRate = scanner.nextDouble();
        System.out.print("Initial Location: ");
        String carLocation = scanner.next();
        Car car = new Car(carId, carDriver, carRate, carLocation);

        // Creating a Bike
        System.out.println("\nEnter Bike details:");
        System.out.print("Vehicle ID: ");
        String bikeId = scanner.next();
        System.out.print("Driver Name: ");
        String bikeDriver = scanner.next();
        System.out.print("Rate per Km: ");
        double bikeRate = scanner.nextDouble();
        System.out.print("Initial Location: ");
        String bikeLocation = scanner.next();
        Bike bike = new Bike(bikeId, bikeDriver, bikeRate, bikeLocation);

        // Creating an Auto
        System.out.println("\nEnter Auto details:");
        System.out.print("Vehicle ID: ");
        String autoId = scanner.next();
        System.out.print("Driver Name: ");
        String autoDriver = scanner.next();
        System.out.print("Rate per Km: ");
        double autoRate = scanner.nextDouble();
        System.out.print("Initial Location: ");
        String autoLocation = scanner.next();
        Auto auto = new Auto(autoId, autoDriver, autoRate, autoLocation);

        // Processing rides
        System.out.println("\nProcessing Ride Requests...");
        System.out.print("Enter distance for ride: ");
        double distance = scanner.nextDouble();

        processRide(car, distance);
        processRide(bike, distance);
        processRide(auto, distance);

        // Location updates
        System.out.println("\nUpdating Locations...");
        car.updateLocation("Downtown");
        bike.updateLocation("Suburbs");
        auto.updateLocation("Market Area");

        System.out.println("\nGetting Current Locations...");
        car.getCurrentLocation();
        bike.getCurrentLocation();
        auto.getCurrentLocation();


    }

    public static void processRide(Vehicle vehicle, double distance) {
        vehicle.getVehicleDetails();
        System.out.println("Estimated Fare: $" + vehicle.calculateFare(distance));
        System.out.println("----------------------------");
    }
}
