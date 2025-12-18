class Subtractor{
    int subtract(int a, int b) {
        return a-b;
    }
    int subtract(int a, int b, int c) {
        return a-b-c;
    }
    float subtract(float a, float b) {
        return a-b;
    }
    float subtract(float a, float b, float c) {
        return a-b-c;
    }
}

public class driver {
    public static void main(String[] args) {
        Subtractor sub = new Subtractor();
        System.out.println(sub.subtract(2,3));
        System.out.println(sub.subtract(2,3, 4));
        System.out.println(sub.subtract(2.2f,3.5f));
        System.out.println(sub.subtract(2.6f,0.3f, 1.2f));
    }
}