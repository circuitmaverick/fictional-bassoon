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
        Sheet2D sheet = new Sheet2D(9.1f,5.9f);
        System.out.println("Cost of plastic for the 2D sheet: "+sheet.getCost());
        Box3D box = new Box3D(6.1f, 9.3f,2.5f);
        System.out.println("Cost of plastic for the 3D box: "+box.getCost());
    }
}
