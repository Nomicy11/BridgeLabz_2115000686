class Book3 {
    public String ISBN;
    protected String title;
    private String author;

    public Book3(String ISBN, String title, String author) {
        this.ISBN = ISBN;
        this.title = title;
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void displayBookDetails() {
        System.out.println("ISBN: " + ISBN);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
    }
}

class EBook extends Book3 {
    private double fileSize;

    public EBook(String ISBN, String title, String author, double fileSize) {
        super(ISBN, title, author);
        this.fileSize = fileSize;
    }

    public void displayEBookDetails() {
        System.out.println("E-Book Details:");
        System.out.println("ISBN: " + ISBN);
        System.out.println("Title: " + title);
        System.out.println("File Size: " + fileSize + " MB");
    }

    public static void main(String[] args) {
        Book3 book = new Book3("123-456-789", "Java Programming", "John Doe");
        book.displayBookDetails();
        book.setAuthor("Jane Doe");
        System.out.println("Updated Author: " + book.getAuthor());

        EBook ebook = new EBook("987-654-321", "Python Basics", "Alice Smith", 2.5);
        ebook.displayEBookDetails();
    }
}
