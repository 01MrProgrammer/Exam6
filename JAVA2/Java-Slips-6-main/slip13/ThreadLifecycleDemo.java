//Q2
//Write a Java program to show lifecycle (creation, sleep, and dead) of a thread. Program
//should print randomly the name of thread and value of sleep time. The name of the
//thread should be hard coded through constructor. The sleep time of a thread will be a
//random integer in the range 0 to 4999. 

// package com.slip13;

import java.util.Random;

public class ThreadLifecycleDemo extends Thread {
    
    public ThreadLifecycleDemo(String name) {
        super(name); // Setting thread name through constructor
    }

    @Override
    public void run() {
        System.out.println(getName() + " created.");

        Random random = new Random();
        int sleepTime = random.nextInt(5000); // Random sleep time between 0 to 4999 milliseconds

        try {
            System.out.println(getName() + " will sleep for " + sleepTime + " milliseconds.");
            Thread.sleep(sleepTime); // Thread sleeps for a random duration
        } catch (InterruptedException e) {
            System.out.println(getName() + " interrupted while sleeping.");
        }

        System.out.println(getName() + " dead.");
    }

    public static void main(String[] args) {
        ThreadLifecycleDemo thread = new ThreadLifecycleDemo("CustomThread");
        thread.start();
    }
}
