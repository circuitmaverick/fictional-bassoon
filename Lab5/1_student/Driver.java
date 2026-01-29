import java.util.Scanner;

class Student {
    private long rollno, regno;

    public void getInput(Scanner reader) {
        System.out.print("Enter roll no: ");
        rollno = reader.nextLong();
        System.out.print("Enter reg no:");
        regno = reader.nextLong();
    }

    public void course() {}

    public String toString() {
        return "Roll No.:"+rollno+"\nReg No.:"+regno+"\n";
    }
}

class KIITIAN extends Student {
    private String course;

    public void course(Scanner reader) {
        reader.nextLine();
        System.out.println("Enter course: ");
        course = reader.nextLine();
    }

    public String toString() {
        return super.toString()+"Course:"+course+"\n";
    }
}

public class Driver {
    public static void main(String[] args) {
        KIITIAN kiitian = new KIITIAN();
        Scanner sc = new Scanner(System.in);
        kiitian.getInput(sc);
        kiitian.course(sc);
        System.out.println(kiitian);
    }
}
