class Plate {

    protected int length, width;

    public Plate(int length, int width) {
        this.length=length;
        this.width=width;
    }

    public void displayDim() {
        System.out.println("-----Plate-----\nLength: "+length+"\nWidth: "+width);
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
        Plate plate = new Plate(7, 3);
        Box box = new Box(10, 4, 20);
        Woodbox woodbox = new Woodbox(8, 12, 4, 6);

        plate.displayDim();
        box.displayDim();
        woodbox.displayDim();
    }
}
