import java.util.Scanner;

class Book {
    String title, author, genre;
    int id;
    boolean available;
    Book next, prev;

    Book(int id, String title, String author, String genre, boolean available) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.available = available;
    }
}

class Library {
    private Book head, tail;
    private int count = 0;

    void addAtBeginning(int id, String title, String author, String genre, boolean available) {
        Book newBook = new Book(id, title, author, genre, available);
        if (head == null) {
            head = tail = newBook;
        } else {
            newBook.next = head;
            head.prev = newBook;
            head = newBook;
        }
        count++;
    }

    void addAtEnd(int id, String title, String author, String genre, boolean available) {
        Book newBook = new Book(id, title, author, genre, available);
        if (head == null) {
            head = tail = newBook;
        } else {
            tail.next = newBook;
            newBook.prev = tail;
            tail = newBook;
        }
        count++;
    }

    void addAtPosition(int id, String title, String author, String genre, boolean available, int position) {
        if (position <= 1) {
            addAtBeginning(id, title, author, genre, available);
            return;
        }
        if (position > count) {
            addAtEnd(id, title, author, genre, available);
            return;
        }
        Book newBook = new Book(id, title, author, genre, available);
        Book temp = head;
        for (int i = 1; i < position - 1 && temp.next != null; i++) {
            temp = temp.next;
        }
        newBook.next = temp.next;
        newBook.prev = temp;
        if (temp.next != null) temp.next.prev = newBook;
        temp.next = newBook;
        count++;
    }

    void removeBook(int id) {
        if (head == null) return;
        Book temp = head;
        while (temp != null && temp.id != id) {
            temp = temp.next;
        }
        if (temp == null) return; // Book not found

        if (temp == head) head = head.next;
        if (temp == tail) tail = tail.prev;
        if (temp.prev != null) temp.prev.next = temp.next;
        if (temp.next != null) temp.next.prev = temp.prev;
        count--;
    }

    Book searchByTitle(String title) {
        Book temp = head;
        while (temp != null) {
            if (temp.title.equalsIgnoreCase(title)) return temp;
            temp = temp.next;
        }
        return null;
    }

    Book searchByAuthor(String author) {
        Book temp = head;
        while (temp != null) {
            if (temp.author.equalsIgnoreCase(author)) return temp;
            temp = temp.next;
        }
        return null;
    }

    void updateAvailability(int id, boolean available) {
        Book temp = head;
        while (temp != null) {
            if (temp.id == id) {
                temp.available = available;
                return;
            }
            temp = temp.next;
        }
    }

    void displayBooksForward() {
        Book temp = head;
        while (temp != null) {
            System.out.println(temp.id + " | " + temp.title + " | " + temp.author + " | " +
                    temp.genre + " | Available: " + temp.available);
            temp = temp.next;
        }
    }

    void displayBooksReverse() {
        Book temp = tail;
        while (temp != null) {
            System.out.println(temp.id + " | " + temp.title + " | " + temp.author + " | " +
                    temp.genre + " | Available: " + temp.available);
            temp = temp.prev;
        }
    }

    int countBooks() {
        return count;
    }
}

public class LibraryManager {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner sc = new Scanner(System.in);

        library.addAtBeginning(101, "The XYZ", "QWX", "Fantasy", true);
        library.addAtEnd(102, "1984", "ABC", "Action", true);
        library.displayBooksForward();

        System.out.println("Total Books: " + library.countBooks());

        System.out.print("Enter Book ID to Remove: ");
        library.removeBook(sc.nextInt());
        library.displayBooksForward();

        System.out.println("Displaying Books in Reverse Order:");
        library.displayBooksReverse();
    }
}
