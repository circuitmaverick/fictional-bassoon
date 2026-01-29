import Marketing.Sales;

public class Driver {
    public static void main(String[] args) {
        Sales s = new Sales();
        s.setDetails(123, "Amit");

        double basic = 1000;
        double total = s.earnings(basic) + s.tallowance(s.earnings(basic));

        // System.out.println("The emp id of the employee is " + s.empid);
        System.out.println("The total earning is " + total);
    }
}
