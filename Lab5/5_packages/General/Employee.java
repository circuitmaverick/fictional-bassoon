package General;

public class Employee {
    protected int empid;
    private String ename;

    public void setDetails(int id, String name) {
        empid = id;
        ename = name;
    }

    public double earnings(double basic) {
        return basic + (0.8 * basic) + (0.15 * basic);
    }
}
