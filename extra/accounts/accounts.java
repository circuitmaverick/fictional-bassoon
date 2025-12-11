// package extra.accounts;
// package extra;

import java.util.ArrayList;
import java.util.Scanner;

class Account {
    private String accNo, name, type;
    private double balance, minBal = 0.00;

    public void setData(String accNo, String name, String type, double balance, double minBal) {
        this.accNo = accNo;
        this.name = name;
        this.type = type;
        this.balance = balance;
        this.minBal = minBal;
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Amount deposited to the account: $" + amount);
        System.out.println("Available balance: $"+this.balance);
    }

    public void withdraw(double amount) {
        if(balance - amount < minBal) System.out.println("Withdrawal denied due to insufficient funds.");
        else {
            balance -= amount;
            System.out.println("Withdrawal successful for the amount: $" + amount);
            System.out.println("Available balance: $"+this.balance);
        }
    }

    public double enquire() {
        return balance;
    }
}

public class accounts {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter no. of accounts: ");
        int n = sc.nextInt(); Account accs = 
        // System.out.print("Enter account no.: "); String accNo = sc.next();
        // System.out.print("Enter account type: "); String type = sc.next(); sc.nextLine();
        // System.out.print("Enter name: "); String name = sc.nextLine();
        // System.out.print("Enter minimum balance: "); double minBal = sc.nextDouble();
        // System.out.print("Enter balance: "); double bal = sc.nextDouble();
        // Account acc = new Account(accNo, name, type, bal, minBal);
        while(true) {
            System.out.println("Enter 1 to deposit\nEnter 2 to withdraw\nEnter 3 to enquire\n\nPress any other key to exit\n\n");
            System.out.print("Enter your choice: "); int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter amount to deposit: "); double depositamt = sc.nextDouble();
                    acc.deposit(depositamt);
                    break;
                case 2:
                    System.out.print("Enter amount to withdraw: "); double withdrawamt = sc.nextDouble();
                    acc.withdraw(withdrawamt);
                    break;
                case 3:
                    System.out.println(acc.enquire());
                    break;
                default:
                    sc.close();
                    return;
            }
        }
    }
}