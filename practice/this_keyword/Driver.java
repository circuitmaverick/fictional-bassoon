
class AmbiguityExample {
    private int var=0;

    public AmbiguityExample(int var) {
        this.var = var;
    }

    public void display() { System.out.println(var); }
}

class OverloadingChainingExample {
    private int a, b;

    public OverloadingChainingExample(int a) {
        this.a = a;
    }

    public OverloadingChainingExample(int a, int b) {
        this.b = b;
        this(a);
    }

    public void display() { System.out.println(a + " " + b);}
}

class MethodsExample {
    int a;
    public void setData(int a) {
        this.a = a;
    }

    public void displayData() {
        this.setData(10);
        System.out.println(a);
    }
}

public class Driver {
    public static void main(String[] args) {
        AmbiguityExample e = new AmbiguityExample(10);
        e.display();

        OverloadingChainingExample o = new OverloadingChainingExample(20, 30);
        o.display();

        MethodsExample m = new MethodsExample();
        m.displayData();
    }
}
