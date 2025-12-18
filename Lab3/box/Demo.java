import java.util.Scanner;

class Box {
    private int length, width, height;
    public Box(int length, int width, int height) {
        this.length = length;
        this.width = width;
        this.height = height;
    }

    public int volume() {
        return length*width*height;
    }
}

public class Demo {
    public static void main(String[] args) {
        // take input from the user
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the length: ");
        int length = sc.nextInt();
        System.out.println("Enter the breadth: ");
        int breadth = sc.nextInt();
        System.out.println("Enter the height: ");
        int height = sc.nextInt(); sc.close();
        Box box = new Box(length, breadth, height);
        System.out.println("Volume: "+box.volume());
    }
}
