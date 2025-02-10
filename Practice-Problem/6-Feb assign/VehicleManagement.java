
class Vehicle {
    public int maxSpeed;
    public String fuelType;

    public Vehicle(int maxSpeed, String fuelType) {
        this.maxSpeed = maxSpeed;
        this.fuelType = fuelType;
    }

   
    public void displayInfo() {
        System.out.println("Max Speed: " + maxSpeed + " km/h, \nFuel Type: " + fuelType);
    }
}


class Car extends Vehicle {
    private int seatCapacity;

    public Car(int maxSpeed, String fuelType, int seatCapacity) {
        super(maxSpeed, fuelType);
        this.seatCapacity = seatCapacity;
    }

    public void displayInfo() {
        super.displayInfo();
        System.out.println("Max Speed: "+maxSpeed+" \nFuel Type: "+fuelType+ " \nVehicle Type: Car\ \nSeat Capacity: " + seatCapacity);
    }
}


class Truck extends Vehicle {
    private double loadCapacity; 

    public Truck(int maxSpeed, String fuelType, double loadCapacity) {
        super(maxSpeed, fuelType);
        this.loadCapacity = loadCapacity;
    }

 
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Max Speed: "+maxSpeed+" \nFuel Type: "+fuelType+ "\nVehicle Type: Truck \nLoad Capacity: " + loadCapacity + " tons");
    }
}


class Motorcycle extends Vehicle {
    private boolean hasSideCar;

    public Motorcycle(int maxSpeed, String fuelType, boolean hasSideCar) {
        super(maxSpeed, fuelType);
        this.hasSideCar = hasSideCar;
    }

    public void displayInfo() {
        super.displayInfo();
        System.out.println("Max Speed: "+maxSpeed+" \nFuel Type: "+fuelType+ "\nVehicle Type: Motorcycle \nHas Sidecar: " + (hasSideCar ? "Yes" : "No"));
    }
}


public class VehicleManagement {
    public static void main(String[] args) {
       
        Vehicle[] vehicles = {
            new Car(200, "Petrol", 5),
            new Truck(120, "Diesel", 15.5),
            new Motorcycle(180, "Petrol", false)
        };


        for (Vehicle v : vehicles) {
            v.displayInfo();
            System.out.println("------------------------------------------------------------");
        }
    }
}
