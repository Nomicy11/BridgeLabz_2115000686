//MultiLevel Inheritance

class Order {
    public int orderId;
    public String orderDate;

    public Order(int orderId, String orderDate) {
        this.orderId = orderId;
        this.orderDate = orderDate;
    }

   
    public String getOrderStatus() {
        return "Order placed on " + orderDate;
    }

    public void displayOrderDetails() {
        System.out.println("Order ID: " + orderId);
        System.out.println("Order Date: " + orderDate);
        System.out.println("Status: " + getOrderStatus());
    }
}


class ShippedOrder extends Order {
    protected String trackingNumber;

    public ShippedOrder(int orderId, String orderDate, String trackingNumber) {
        super(orderId, orderDate);
        this.trackingNumber = trackingNumber;
    }

  
    public String getOrderStatus() {
        return "Order shipped with Tracking Number: " + trackingNumber;
    }

  
    public void displayOrderDetails() {
        super.displayOrderDetails();
        System.out.println("Tracking Number: " + trackingNumber);
    }
}

class DeliveredOrder extends ShippedOrder {
    private String deliveryDate;

    public DeliveredOrder(int orderId, String orderDate, String trackingNumber, String deliveryDate) {
        super(orderId, orderDate, trackingNumber);
        this.deliveryDate = deliveryDate;
    }

    public String getOrderStatus() {
        return "Order delivered on " + deliveryDate;
    }
	
    public void displayOrderDetails() {
        super.displayOrderDetails();
        System.out.println("Delivery Date: " + deliveryDate);
    }
}



public class OrderManagement {
    public static void main(String[] args) {
     
        Order order = new Order(101, "2024-02-01");
        order.displayOrderDetails();
        System.out.println("----------------------");

        
        ShippedOrder shippedOrder = new ShippedOrder(102, "2024-02-02", "TRACK12345");
        shippedOrder.displayOrderDetails();
        System.out.println("----------------------");

    
        DeliveredOrder deliveredOrder = new DeliveredOrder(103, "2024-02-03", "TRACK67890", "2024-02-05");
        deliveredOrder.displayOrderDetails();
    }
}
