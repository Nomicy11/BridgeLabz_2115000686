import java.util.Scanner;

class Book {
    public String title;
    public String author;
    public double price;

   
    public Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    
    public void displayDetails() {
        System.out.println("Book Details:");
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Price: " + price);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
      
        System.out.print("Enter Book Title: ");
        String title = sc.nextLine();
        
        System.out.print("Enter Book Author: ");
        String author = sc.nextLine();
        
        System.out.print("Enter Book Price: ");
        double price = sc.nextDouble();
        

        Book book = new Book(title, author, price);
        
      
        book.displayDetails();
        
   
    }
}
