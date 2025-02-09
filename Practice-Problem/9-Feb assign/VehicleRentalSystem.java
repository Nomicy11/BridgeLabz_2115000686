import java.util.Scanner;

abstract class Vehicle {
    private String vehicleNumber;
    private String type;
    private double rentalRate;

    public Vehicle(String vehicleNumber, String type, double rentalRate) {
        this.vehicleNumber = vehicleNumber;
        this.type = type;
        this.rentalRate = rentalRate;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public String getType() {
        return type;
    }

    public double getRentalRate() {
        return rentalRate;
    }

    public void setRentalRate(double rentalRate) {
        if (rentalRate < 0) {
            System.out.println("Invalid rental rate. Setting to 0.");
            this.rentalRate = 0;
        } else {
            this.rentalRate = rentalRate;
        }
    }

    public abstract double calculateRentalCost(int days);

    public void displayDetails() {
        System.out.println("Vehicle Number: " + vehicleNumber);
        System.out.println("Type: " + type);
        System.out.println("Rental Rate per Day: $" + rentalRate);
    }
}

interface Insurable {
    double calculateInsurance();
    String getInsuranceDetails();
}

class Car extends Vehicle implements Insurable {
    private String insurancePolicyNumber;

    public Car(String vehicleNumber, double rentalRate, String insurancePolicyNumber) {
        super(vehicleNumber, "Car", rentalRate);
        this.insurancePolicyNumber = insurancePolicyNumber;
    }

    @Override
    public double calculateRentalCost(int days) {
        return getRentalRate() * days;
    }

    @Override
    public double calculateInsurance() {
        return getRentalRate() * 0.10;
    }

    @Override
    public String getInsuranceDetails() {
        return "Car Insurance Policy: " + insurancePolicyNumber;
    }
}

class Bike extends Vehicle {
    public Bike(String vehicleNumber, double rentalRate) {
        super(vehicleNumber, "Bike", rentalRate);
    }

    @Override
    public double calculateRentalCost(int days) {
        return getRentalRate() * days * 0.90;
    }
}

class Truck extends Vehicle implements Insurable {
    private String insurancePolicyNumber;

    public Truck(String vehicleNumber, double rentalRate, String insurancePolicyNumber) {
        super(vehicleNumber, "Truck", rentalRate);
        this.insurancePolicyNumber = insurancePolicyNumber;
    }

    @Override
    public double calculateRentalCost(int days) {
        return getRentalRate() * days * 1.20;
    }

    @Override
    public double calculateInsurance() {
        return getRentalRate() * 0.15;
    }

    @Override
    public String getInsuranceDetails() {
        return "Truck Insurance Policy: " + insurancePolicyNumber;
    }
}

public class VehicleRentalSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Car details:");
        System.out.print("Vehicle Number: ");
        String carNumber = scanner.next();
        System.out.print("Rental Rate per Day: ");
        double carRate = scanner.nextDouble();
        System.out.print("Insurance Policy Number: ");
        String carInsurance = scanner.next();
        Car car = new Car(carNumber, carRate, carInsurance);

        System.out.println("\nEnter Bike details:");
        System.out.print("Vehicle Number: ");
        String bikeNumber = scanner.next();
        System.out.print("Rental Rate per Day: ");
        double bikeRate = scanner.nextDouble();
        Bike bike = new Bike(bikeNumber, bikeRate);

        System.out.println("\nEnter Truck details:");
        System.out.print("Vehicle Number: ");
        String truckNumber = scanner.next();
        System.out.print("Rental Rate per Day: ");
        double truckRate = scanner.nextDouble();
        System.out.print("Insurance Policy Number: ");
        String truckInsurance = scanner.next();
        Truck truck = new Truck(truckNumber, truckRate, truckInsurance);

        System.out.print("\nEnter rental days: ");
        int days = scanner.nextInt();

        System.out.println("\nRental Details:");
        calculateFinalCost(car, days);
        calculateFinalCost(bike, days);
        calculateFinalCost(truck, days);

    }

    public static void calculateFinalCost(Vehicle vehicle, int days) {
        double rentalCost = vehicle.calculateRentalCost(days);
        double totalCost = rentalCost;

        if (vehicle instanceof Insurable) {
            totalCost += ((Insurable) vehicle).calculateInsurance();
            System.out.println(((Insurable) vehicle).getInsuranceDetails());
        }

        vehicle.displayDetails();
        System.out.println("Rental Cost for " + days + " days: $" + rentalCost);
        System.out.println("Total Cost (Including Insurance, if applicable): $" + totalCost);
        System.out.println("----------------------------");
    }
}
