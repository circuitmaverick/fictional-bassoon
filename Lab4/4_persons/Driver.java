import java.util.Scanner;

class Account {
    protected long account_no;
    protected float balance;

    public void input(Scanner reader) {
        System.out.print("Enter account no: "); account_no = reader.nextLong();
        System.out.print("Enter balance: "); balance = reader.nextFloat();
    }

    public void display() {
        System.out.println("Account No.: "+account_no);
        System.out.println("Balance: "+balance);
    }
}

class Person extends Account {
    protected long aadhaar_no;
    protected String name;

    public void input(Scanner reader) {
            System.out.print("Enter the Aadhaar No.: ");
            aadhaar_no = reader.nextLong(); reader.nextLine();
            System.out.print("Enter the name: ");
            name = reader.nextLine();
            super.input(reader);
    }

    public void display() {
        super.display();
        System.out.println("Aadhaar No.: "+aadhaar_no);
        System.out.println("Name: "+name);
    }
}

public class Driver {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Person persons[] = new Person[3];
        for(Person p: persons) {
            // get details of person
            p = new Person();
            p.input(sc);
        }

        // display
        for(Person p: persons) {
            p.display();
        }
    }

}
