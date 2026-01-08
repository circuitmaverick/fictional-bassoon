import java.util.Scanner;

class Plate {

    protected int length, width;

    public Plate(int length, int width) {
        this.length=length;
        this.width=width;
    }

    public void displayDim() {
        System.out.println("-----Plate-----\nLength: "+length+"\nWidth: "+width+"---------------");
    }

}

class Box extends Plate {

    protected int height;

    public Box(int length, int width, int height) {
        super(length, width);
        this.height=height;
    }

    public void displayDim() {
        System.out.println("------Box------\nLength: "+length+"\nWidth: "+width+"\nHeight: "+height);
    }

}

class Woodbox extends Box {

    protected int thickness;

    public Woodbox(int length, int width, int height, int thickness) {
        super(length, width, height);
        this.thickness = thickness;
    }

    public void displayDim() {
        System.out.println("----Woodbox----\nLength: "+length+"\nWidth: "+width+"\nHeight: "+height+"\nThickness: "+thickness);
    }

}

public class Driver {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int length, width, height, thickness;
        // plate stuff
        System.out.print("Enter length and width of plate: ");
        length = sc.nextInt(); width = sc.nextInt();
        Plate plate = new Plate(length, width);
        // box stuff
        System.out.print("Enter length, width and height of the box: ");
        length = sc.nextInt(); width = sc.nextInt(); height = sc.nextInt();
        Box box = new Box(length, width, height);
        // woodbox stuff
        System.out.print("Enter length, width, height and thickness of the woodbox: ");
        length = sc.nextInt(); width = sc.nextInt(); height = sc.nextInt(); thickness = sc.nextInt();
        Woodbox woodbox = new Woodbox(length, width, height, thickness);

        // display each dimensions
        plate.displayDim();
        box.displayDim();
        woodbox.displayDim();
    }
}
