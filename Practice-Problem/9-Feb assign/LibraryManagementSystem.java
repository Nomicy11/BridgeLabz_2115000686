import java.util.Scanner;

abstract class LibraryItem {
    private String itemId;
    private String title;
    private String author;
    private boolean isAvailable = true;

    public LibraryItem(String itemId, String title, String author) {
        this.itemId = itemId;
        this.title = title;
        this.author = author;
    }

    public String getItemId() {
        return itemId;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailability(boolean availability) {
        this.isAvailable = availability;
    }

    public abstract int getLoanDuration();

    public void getItemDetails() {
        System.out.println("Item ID: " + itemId);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Loan Duration: " + getLoanDuration() + " days");
        System.out.println("Availability: " + (isAvailable ? "Available" : "Reserved"));
    }
}

interface Reservable {
    void reserveItem();
    boolean checkAvailability();
}

class Book extends LibraryItem implements Reservable {
    public Book(String itemId, String title, String author) {
        super(itemId, title, author);
    }

    @Override
    public int getLoanDuration() {
        return 14; // Books can be borrowed for 14 days
    }

    @Override
    public void reserveItem() {
        if (checkAvailability()) {
            setAvailability(false);
            System.out.println("Book '" + getTitle() + "' has been reserved.");
        } else {
            System.out.println("Book '" + getTitle() + "' is not available for reservation.");
        }
    }

    @Override
    public boolean checkAvailability() {
        return isAvailable();
    }
}

class Magazine extends LibraryItem {
    public Magazine(String itemId, String title, String author) {
        super(itemId, title, author);
    }

    @Override
    public int getLoanDuration() {
        return 7; // Magazines can be borrowed for 7 days
    }
}

class DVD extends LibraryItem implements Reservable {
    public DVD(String itemId, String title, String author) {
        super(itemId, title, author);
    }

    @Override
    public int getLoanDuration() {
        return 5; // DVDs can be borrowed for 5 days
    }

    @Override
    public void reserveItem() {
        if (checkAvailability()) {
            setAvailability(false);
            System.out.println("DVD '" + getTitle() + "' has been reserved.");
        } else {
            System.out.println("DVD '" + getTitle() + "' is not available for reservation.");
        }
    }

    @Override
    public boolean checkAvailability() {
        return isAvailable();
    }
}

public class LibraryManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Creating a Book
        System.out.println("Enter Book details:");
        System.out.print("Item ID: ");
        String bookId = scanner.next();
        System.out.print("Title: ");
        String bookTitle = scanner.next();
        System.out.print("Author: ");
        String bookAuthor = scanner.next();
        Book book = new Book(bookId, bookTitle, bookAuthor);

        // Creating a Magazine
        System.out.println("\nEnter Magazine details:");
        System.out.print("Item ID: ");
        String magId = scanner.next();
        System.out.print("Title: ");
        String magTitle = scanner.next();
        System.out.print("Author: ");
        String magAuthor = scanner.next();
        Magazine magazine = new Magazine(magId, magTitle, magAuthor);

        // Creating a DVD
        System.out.println("\nEnter DVD details:");
        System.out.print("Item ID: ");
        String dvdId = scanner.next();
        System.out.print("Title: ");
        String dvdTitle = scanner.next();
        System.out.print("Author: ");
        String dvdAuthor = scanner.next();
        DVD dvd = new DVD(dvdId, dvdTitle, dvdAuthor);

        System.out.println("\nProcessing Library Items...");
        processLibraryItem(book);
        processLibraryItem(magazine);
        processLibraryItem(dvd);

        System.out.println("\nReserving the Book and DVD...");
        book.reserveItem();
        dvd.reserveItem();

        System.out.println("\nProcessing Library Items After Reservation...");
        processLibraryItem(book);
        processLibraryItem(dvd);

      
    }

    public static void processLibraryItem(LibraryItem item) {
        item.getItemDetails();
        System.out.println("----------------------------");
    }
}