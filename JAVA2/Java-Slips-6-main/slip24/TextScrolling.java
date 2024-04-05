// package com.slip24;

import javax.swing.*;

public class TextScrolling extends JFrame implements Runnable {
    private JLabel label;
    private String text;

    public TextScrolling(String text) {
        this.text = text;
        label = new JLabel(text);
        add(label);
        setBounds(200, 200, 200, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void run() {
        try {
            while (true) {
                text = text.substring(1) + text.charAt(0);
                label.setText(text);
                Thread.sleep(200); // Adjust scroll speed (milliseconds)
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        TextScrolling frame = new TextScrolling("Hello, World! This text scrolls continuously.");
        Thread thread = new Thread(frame);
        thread.start();
    }
}
