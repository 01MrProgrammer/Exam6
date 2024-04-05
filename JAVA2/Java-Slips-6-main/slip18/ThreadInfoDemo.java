//Q1
//Write a java program to display name and priority of a Thread. 

// package com.slip18;

public class ThreadInfoDemo {
    public static void main(String[] args) {
        // Create a thread object
        Thread thread = new MyThread();

        // Display thread name and priority
        System.out.println("Thread Name: " + thread.getName());
        System.out.println("Thread Priority: " + thread.getPriority());
    }

    static class MyThread extends Thread {
        @Override
        public void run() {
            // Task to be performed by the thread
        }
    }
}

