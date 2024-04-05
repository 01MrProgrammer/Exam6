//Q2
//Write a java program to simulate traffic signal using threads. 

// package com.slip6;

import java.util.concurrent.TimeUnit;

public class TrafficSignalSimulation {
    // Enum representing the state of the traffic signal
    enum SignalState {
        RED, GREEN, YELLOW
    }

    // Thread class representing the traffic signal
    static class TrafficSignal extends Thread {
        private SignalState state;

        public TrafficSignal() {
            this.state = SignalState.RED; // Initial state
        }

        @Override
        public void run() {
            try {
                while (true) {
                    switch (state) {
                        case RED:
                            System.out.println("Traffic signal: RED");
                            TimeUnit.SECONDS.sleep(5); // RED signal duration
                            state = SignalState.GREEN;
                            break;
                        case GREEN:
                            System.out.println("Traffic signal: YELLOW");
                            TimeUnit.SECONDS.sleep(10); // GREEN signal duration
                            state = SignalState.YELLOW;
                            break;
                        case YELLOW:
                            System.out.println("Traffic signal: GREEN");
                            TimeUnit.SECONDS.sleep(2); // YELLOW signal duration
                            state = SignalState.RED;
                            break;
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        // Create and start the traffic signal thread
        TrafficSignal signal = new TrafficSignal();
        signal.start();
    }
}
