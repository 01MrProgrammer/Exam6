//Q1
//Write a java program that implements a multi-thread application that has three threads.
//First thread generates random integer number after every one second, if the number is
//even; second thread computes the square of that number and print it. If the number is
//odd, the third thread computes the of cube of that number and print it. 

// package com.slip7;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class NumberProcessing {
    static class RandomNumberGenerator extends Thread {
        private Random random = new Random();

        @Override
        public void run() {
            try {
                while (true) {
                    int number = random.nextInt(100); // Generate a random number
                    System.out.println("Generated number: " + number);
                    if (number % 2 == 0) {
                        synchronized (EvenNumberProcessor.lock) {
                            EvenNumberProcessor.number = number; // Assign the number to EvenNumberProcessor
                            EvenNumberProcessor.lock.notify(); // Notify EvenNumberProcessor
                        }
                    } else {
                        synchronized (OddNumberProcessor.lock) {
                            OddNumberProcessor.number = number; // Assign the number to OddNumberProcessor
                            OddNumberProcessor.lock.notify(); // Notify OddNumberProcessor
                        }
                    }
                    TimeUnit.SECONDS.sleep(5); // Wait for one second
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class EvenNumberProcessor extends Thread {
        static final Object lock = new Object();
        static int number;

        @Override
        public void run() {
            try {
                while (true) {
                    synchronized (lock) {
                        lock.wait(); // Wait for notification from RandomNumberGenerator
                        System.out.println("Square of even number " + number + ": " + (number * number));
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class OddNumberProcessor extends Thread {
        static final Object lock = new Object();
        static int number;

        @Override
        public void run() {
            try {
                while (true) {
                    synchronized (lock) {
                        lock.wait(); // Wait for notification from RandomNumberGenerator
                        System.out.println("Cube of odd number " + number + ": " + (number * number * number));
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
        EvenNumberProcessor evenNumberProcessor = new EvenNumberProcessor();
        OddNumberProcessor oddNumberProcessor = new OddNumberProcessor();

        randomNumberGenerator.start();
        evenNumberProcessor.start();
        oddNumberProcessor.start();
    }
}
