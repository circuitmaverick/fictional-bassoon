import java.util.ArrayList;
import java.util.Scanner;

class Account {
    private long aadhaar_no, acc_no;
    private float balance, minBal;
    private String name;

    public void input(Scanner reader) {
        System.out.print("Name: ");
        name = reader.nextLine();
        System.out.print("Aadhaar No.: ");
        aadhaar_no = reader.nextLong();
        System.out.print("Account No.: ");
        acc_no = reader.nextLong();
        System.out.print("Balance: ");
        balance = reader.nextFloat();
        System.out.print("Minimum Balance: ");
        minBal = reader.nextFloat();
    }

    public float getBalance() { return balance; }

    public float getMinBal() { return minBal; }

    public void setBalance(float bal) { this.balance = bal; }

    public long getAccNo() { return acc_no; }

    public void display() {
        System.out.println("---- ACCOUNT ----");
        System.out.println("Acc No.: "+acc_no);
        System.out.println("Aadhaar No.: "+aadhaar_no);
        System.out.println("Name: "+name);
        System.out.println("Balance: "+balance);
        System.out.println("Minimum Balance: "+minBal);
    }
}

class Bank {
    ArrayList<Account> accounts = new ArrayList<Account>();

    public void add(Account acc) {
        accounts.add(acc);
    }

    public void remove(long acc_no) {
        for(Account acc: accounts)
            if(acc.getAccNo() == acc_no) accounts.remove(acc);
    }

    public void withdraw(long acc_no, float amt) {
        for (Account acc: accounts)
            if(acc.getAccNo() == acc_no)
                if(acc.getBalance()-amt >= acc.getMinBal()) acc.setBalance(acc.getBalance()-amt);
                else System.out.println("Insufficient Balance");
    }

    public void deposit(long acc_no, float amt) {
        for(Account acc: accounts) {
            if(acc.getAccNo() == acc_no)
                acc.setBalance(acc.getBalance()+amt);
        }
    }

    public void getAccDetails(long acc_no) {
        for(Account acc: accounts)
            if(acc.getAccNo() == acc_no) acc.display();
    }

    public void display() {
        for(Account acc: accounts)
            acc.display();
    }
}


public class Driver {
    public static void main(String[] args) {
        Bank sbi = new Bank();
        Scanner sc = new Scanner(System.in);
        while(true) {
            System.out.println("Enter account details ----");
            Account acc = new Account();
            acc.input(sc);
            sbi.add(acc);
            System.out.println("Account added to the bank!");
            System.out.println("Enter y to add more account, anything else to stop adding accounts...");
            System.out.print(">\t");
            char c = sc.next().charAt(0); sc.nextLine();
            if (c != 'y' & c != 'Y') break;
        }
        // operations
        while (true) {
            System.out.println("Enter...\n1\tto withdraw\n2\tto deposit\n3\tto show details of account\n4\tto show all accounts\n5\tto remove an account\nany other key to exit...");
            System.out.print(">\t");
            int c = sc.nextInt(); long acc_no; float amt;
            switch (c) {
                case 1:
                    System.out.print("Enter account no.: ");
                    acc_no = sc.nextLong();
                    System.out.print("Enter the amount: ");
                    amt = sc.nextFloat();
                    sbi.withdraw(acc_no, amt);
                    break;
                case 2:
                    System.out.print("Enter account no.: ");
                    acc_no = sc.nextLong();
                    System.out.print("Enter the amount: ");
                    amt = sc.nextFloat();
                    sbi.deposit(acc_no, amt);
                    break;
                case 3:
                    System.out.print("Enter account no.: ");
                    acc_no = sc.nextLong();
                    sbi.getAccDetails(acc_no);
                    break;
                case 4:
                    sbi.display();
                    break;
                case 5:
                    System.out.print("Enter account no.: ");
                    acc_no = sc.nextLong();
                    sbi.remove(acc_no);
                    break;
                default:
                    sc.close();
                    return;
            }
        }
    }
}
