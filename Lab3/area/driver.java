import java.util.Scanner;

class Calculator {
    // area of a tiangle
    double area(double b, double h) {
        return 0.5*b*h;
    }

    // area of a circle
    double area(double r) {
        return 3.14*r*r;
    }

    // area of a square
    double area(int side) {
        return side*side;
    }
}

public class driver {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the radius: ");
        double radius = sc.nextDouble();
        System.out.println("Enter the base and height: ");
        double base = sc.nextDouble(), height = sc.nextDouble();
        System.out.println("Enter the side of the square");
        int side = sc.nextInt();
        sc.close();
        Calculator calc = new Calculator();
        System.out.println("Area of circle: "+calc.area(radius));
        System.out.println("Area of triangle: "+calc.area(base, height));
        System.out.println("Area of square: "+calc.area(side));
    }
}
