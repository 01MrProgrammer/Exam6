// Q1.java

class Counter {
    private int count = 0;

    // Synchronized method
    public synchronized void increment() {
        count++;
    }

    public int getCount() {
        return count;
    }
}

class CounterThread extends Thread {
    private Counter counter;
    private int incrementCount;

    public CounterThread(Counter counter, int incrementCount) {
        this.counter = counter;
        this.incrementCount = incrementCount;
    }

    @Override
    public void run() {
        for (int i = 0; i < incrementCount; i++) {
            counter.increment();
        }
    }
}

public class Q1 {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();

        // Create multiple threads
        CounterThread thread1 = new CounterThread(counter, 1000);
        CounterThread thread2 = new CounterThread(counter, 1000);

        // Start the threads
        thread1.start();
        thread2.start();

        // Wait for threads to finish
        thread1.join();
        thread2.join();

        // Print the final count
        System.out.println("Final Count: " + counter.getCount());
    }
}
