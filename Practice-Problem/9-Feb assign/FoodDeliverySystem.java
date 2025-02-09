import java.util.Scanner;

abstract class FoodItem {
    private String itemName;
    private double price;
    private int quantity;

    public FoodItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    public String getItemName() {
        return itemName;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public abstract double calculateTotalPrice();

    public void getItemDetails() {
        System.out.println("Item: " + itemName);
        System.out.println("Price per unit: $" + price);
        System.out.println("Quantity: " + quantity);
        System.out.println("Total Price: $" + calculateTotalPrice());
    }
}

interface Discountable {
    void applyDiscount(double percentage);
    void getDiscountDetails();
}

class VegItem extends FoodItem implements Discountable {
    public VegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }

    @Override
    public double calculateTotalPrice() {
        return getPrice() * getQuantity();
    }

    @Override
    public void applyDiscount(double percentage) {
        double discountAmount = (calculateTotalPrice() * percentage) / 100;
        System.out.println("Discount applied: $" + discountAmount);
    }

    @Override
    public void getDiscountDetails() {
        System.out.println("Veg items get a 5% discount on orders above $10.");
    }
}

class NonVegItem extends FoodItem implements Discountable {
    private double nonVegCharge = 2.0; // Additional charge per item

    public NonVegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }

    @Override
    public double calculateTotalPrice() {
        return (getPrice() * getQuantity()) + (nonVegCharge * getQuantity());
    }

    @Override
    public void applyDiscount(double percentage) {
        double discountAmount = (calculateTotalPrice() * percentage) / 100;
        System.out.println("Discount applied: $" + discountAmount);
    }

    @Override
    public void getDiscountDetails() {
        System.out.println("Non-veg items get a 10% discount on orders above $20.");
    }
}

public class FoodDeliverySystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Creating a VegItem
        System.out.println("Enter Veg Item details:");
        System.out.print("Item Name: ");
        String vegName = scanner.next();
        System.out.print("Price: ");
        double vegPrice = scanner.nextDouble();
        System.out.print("Quantity: ");
        int vegQuantity = scanner.nextInt();
        VegItem vegItem = new VegItem(vegName, vegPrice, vegQuantity);

        // Creating a NonVegItem
        System.out.println("\nEnter Non-Veg Item details:");
        System.out.print("Item Name: ");
        String nonVegName = scanner.next();
        System.out.print("Price: ");
        double nonVegPrice = scanner.nextDouble();
        System.out.print("Quantity: ");
        int nonVegQuantity = scanner.nextInt();
        NonVegItem nonVegItem = new NonVegItem(nonVegName, nonVegPrice, nonVegQuantity);

        System.out.println("\nProcessing Order...");
        processOrder(vegItem);
        processOrder(nonVegItem);

        System.out.println("\nApplying Discounts...");
        if (vegItem.calculateTotalPrice() > 10) {
            vegItem.applyDiscount(5);
        }
        if (nonVegItem.calculateTotalPrice() > 20) {
            nonVegItem.applyDiscount(10);
        }

        scanner.close();
    }

    public static void processOrder(FoodItem item) {
        item.getItemDetails();
        System.out.println("----------------------------");
    }
}
