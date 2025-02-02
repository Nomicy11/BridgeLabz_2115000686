public class Book2 {
    private String title;
    private String author;
    private double price;
    private boolean isAvailable;

   
    public Book2() {
        this.title = "Unknown Title";
        this.author = "Unknown Author";
        this.price = 0.0;
        this.isAvailable = true;
    }

   
    public Book2(String title, String author, double price, boolean isAvailable) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.isAvailable = isAvailable;
    }

    public Book2(Book2 other) {
        this.title = other.title;
        this.author = other.author;
        this.price = other.price;
        this.isAvailable = other.isAvailable;
    }


    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public double getPrice() {
        return price;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

  
    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setAvailability(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    
    public void borrowBook() {
        if (isAvailable) {
            isAvailable = false;
            System.out.println("You have borrowed the book: " + title);
        } else {
            System.out.println("Sorry, this book is currently unavailable.");
        }
    }

    
    public void displayBookInfo() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Price: $" + price);
        System.out.println("Available: " + (isAvailable ? "Yes" : "No"));
    }

    
    public static void main(String[] args) {
        Book2 book1 = new Book2("1984", "George Orwell", 9.99, true);
        book1.displayBookInfo();
        book1.borrowBook();
        book1.displayBookInfo();
    }
}
