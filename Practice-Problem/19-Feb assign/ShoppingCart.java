import java.util.*;

class ShoppingCart {
    private Map<String, Double> productPrices = new HashMap<>(); 
    private Map<String, Integer> cart = new LinkedHashMap<>(); 
    private TreeMap<String, Double> sortedByPrice = new TreeMap<>(Comparator.comparing(productPrices::get)); 

   
    public void addProduct(String product, double price) {
        productPrices.put(product, price);
    }

    
    public void addItem(String product) {
        if (!productPrices.containsKey(product)) {
            System.out.println("Product not found: " + product);
            return;
        }
        cart.put(product, cart.getOrDefault(product, 0) + 1);
        sortedByPrice.put(product, productPrices.get(product));
    }


    public void displayCart() {
        System.out.println("Cart (Order Added): " + cart);
    }

    
    public void displaySortedByPrice() {
        System.out.println("Products Sorted by Price: " + sortedByPrice);
    }

    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

      
        cart.addProduct("Apple", 1.5);
        cart.addProduct("Banana", 0.75);
        cart.addProduct("Orange", 2.0);

        
        cart.addItem("Banana");
        cart.addItem("Apple");
        cart.addItem("Orange");
        cart.addItem("Banana");

       
        cart.displayCart();
        cart.displaySortedByPrice();
    }
}
