//Q2
//Write a java program to display name of currently executing Thread in multithreading

// package com.slip28;

public class CurrentThreadDemo {
    public static void main(String[] args) {
        Thread thread1 = new Thread(new MyRunnable(), "Thread 1");
        Thread thread2 = new Thread(new MyRunnable(), "Thread 2");

        thread1.start();
        thread2.start();
    }

    static class MyRunnable implements Runnable {
        @Override
        public void run() {
            String threadName = Thread.currentThread().getName();
            System.out.println("Currently executing thread: " + threadName);
        }
    }
}
