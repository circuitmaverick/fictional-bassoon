import java.util.Scanner;

class Largest {
    private int x, y, z;
    public void input() {
        Scanner sc = new Scanner(System.in);
        x = sc.nextInt();
        y = sc.nextInt();
        z = sc.nextInt();
        sc.close();
    }

    public int findLargest() {
        if (x>y && x>z) return x;
        else if(y>z) return y;
        else return z;
    }
}

public class driver {
    public static void main(String[] args) {
        Largest obj = new Largest();
        obj.input();
        System.out.println(obj.findLargest());
    }
}
