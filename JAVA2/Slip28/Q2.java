class MyThread extends Thread {
    public void run() {
        // Displaying the name of the currently executing thread
        System.out.println("Currently executing thread: " + Thread.currentThread().getName());
    }
}

public class Q2 {
    public static void main(String[] args) {
        // Creating multiple thread objects
        MyThread thread1 = new MyThread();
        MyThread thread2 = new MyThread();
        
        // Starting the threads
        thread1.start();
        thread2.start();
        
        // Displaying the name of the main thread
        System.out.println("Main thread: " + Thread.currentThread().getName());
    }
}
