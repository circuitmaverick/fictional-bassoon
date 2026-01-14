import java.util.ArrayList;
import java.util.Scanner;

class Book {
    private String title, author;
    private long ISBN;

    public void input(Scanner reader) {
        System.out.print("Title: ");
        title = reader.nextLine();
        System.out.print("Author: ");
        author = reader.nextLine();
        System.out.print("ISBN: ");
        ISBN = reader.nextLong();
    }

    public void display() {
        System.out.println("---- BOOK ----");
        System.out.println("Title: "+title);
        System.out.println("Author: "+author);
        System.out.println("ISBN: "+ISBN);
    }

    public long getISBN() {
        return ISBN;
    }

}

class Collection {
    ArrayList<Book> books = new ArrayList<Book>();

    public void add(Book book) {
        books.add(book);
    }

    public void remove(Book book) {
        books.remove(book);
    }

    public void remove(long ISBN) {
        for (Book book: books)
            if (book.getISBN() == ISBN) books.remove(book);
    }

    public void displayBooks() {
        for (Book book : books) {
            book.display();
        }
    }
}

public class Driver {
    public static void main(String[] args) {
        Collection colc = new Collection();
        Scanner sc = new Scanner(System.in);
        while(true) {
            System.out.println("Enter details of the book ---- ");
            Book b = new Book();
            b.input(sc);
            colc.add(b);
            System.out.println("Book added to the collection...");
            System.out.println("Enter y to add more book, anything else to stop adding books...");
            System.out.print(">\t");
            char c = sc.next().charAt(0); sc.nextLine();
            if (c != 'y' & c != 'Y') break;
        }
        while (true) {
            System.out.println("Enter...\n1\tto remove any book\n2\tto display all books\nany other key to exit...");
            System.out.print(">\t");
            int c = sc.nextInt();
            switch (c) {
                case 1:
                    System.out.print("Enter the ISBN: ");
                    long ISBN = sc.nextLong();
                    colc.remove(ISBN);
                    break;
                case 2:
                    colc.displayBooks();
                    break;
                default:
                    sc.close();
                    return;
            }
        }

    }
}
