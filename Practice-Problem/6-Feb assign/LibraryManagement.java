//Single Inheritance
class Book {
    public String title;
    public int publicationYear;

    public Book(String title, int publicationYear) {
        this.title = title;
        this.publicationYear = publicationYear;
    }

   
    public void displayInfo() {
        System.out.println("Book Title: " + title);
        System.out.println("Publication Year: " + publicationYear);
    }
}


class Author extends Book {
    private String name;
    private String bio;

    public Author(String title, int publicationYear, String name, String bio) {
        super(title, publicationYear);
        this.name = name;
        this.bio = bio;
    }

    
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Author: " + name);
        System.out.println("Bio: " + bio);
    }
}


public class LibraryManagement {
    public static void main(String[] args) {
        
        Author author = new Author("The Great Gatsby", 1925, "F. Scott Fitzgerald", 
                                   "An American novelist widely known for The Great Gatsby.");

 
        author.displayInfo();
    }
}
