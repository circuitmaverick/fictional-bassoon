class SharedDisplay {
    public synchronized void show(String threadName) {
        String[] words = {"Hello", "World!", "From", "OOPJ"};

        for(String word: words) {
            System.out.println(threadName + " : " + word);
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                System.out.println("Thread Interrupted");
                System.out.println(e);
            }
        }
    }
}

class HandlingThread extends Thread {
    private SharedDisplay display;

    public HandlingThread(String name, SharedDisplay display) {
        super(name);
        this.display = display;
    }

    @Override
    public void run() {
        display.show(getName());
    }
}

public class Driver {
    public static void main(String[] args) {
        SharedDisplay display = new SharedDisplay();

        HandlingThread ht1 = new HandlingThread("Handler 1", display);
        HandlingThread ht2 = new HandlingThread("Handler 2", display);

        ht1.start();
        ht2.start();
    }
}