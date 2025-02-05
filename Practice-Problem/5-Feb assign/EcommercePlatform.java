import java.util.List;

class Product {
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
        System.out.println("Product " + this.name + " created with price: $" + this.price);
    }

    public String getName() {
        return this.name;
    }

    public double getPrice() {
        return this.price;
    }
}

class Customer {
    private String name;

    public Customer(String name) {
        this.name = name;
        System.out.println("Customer " + this.name + " created.");
    }

    public void placeOrder(Order order) {
        System.out.println("Customer " + this.name + " is placing an order.");
        order.processOrder(this);
    }

    public String getName() {
        return this.name;
    }
}

class Order {
    private List<Product> products;

    public Order(List<Product> products) {
        this.products = products;
    }

    public void processOrder(Customer customer) {
        System.out.println("Processing order for Customer " + customer.getName());
        displayOrderDetails();
    }

    private void displayOrderDetails() {
        double totalAmount = 0;
        System.out.println("Order details:");
        for (Product product : products) {
            System.out.println("- " + product.getName() + " : $" + product.getPrice());
            totalAmount += product.getPrice();
        }
        System.out.println("Total amount: $" + totalAmount);
    }
}

public class EcommercePlatform {
    public static void main(String[] args) {
        Product product1 = new Product("Laptop", 799.99);
        Product product2 = new Product("Smartphone", 599.99);
        Product product3 = new Product("Headphones", 129.99);

        Customer customer1 = new Customer("Alice");

        Order order1 = new Order(List.of(product1, product2));
        Order order2 = new Order(List.of(product2, product3));

        customer1.placeOrder(order1);
        customer1.placeOrder(order2);
    }
}
