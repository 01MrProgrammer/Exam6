//Q1
//Write a java program to define a thread for printing text on output screen for ‘n’
//number of times. Create 3 threads and run them. Pass the text ‘n’ parameters to the
//thread constructor.
// Example:
//i. First thread prints “COVID19” 10 times.
//ii. Second thread prints “LOCKDOWN2020” 20 times
//iii. Third thread prints “VACCINATED2021” 30 times 

// package com.slip8;

public class TextPrinterThread extends Thread {
    private String text;
    private int times;

    public TextPrinterThread(String text, int times) {
        this.text = text;
        this.times = times;
    }

    @Override
    public void run() {
        for (int i = 0; i < times; i++) {
            System.out.println(text);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        // Create and start threads
        TextPrinterThread thread1 = new TextPrinterThread("COVID19", 10);
        TextPrinterThread thread2 = new TextPrinterThread("LOCKDOWN2020", 20);
        TextPrinterThread thread3 = new TextPrinterThread("VACCINATED2021", 30);

        thread1.start();
        Thread.sleep(2000);
        thread2.start();
        Thread.sleep(4000);
        thread3.start();
        Thread.sleep(4000);
    }
}
