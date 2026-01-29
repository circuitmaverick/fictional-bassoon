interface Employee {
    void getDetails(int id, String name);
}

interface Manager extends Employee {
    void getDeptDetails(int did, String dname);
}

class Head implements Manager {
    int empid, deptid;
    String empname, deptname;

    public void getDetails(int id, String name) {
        empid = id;
        empname = name;
    }

    public void getDeptDetails(int did, String dname) {
        deptid = did;
        deptname = dname;
    }

    void display() {
        System.out.println("Employee id - " + empid);
        System.out.println("Employee name - " + empname);
        System.out.println("Department id - " + deptid);
        System.out.println("Department name - " + deptname);
    }
}

public class Driver {
    public static void main(String[] args) {
        Head h = new Head();
        h.getDetails(123, "Sidharth Ambani");
        h.getDeptDetails(6, "Marketing");
        h.display();
    }
}
