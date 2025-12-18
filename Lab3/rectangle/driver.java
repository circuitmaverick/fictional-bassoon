import java.util.Scanner;

class Rectangle {
    private int length, breadth, area, perimeter;

    public void read() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the length: "); length = sc.nextInt();
        System.out.println("Enter the breadth: "); breadth = sc.nextInt();
        sc.close();
    }

    public void calculate() {
        area = length*breadth;
        perimeter = 2*(length+breadth);
        System.out.println("Calculations completed!");
    }

    public void display() {
        System.out.println("Area: "+area);
        System.out.println("Perimeter: "+perimeter);
    }
}

public class driver {
    public static void main(String[] args) {
        Rectangle rec = new Rectangle();
        rec.read();
        rec.calculate();
        rec.display();
    }
}
