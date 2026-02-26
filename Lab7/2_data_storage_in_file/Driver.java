import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

class Student {
    private long rollno; private double marks;
    private String name, subject;

    public Student() {}

    public Student(long rollno, String name, String subject, double marks) {
        this.rollno = rollno;
        this.name = name;
        this.subject = subject;
        this.marks = marks;
    }

    public void input(Scanner sc) {
        System.out.print("ROLL NO: ");
        rollno = sc.nextLong(); sc.nextLine();
        System.out.print("NAME: ");
        name = sc.nextLine();
        System.out.print("SUBJECT: ");
        subject = sc.nextLine();
        System.out.print("MARKS: ");
        marks = sc.nextDouble();
    }

    public void store(String filename) {
        try {
            FileWriter fw = new FileWriter(filename); 
            fw.write(this.toString());
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void read(String filename) {
        try {
            File f = new File(filename);
            Scanner reader = new Scanner(f);
            while(reader.hasNextLine()) {
                rollno = reader.nextLong(); reader.nextLine();
                name = reader.nextLine();
                subject = reader.nextLine();
                marks = reader.nextDouble(); 
            }
            reader.close();
        } catch (FileNotFoundException e) { e.printStackTrace(); }
    }

    public String toString() {
        return rollno+"\n"+name+"\n"+subject+"\n"+marks;
    }
}

public class Driver {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Student s = new Student();
        s.input(sc);

        System.out.println("Enter the filename where to save the details: ");
        String fname = sc.next();
        s.store(fname);
        System.out.println(s+"\n\nSTORED");

        System.out.println("Enter the filename to retrieve the details: ");
        fname = sc.next();
        s.read(fname);
        System.out.println(s+"\n\nREAD");

        sc.close();
    }
}
