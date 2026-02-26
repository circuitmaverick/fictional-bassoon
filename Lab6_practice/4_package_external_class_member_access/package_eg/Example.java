package package_eg;

public class Example {
    private int a;

    public Example() {
        External e = new External(10);
        this.a = e.a;
    }

    public String toString() { return ""+a+""; }
}
