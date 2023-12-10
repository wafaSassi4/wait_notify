package wait_notify;

public class Counter {
    private int count = 1;


    synchronized public void incrementImpair() {
        while (count % 2 == 0 || count >= 10) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Thread " + Thread.currentThread().getName() + " : " + count);
        count++;
        notify();
    }

    synchronized public void incrementPair() {
        while (count % 2 != 0 || count >= 10) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Thread " + Thread.currentThread().getName() + " : " + count);
        count++;
        notify();
    }
}
