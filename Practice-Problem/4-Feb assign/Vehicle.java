class Vehicle {
    private static double registrationFee = 500.0;

    private final String registrationNumber;
    private String ownerName;
    private String vehicleType;

    public Vehicle(String registrationNumber, String ownerName, String vehicleType) {
        this.registrationNumber = registrationNumber;
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
    }

    public static void updateRegistrationFee(double newFee) {
        registrationFee = newFee;
    }

    public void displayVehicleDetails() {
        if (this instanceof Vehicle) {
            System.out.println("\n--- Vehicle Registration Details ---");
            System.out.println("Registration Number: " + registrationNumber);
            System.out.println("Owner Name: " + ownerName);
            System.out.println("Vehicle Type: " + vehicleType);
            System.out.println("Registration Fee: $" + registrationFee);
        }
    }

    public static void main(String[] args) {
        Vehicle v1 = new Vehicle("ABC123", "Nomicy", "Car");
        Vehicle v2 = new Vehicle("XYZ789", "Mashum", "Motorcycle");

        v1.displayVehicleDetails();
        v2.displayVehicleDetails();

        updateRegistrationFee(600.0);

        System.out.println("\nUpdated Registration Fee:");
        v1.displayVehicleDetails();
        v2.displayVehicleDetails();
    }
}
