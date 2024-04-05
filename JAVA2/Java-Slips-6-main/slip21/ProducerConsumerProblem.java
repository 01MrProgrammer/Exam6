//Q2
//Write a java program to solve producer consumer problem in which a producer
//produces a value and consumer consume the value before producer generate the next
//value. (Hint: use thread synchronization) 

// package com.slip21;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProducerConsumerProblem {
    public static void main(String[] args) {
        BlockingQueue<Integer> buffer = new ArrayBlockingQueue<>(1); // Buffer size is 1

        Thread producerThread = new Thread(new Producer(buffer));
        Thread consumerThread = new Thread(new Consumer(buffer));

        producerThread.start();
        consumerThread.start();
    }

    static class Producer implements Runnable {
        private BlockingQueue<Integer> buffer;

        public Producer(BlockingQueue<Integer> buffer) {
            this.buffer = buffer;
        }

        @Override
        public void run() {
            try {
                for (int i = 0; i < 5; i++) {
                    Thread.sleep(1000); // Simulating the time taken to produce a value
                    int value = i + 1;
                    System.out.println("Producer produced: " + value);
                    buffer.put(value); // Put the value into the buffer
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class Consumer implements Runnable {
        private BlockingQueue<Integer> buffer;

        public Consumer(BlockingQueue<Integer> buffer) {
            this.buffer = buffer;
        }

        @Override
        public void run() {
            try {
                for (int i = 0; i < 5; i++) {
                    Thread.sleep(2000); // Simulating the time taken to consume a value
                    int value = buffer.take(); // Take the value from the buffer
                    System.out.println("Consumer consumed: " + value);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
