// Write a Java program to create a class called "Account" with attributes for
// account number, account holder's name, account type, and balance. Include methods
// for depositing and withdrawing money, as well as checking the balance. Create a
// subclass called "SavingsAccount", "CurrentAccount" and "RecurringAccount" that
// adds an interest rate attribute and a method to apply interest.

class Account {
    private long acc_no;
    private String name;
    protected enum type { savings, current, recurring };
    private type acc_type;
    private double balance;

    public Account(long accNo, String name, type accType, double balance) {
        this.acc_no = accNo;
        this.name = name;
        this.acc_type = accType;
        this.balance = balance;
    }

    public void withdraw(double amt) { balance-=amt; }

    public void deposit(double amt) { balance+=amt; }

    public double checkBal() { return balance; }
}

class SavingsAccount extends Account {
    private float interest_rate;

    public SavingsAccount(long accNo, String name, double balance, float interestRate) {
        super(accNo, name, type.savings, balance);
        this.interest_rate = interestRate;
    }

    public void applyInterset() {
        double interest_amt = checkBal() * (interest_rate/100);
        deposit(interest_amt);
    }
}

class CurrentAccount extends Account {
    private float interest_rate;

    public CurrentAccount(long accNo, String name, double balance, float interestRate) {
        super(accNo, name, type.current, balance);
        this.interest_rate = interestRate;
    }

    public void applyInterset() {
        double interest_amt = checkBal() * (interest_rate/100);
        deposit(interest_amt);
    }
}

class RecurringAccount extends Account {
    private float interest_rate;

    public RecurringAccount(long accNo, String name, double balance, float interestRate) {
        super(accNo, name, type.recurring, balance);
        this.interest_rate = interestRate;
    }

    public void applyInterset() {
        double interest_amt = checkBal() * (interest_rate/100);
        deposit(interest_amt);
    }
}

public class Driver {
    public static void main(String[] args) {
        SavingsAccount sa = new SavingsAccount(29384719, "Akash Maity", 180982.97, 4.5f);
        sa.applyInterset();
        System.out.println("Savings balance: "+sa.checkBal());
        CurrentAccount ca = new CurrentAccount(239849823, "Akash Maity", 987324.64, 8.1f);
        ca.applyInterset();
        System.out.println("Current balance: "+ca.checkBal());
        RecurringAccount ra = new RecurringAccount(9834275, "Akash Maity", 983742.52, 3.9f);
        ra.applyInterset();
        System.out.println("Recurring balance: "+ra.checkBal());
        sa.withdraw(92837.12);
        System.out.println("Savings balance: "+sa.checkBal());
        ca.deposit(928374.1);
        System.out.println("Current balance: "+ca.checkBal());
        ra.withdraw(23847.54);
        System.out.println("Recurring balance: "+ra.checkBal());
    }
}