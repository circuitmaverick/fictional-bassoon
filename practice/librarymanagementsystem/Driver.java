import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

class Book {
    private long ISBN;
    private String name, author;

    public Book(long ISBN, String name, String author) {
        this.ISBN = ISBN;
        this.name = name;
        this.author = author;
    }

    public long getISBN() { return ISBN; }

    public void upload(Connection conn) {
        String insertQuery = "insert into books values(?,?,?)";

        try {
            // prepare the query
            PreparedStatement insertStatement = conn.prepareStatement(insertQuery);
            insertStatement.setLong(1, ISBN);
            insertStatement.setString(2, name);
            insertStatement.setString(3, author);
            // execute the query
            insertStatement.executeUpdate();
            // close the statement
            insertStatement.close();
        } catch (SQLException e) {
            System.out.println("AN SQL EXCEPTION OCCURED! <DATA INSERT-BOOKS>");
            System.out.println(e);
        }
    }
}

class BookCopy {
    private Book book;
    private long copyID;

    public BookCopy(Book book, long copyID) {
        this.book = book;
        this.copyID = copyID;
    }

    public void upload(Connection conn) {
        String insertQuery = "insert into library values(?,?,?)";

        try {
            // prepare the query
            PreparedStatement insertStatement = conn.prepareStatement(insertQuery);
            insertStatement.setLong(1, book.getISBN());
            insertStatement.setLong(2, copyID);
            insertStatement.setString(3, "TRUE");
            // execute the query
            insertStatement.executeUpdate();
            // close the statement
            insertStatement.close();
        } catch (SQLException e) {
            System.out.println("AN SQL EXCEPTION OCCURED! <DATA INSERT-BOOK COPY>");
            System.out.println(e);
        }
    }

    public static long getCopy(Connection conn, long ISBN) {
        String searchQuery = "select copyid from library where isbn=? and available=?";

        try {
            PreparedStatement searchStatement = conn.prepareStatement(searchQuery);
            searchStatement.setLong(1, ISBN);
            searchStatement.setString(2, "TRUE");

            ResultSet rs = searchStatement.executeQuery();

            if(!rs.next()) { System.out.println("NO COPIES AVAILABLE!"); return -1; }
            else return rs.getLong("copyid");

        } catch (SQLException e) {
            System.out.println("AN SQL EXCEPTION OCCURED! <DATA LOOKUP-BOOK COPY>");
            System.out.println(e);
        }

        return -1;
    }

    public static void updateStatus(Connection conn, long ISBN, long copyID, String status) {
        String updateStatusQuery = "update library set available=? where isbn=? and copyid=?";

        try {
            PreparedStatement updateStatusStatement = conn.prepareStatement(updateStatusQuery);
            updateStatusStatement.setString(1, status);
            updateStatusStatement.setLong(2, ISBN);
            updateStatusStatement.setLong(3, copyID);

            updateStatusStatement.executeUpdate();

            updateStatusStatement.close();
        } catch (SQLException e) {
            System.out.println("AN SQL EXCEPTION OCCURED! <DATA UPDATE-COPY STATUS>");
            System.out.println(e);
        }
    }
}

class Issue {
    private long ISBN, copyID;

    public Issue(long ISBN, long copyID) {
        this.ISBN = ISBN;
        this.copyID = copyID;
    }

    public void issueBook(Connection conn, String issueDate) {
        String issueQuery = "insert into issues values(?,?,?,to_date(?,'DD-MON-YYYY'),?)";

        try {
            PreparedStatement issueStatement = conn.prepareStatement(issueQuery);
            issueStatement.setLong(1, ISBN+copyID);
            issueStatement.setLong(2, ISBN);
            issueStatement.setLong(3, copyID);
            issueStatement.setString(4, issueDate);
            issueStatement.setNull(5, 0);

            issueStatement.executeUpdate();

            issueStatement.close();

            BookCopy.updateStatus(conn, ISBN, copyID, "FALSE");
        } catch (SQLException e) {
            System.out.println("AN SQL EXCEPTION OCCURED! <DATA INSERT-NEW ISSUE>");
            System.out.println(e);
        }
    }

    public void returnBook(Connection conn, String returnDate) {
        String returnQuery = "update issues set returndate=to_date(?,'DD-MON-YYYY') where isbn=? and copyid=?";

        try {
            PreparedStatement returnStatement = conn.prepareStatement(returnQuery);
            returnStatement.setString(1, returnDate);
            returnStatement.setLong(2, ISBN);
            returnStatement.setLong(3, copyID);

            returnStatement.executeUpdate();

            returnStatement.close();

            BookCopy.updateStatus(conn, ISBN, copyID, "TRUE");
        } catch (SQLException e) {
            System.out.println("AN SQL EXCEPTION OCCURED! <DATA INSERT-NEW ISSUE>");
            System.out.println(e);
        }
    }
}

class Library {
    private Connection conn;

    public Library(Connection conn) {
        this.conn = conn;

        /*

        INITIALIZATION

         */

        // create the library table in the database
        String createLibraryTableQuery = "create table library (isbn number(10,0), copyid number(10,0), available varchar2(5), primary key (isbn, copyid))";
        String createBooksTableQuery = "create table books (isbn number(10,0) primary key, name varchar2(20) not null, author varchar2(20) not null)";
        String createIssuesTableQuery = "create table issues (issueid number(10,0) primary key, isbn number(10,0) not null, copyid number(10,0) not null, issuedate date not null, returndate date)";

        // execute the query
        Statement createStatement = null;

        try {
            createStatement = conn.createStatement();
            createStatement.executeUpdate(createLibraryTableQuery);
            System.out.println("CREATED LIBRARY TABLE...");
            createStatement.executeUpdate(createBooksTableQuery);
            System.out.println("CREATED BOOKS TABLE...");
            createStatement.executeUpdate(createIssuesTableQuery);
            System.out.println("CREATED ISSUES TABLE...");
            if(createStatement != null) createStatement.close();
        } catch (SQLException e) {
            System.out.println("AN SQL EXCEPTION HAS OCCURED! <LIBRARY INITIALIZATION-TABLE CREATION>");
            System.out.println(e);
        }
    }

    public void addBook(Book book, ArrayList<BookCopy> copies) {
        // upload the book
        book.upload(conn);

        // upload the copies
        for(BookCopy copy: copies) copy.upload(conn);

        // show confirmation
        System.out.println("BOOK ADDED!");
    }

    public void delBook(long ISBN) {
        // delete the book and its copies
        String deleteBookQuery = "delete from books where isbn=?";
        String deleteCopiesQuery = "delete from library where isbn=?";

        try {
            // book
            PreparedStatement deleteStatement = conn.prepareStatement(deleteBookQuery);
            deleteStatement.setLong(1, ISBN);
            deleteStatement.executeUpdate();
            // copies
            deleteStatement = conn.prepareStatement(deleteCopiesQuery);
            deleteStatement.setLong(1, ISBN);
            deleteStatement.executeUpdate();
            // close the statement
            deleteStatement.close();
        } catch (SQLException e) {
            System.out.println("AN SQL EXCEPTION OCCURED! <DATA DELETE-BOOK AND COPIES>");
        } finally {
            System.out.println("BOOK DELETED!");
        }
    }

    public void close() {
        /*

        EXTERMINATION

        */

        // drop the table library
        String dropLibraryTableQuery = "drop table library";
        String dropBooksTableQuery = "drop table books";
        String dropIssuesTableQuery = "drop table issues";

        // execute the query
        Statement dropStatement = null;

        try {
            dropStatement = conn.createStatement();
            dropStatement.executeUpdate(dropLibraryTableQuery);
            System.out.println("DROPPED LIBRARY TABLE...");
            dropStatement.executeUpdate(dropBooksTableQuery);
            System.out.println("DROPPED BOOKS TABLE...");
            dropStatement.executeUpdate(dropIssuesTableQuery);
            System.out.println("DROPPED ISSUES TABLE...");
            if(dropStatement != null) dropStatement.close();
        } catch (SQLException e) {
            System.out.println("AN SQL EXCEPTION HAS OCCURED! <LIBRARY EXTERMINATION-TABLE DROPPING>");
            System.out.println(e);
        }
    }
}

public class Driver {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        final String url = "jdbc:oracle:thin:@//localhost:1521/FREEPDB1";

        final String username = "akash";
        final String password = "4k45h";

        Library library = null;

        Connection conn = null;

        try {
            Class.forName("oracle.jdbc.OracleDriver");

            // initiate connection
            conn = DriverManager.getConnection(url, username, password);

            // open the library
            library = new Library(conn);

            /*

            OPERATIONS

            */
            boolean control = true;
            while(control) {
                // menu
                System.out.println("------------------LIBRARY------------------");
                System.out.println("1\tADD A BOOK");
                System.out.println("2\tREMOVE A BOOK");
                System.out.println("3\tISSUE A BOOK");
                System.out.println("4\tRETURN A BOOK");
                System.out.println();
                System.out.println("ANY OTHER KEY TO EXIT");
                System.out.println("---------------------+---------------------");
                System.out.println();
                System.out.print("SELECT AN OPTION:\n>\t");

                int choice = sc.nextInt();

                // some variable required to take input according to the selected menu operation
                long ISBN, copyID;
                String name, author, issuedate, returndate;

                // switch to handle input options
                switch (choice) {
                    case 1:
                        // add a book to the library and add its copies
                        System.out.println("-----NEW BOOK-----");
                        System.out.print("ISBN:\t"); ISBN = sc.nextLong(); sc.nextLine();
                        System.out.print("Name:\t"); name = sc.nextLine();
                        System.out.print("Author:\t"); author = sc.nextLine();
                        Book book = new Book(ISBN, name, author);
                        System.out.println("BOOK IS READY!");
                        System.out.println("Number of copies:\t"); int copies = sc.nextInt();
                        ArrayList<BookCopy> bookcopies = new ArrayList<BookCopy>();
                        for(int i=0; i<copies; i++) bookcopies.add(new BookCopy(book, i));
                        library.addBook(book, bookcopies);
                        break;
                    case 2:
                        // remove a book from the library along with its copies
                        System.out.println("-----DEL BOOK-----");
                        System.out.print("ISBN:\t"); ISBN = sc.nextLong();
                        library.delBook(ISBN);
                        break;
                    case 3:
                        // issue a book
                        System.out.println("-----ISSUE BOOK-----");
                        System.out.print("ISBN:\t"); ISBN = sc.nextLong(); sc.nextLine();
                        // get a copy of the book of the provided isbn
                        copyID = BookCopy.getCopy(conn, ISBN);
                        if(copyID == -1) { System.out.println("NO COPIES AVAILABLE!"); break; }
                        // get issue date
                        System.out.print("Issue Date (DD-MON-YYYY):\t"); issuedate = sc.next();
                        Issue newIssue = new Issue(ISBN, copyID);
                        newIssue.issueBook(conn, issuedate);
                        break;
                    case 4:
                        // return a book
                        System.out.println("-----ISSUE BOOK-----");
                        System.out.print("ISBN:\t"); ISBN = sc.nextLong();
                        System.out.print("Copy ID:\t"); copyID = sc.nextLong();
                        // get return date
                        System.out.print("Return Date (DD-MON-YYYY):\t"); returndate = sc.next();
                        Issue newReturn = new Issue(ISBN, copyID);
                        newReturn.returnBook(conn, returndate);
                        break;
                    default:
                        if(library != null) library.close();
                        control = false;
                        break;
                }
            }

        } catch (ClassNotFoundException e) {
            System.out.println("ORACLE JDBC CLASS NOT FOUND!");
            System.out.println(e);
        } catch (SQLException e) {
            System.out.println("AN SQL EXCEPTION OCCURED! <ORACLE JDBC CONNECTION>");
            System.out.println(e);
        } finally {
            if(conn != null) try { conn.close(); } catch (SQLException e) { System.out.println("AN SQL EXCEPTION OCCURED! <ORACLE JDB DISCONNECTION>"); System.out.println(e); }
            sc.close();
        }
    }
}
