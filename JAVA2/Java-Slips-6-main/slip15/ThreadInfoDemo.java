//Q1
//Write a java program to display name and priority of a Thread

// package com.slip15;

public class ThreadInfoDemo {
    public static void main(String[] args) {
        // Create a thread object
        Thread thread = new Thread(new MyRunnable());
        
        // Set thread name
        thread.setName("MyThread");
        
        // Set thread priority
        thread.setPriority(Thread.MAX_PRIORITY); // Set maximum priority
        
        // Start the thread
        thread.start();
        
        // Display thread name and priority
        System.out.println("Thread Name: " + thread.getName());
        System.out.println("Thread Priority: " + thread.getPriority());
    }
    
    static class MyRunnable implements Runnable {
        @Override
        public void run() {
            // Task to be performed by the thread
        }
    }
}
