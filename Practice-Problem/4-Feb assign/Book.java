class Book {
    private static String libraryName = "City Central Library"; 

    private final String isbn;  
    private String title;
    private String author;

 
    public Book(String isbn, String title, String author) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
    }


    public static void displayLibraryName() {
        System.out.println("Library Name: " + libraryName);
    }

    public void displayBookDetails() {
        System.out.println("\n--- Book Details ---");
        System.out.println("Library: " + libraryName);
        System.out.println("ISBN: " + isbn);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
    }

   
    public static void main(String[] args) {
     
        Book.displayLibraryName();

      
        Book book1 = new Book("978-0135166307", "Effective Java", "Joshua Bloch");
        Book book2 = new Book("978-1492078005", "Java Concurrency in Practice", "Brian Goetz");

      
        book1.displayBookDetails();
        book2.displayBookDetails();
    }
}
