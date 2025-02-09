import java.util.Scanner;

abstract class Product {
    private String productId;
    private String name;
    private double price;

    public Product(String productId, String name, double price) {
        this.productId = productId;
        this.name = name;
        this.price = price;
    }

    public String getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price < 0) {
            System.out.println("Invalid price. Setting to 0.");
            this.price = 0;
        } else {
            this.price = price;
        }
    }

    public abstract double calculateDiscount();

    public void displayDetails() {
        System.out.println("Product ID: " + productId);
        System.out.println("Name: " + name);
        System.out.println("Price: $" + price);
        System.out.println("Discount: $" + calculateDiscount());
    }
}

interface Taxable {
    double calculateTax();
    String getTaxDetails();
}

class Electronics extends Product implements Taxable {
    public Electronics(String productId, String name, double price) {
        super(productId, name, price);
    }

    @Override
    public double calculateDiscount() {
        return getPrice() * 0.10;
    }

    @Override
    public double calculateTax() {
        return getPrice() * 0.15;
    }

    @Override
    public String getTaxDetails() {
        return "Electronics Tax: 15%";
    }
}

class Clothing extends Product {
    public Clothing(String productId, String name, double price) {
        super(productId, name, price);
    }

    @Override
    public double calculateDiscount() {
        return getPrice() * 0.20;
    }
}

class Groceries extends Product implements Taxable {
    public Groceries(String productId, String name, double price) {
        super(productId, name, price);
    }

    @Override
    public double calculateDiscount() {
        return getPrice() * 0.05;
    }

    @Override
    public double calculateTax() {
        return getPrice() * 0.05;
    }

    @Override
    public String getTaxDetails() {
        return "Groceries Tax: 5%";
    }
}

public class ECommercePlatform {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Electronics Product details:");
        System.out.print("ID: ");
        String eId = scanner.next();
        System.out.print("Name: ");
        String eName = scanner.next();
        System.out.print("Price: ");
        double ePrice = scanner.nextDouble();
        Electronics electronics = new Electronics(eId, eName, ePrice);

        System.out.println("\nEnter Clothing Product details:");
        System.out.print("ID: ");
        String cId = scanner.next();
        System.out.print("Name: ");
        String cName = scanner.next();
        System.out.print("Price: ");
        double cPrice = scanner.nextDouble();
        Clothing clothing = new Clothing(cId, cName, cPrice);

        System.out.println("\nEnter Groceries Product details:");
        System.out.print("ID: ");
        String gId = scanner.next();
        System.out.print("Name: ");
        String gName = scanner.next();
        System.out.print("Price: ");
        double gPrice = scanner.nextDouble();
        Groceries groceries = new Groceries(gId, gName, gPrice);

        System.out.println("\nProduct Details:");
        calculateFinalPrice(electronics);
        calculateFinalPrice(clothing);
        calculateFinalPrice(groceries);

      
    }

    public static void calculateFinalPrice(Product product) {
        double finalPrice = product.getPrice() - product.calculateDiscount();
        if (product instanceof Taxable) {
            finalPrice += ((Taxable) product).calculateTax();
            System.out.println(((Taxable) product).getTaxDetails());
        }
        product.displayDetails();
        System.out.println("Final Price after Tax & Discount: $" + finalPrice);
        System.out.println("----------------------------");
    }
}
