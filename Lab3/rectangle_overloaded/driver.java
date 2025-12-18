import java.util.Scanner;

class Rectangle{
    private int length, breadth;
    public Rectangle() {
        this(0,0);
    }
    public Rectangle(int l, int b) {
        this.length = l;
        this.breadth = b;
    }
    public double area() {
        return length*breadth;
    }
}

public class driver {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Rectangle rec = new Rectangle();
        System.out.println("Area before input: "+rec.area());
        System.out.println("Enter the length: ");
        int l = sc.nextInt();
        System.out.println("Enter the breadth: ");
        int b = sc.nextInt(); sc.close();
        rec = new Rectangle(l,b);
        System.out.println("Area: "+rec.area());
    }
}
