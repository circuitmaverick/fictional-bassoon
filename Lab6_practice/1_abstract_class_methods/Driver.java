abstract class Shape {
    public abstract void setDims(int a, int b);
    public abstract double getArea();
}

class Rectangle extends Shape {
    private int length, breadth;

    public void setDims(int length, int breadth) {
        this.length = length; this.breadth = breadth;
    }

    public double getArea() {
        return length*breadth;
    }
}

class Triangle extends Shape {
    private int base, height;

    public void setDims(int base, int height) {
        this.base = base; this.height = height;
    }

    public double getArea() { return 0.5*base*height; }
}

public class Driver {
    public static void main(String[] args) {
        Shape s;

        s = new Rectangle();
        s.setDims(2, 4);
        System.out.println(s.getArea());

        s = new Triangle();
        s.setDims(4, 5);
        System.out.println(s.getArea());
    }
}
