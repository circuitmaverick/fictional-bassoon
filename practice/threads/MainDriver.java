import java.util.Scanner;

class EvenThread extends Thread {
    private int n;
    private int m;

    // constructor
    public EvenThread(int n, int m) {
        this.n = n;
        this.m = m;
    }

    @Override
    public void run() {
        int sum = 0;

        for (int i = n; i <= m; i++) {
            if (i % 2 == 0) {
                sum += i;
            }
        }

        System.out.println("Sum of even numbers = " + sum);
    }
}

class OddThread extends Thread {
    private int n;
    private int m;

    // constructor
    public OddThread(int n, int m) {
        this.n = n;
        this.m = m;
    }

    @Override
    public void run() {
        long product = 1;
        boolean found = false;

        for (int i = n; i <= m; i++) {
            if (i % 2 != 0) {
                product *= i;
                found = true;
            }
        }

        if (found)
            System.out.println("Product of odd numbers = " + product);
        else
            System.out.println("No odd numbers in range.");
    }
}

class NumberProcesser {
    private int n, m;

    public void input() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter n: ");
        n = sc.nextInt();

        System.out.print("Enter m (m > n): ");
        m = sc.nextInt();

        if (m <= n) {
            System.out.println("Invalid input. m must be greater than n.");
            sc.close();
            return;
        }
    }

    public void compute() {
        // create thread objects
        EvenThread t1 = new EvenThread(n, m);
        OddThread t2 = new OddThread(n, m);

        // start threads
        t1.start();
        t2.start();
    }
}

public class MainDriver {
    public static void main(String[] args) {
        NumberProcesser np = new NumberProcesser();
        np.input();
        np.compute();
    }
}