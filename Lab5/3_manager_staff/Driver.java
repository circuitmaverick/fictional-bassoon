interface Salary {
    double earnings();
    double deductions();
    double bonus();
}

abstract class Manager implements Salary {
    double basic;

    Manager(double b) {
        basic = b;
    }

    public double earnings() {
        return basic + (0.8 * basic) + (0.15 * basic);
    }

    public double deductions() {
        return 0.12 * basic;
    }
}

class Substaff extends Manager {
    Substaff(double b) {
        super(b);
    }

    public double bonus() {
        return 0.5 * basic;
    }
}

public class Driver {
    public static void main(String[] args) {
        Substaff s = new Substaff(50000);

        System.out.println("Earnings - " + s.earnings());
        System.out.println("Deduction - " + (int)s.deductions());
        System.out.println("Bonus - " + (int)s.bonus());
    }
}
