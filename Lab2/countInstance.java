public class countInstance {
    private static int counts=0;

    public countInstance() {
        counts++;
    }

    public void display() {
        System.out.println("Instances: "+counts);
    }

    public static void main(String[] args) {
        countInstance obj1 = new countInstance();
        obj1.display();
        countInstance obj2 = new countInstance();
        obj2.display();
        countInstance obj3 = new countInstance();
        obj3.display();
        countInstance obj4 = new countInstance();
        obj4.display();
    }
}
