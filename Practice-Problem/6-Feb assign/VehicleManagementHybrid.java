//Hybrid Inheritance
class Vehicle {
    protected String model;
    protected int maxSpeed;

    public Vehicle(String model, int maxSpeed) {
        this.model = model;
        this.maxSpeed = maxSpeed;
    }

   
    public void displayDetails() {
        System.out.println("Model: " + model);
        System.out.println("Max Speed: " + maxSpeed + " km/h");
    }
}


interface Refuelable {
    void refuel(); 
}


class ElectricVehicle extends Vehicle {
    private int batteryCapacity; // in kWh

    public ElectricVehicle(String model, int maxSpeed, int batteryCapacity) {
        super(model, maxSpeed);
        this.batteryCapacity = batteryCapacity;
    }

    public void charge() {
        System.out.println(model + " is charging. Battery Capacity: " + batteryCapacity + " kWh");
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Battery Capacity: " + batteryCapacity + " kWh");
    }
}


class PetrolVehicle extends Vehicle implements Refuelable {
    private int fuelCapacity; // in liters

    public PetrolVehicle(String model, int maxSpeed, int fuelCapacity) {
        super(model, maxSpeed);
        this.fuelCapacity = fuelCapacity;
    }


    public void refuel() {
        System.out.println(model + " is refueling. Fuel Capacity: " + fuelCapacity + " liters.");
    }

   
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Fuel Capacity: " + fuelCapacity + " liters");
    }
}

public class VehicleManagementHybrid {
    public static void main(String[] args) {
       
        ElectricVehicle ev = new ElectricVehicle("Tesla Model S", 250, 100);
        ev.displayDetails();
        ev.charge();
        System.out.println("------------------------------------------");

        
        PetrolVehicle pv = new PetrolVehicle("Ford Mustang", 240, 60);
        pv.displayDetails();
        pv.refuel();
    }
}
