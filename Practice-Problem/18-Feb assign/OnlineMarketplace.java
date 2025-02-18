import java.util.ArrayList;
import java.util.List;


interface Category {
    String getCategoryName();
}


class BookCategory implements Category {
    @Override
    public String getCategoryName() {
        return "Books";
    }
}

class ClothingCategory implements Category {
    @Override
    public String getCategoryName() {
        return "Clothing";
    }
}

class GadgetCategory implements Category {
    @Override
    public String getCategoryName() {
        return "Gadgets";
    }
}


class Product<T extends Category> {
    private String name;
    private double price;
    private T category;

    public Product(String name, double price, T category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public T getCategory() {
        return category;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return name + " (" + category.getCategoryName() + ") - $" + price;
    }
}


class MarketplaceUtils {
    public static <T extends Product<?>> void applyDiscount(T product, double percentage) {
        double discountAmount = product.getPrice() * (percentage / 100);
        product.setPrice(product.getPrice() - discountAmount);
        System.out.println("Discount applied! New price of " + product.getName() + ": $" + product.getPrice());
    }
}

public class OnlineMarketplace {
    public static void main(String[] args) {

        BookCategory bookCategory = new BookCategory();
        ClothingCategory clothingCategory = new ClothingCategory();
        GadgetCategory gadgetCategory = new GadgetCategory();

   
        Product<BookCategory> book = new Product<>("Java Programming", 50.0, bookCategory);
        Product<ClothingCategory> shirt = new Product<>("T-Shirt", 25.0, clothingCategory);
        Product<GadgetCategory> phone = new Product<>("Smartphone", 699.99, gadgetCategory);

        
        List<Product<?>> catalog = new ArrayList<>();
        catalog.add(book);
        catalog.add(shirt);
        catalog.add(phone);

        
        System.out.println("Product Catalog:");
        for (Product<?> product : catalog) {
            System.out.println(product);
        }

        
        System.out.println("\nApplying Discounts:");
        MarketplaceUtils.applyDiscount(book, 10);
        MarketplaceUtils.applyDiscount(phone, 15);
        System.out.println("\nUpdated Product Catalog:");
        for (Product<?> product : catalog) {
            System.out.println(product);
        }
    }
}
