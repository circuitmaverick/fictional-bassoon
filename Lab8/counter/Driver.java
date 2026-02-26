import java.util.Scanner;

class CounterThread extends Thread {
    private int lower, upper;

    public CounterThread(String name, int lower, int upper) {
        super(name);
        this.lower = lower;
        this.upper = upper;
    }

    @Override
    public void run() {
        System.out.println("Thread - " + getName());
        System.out.println("Counter - ");

        for(int i = lower; i <= upper; i++) {
            System.out.println(i+"\t");
            try {
                Thread.sleep(5);
            } catch(InterruptedException e) {
                System.out.println("Thread Interrupted");
                System.out.println(e);
            }
        }

        System.out.println();
    }
}

public class Driver {
    public static void main() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter thread name: "); String name = sc.nextLine();
        System.out.print("Enter lower limit: "); int lower = sc.nextInt();
        System.out.print("Enter upper limit: "); int upper = sc.nextInt();

        CounterThread ct = new CounterThread(name, lower, upper);
        ct.start();

        sc.close();
    }
}

