class Apple {
    public void show() {
        System.out.println("This is an apple.");
    }
}

class Banana extends Apple {
    public void show() {
        System.out.println("This is a banana.");
    }
}

class Cherry extends Apple {
    public void show() {
        System.out.println("This is a cherry.");
    }
}

public class Driver {
    public static void main(String[] args) {
        Apple fruit;

        fruit = new Apple();
        fruit.show();

        fruit = new Banana();
        fruit.show();

        fruit = new Cherry();
        fruit.show();
    }
}
