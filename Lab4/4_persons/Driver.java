import java.util.Scanner;

class Account {
    protected int account_no;
    protected float balance;

    public void input(Scanner reader) {
        System.out.print("Enter account no: "); account_no = reader.nextInt();
        System.out.print("Enter balance: "); balance = reader.nextFloat();
    }

    public void display() {
        System.out.println("Account No.: "+account_no);
        System.out.println("Balance: "+balance);
    }
}

class Person extends Account {
    protected int aadhaar_no;
    protected String name;

    public Person(int aadhaar_no, String name) {
        super();
        this.aadhaar_no = aadhaar_no;
        this.name = name;
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
        Person p[] = new Person[3];
        for(int i=0; i<3; i++) {
            // get details of person
            System.out.print("Enter the Aadhaar No.: ");
            int a_no = sc.nextInt(); sc.nextLine();
            System.out.print("Enter the name: ");
            String name = sc.nextLine();
            p[i] = new Person(a_no, name);
            p[i].input(sc);
        }
        sc.close();
        // display
        for(int i=0; i<3; i++) {
            System.out.println("Person " + (i+1) +"--------");
            p[i].display();
        }
    }

}
