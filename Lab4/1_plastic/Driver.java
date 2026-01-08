import java.util.Scanner;

class Sheet2D {

    protected int rate=40;
    protected float length, breadth;

    public Sheet2D(float length, float breadth) {
        this.length=length;
        this.breadth=breadth;
    }

    public float getCost() {
        return length*breadth*rate;
    }

}

class Box3D extends Sheet2D{

    protected float height;

    public Box3D(float length, float breadth, float height) {
        super(length, breadth);
        this.height=height;
        rate=60;
    }

    public float getCost() {
        return length*breadth*height*rate;
    }
}

public class Driver {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 2D sheet stuff
        System.out.println("Enter the dimensions of the sheet--------");
        System.out.print("Enter the length: ");
        float length = sc.nextFloat();
        System.out.print("Enter the breadth: ");
        float breadth = sc.nextFloat();
        Sheet2D sheet = new Sheet2D(length, breadth);
        System.out.println("Cost of plastic for the 2D sheet: "+sheet.getCost());
        System.out.println("Enter the dimensions of the box--------");
        System.out.print("Enter the length: ");
        length = sc.nextFloat();
        System.out.print("Enter the breadth: ");
        breadth = sc.nextFloat();
        System.out.print("Enter the height: ");
        float height = sc.nextFloat();
        Box3D box = new Box3D(length, breadth, height);
        System.out.println("Cost of plastic for the 3D box: "+box.getCost());
        sc.close();
    }
}
