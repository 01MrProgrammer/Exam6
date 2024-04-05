//Q1
//Write a Java program using Runnable interface to blink Text on the frame

// package com.slip4;

import javax.swing.*;
import java.awt.*;
//import java.awt.event.*;

public class BlinkingText implements Runnable {
    private JLabel label;
    private boolean blinkFlag;

    public BlinkingText() {
        label = new JLabel("Blinking Text", JLabel.CENTER);
        blinkFlag = true;
    }

    @Override
    public void run() {
        try {
            while (true) {
                // Toggle the blink flag
                blinkFlag = !blinkFlag;

                // Update label visibility based on blink flag
                SwingUtilities.invokeAndWait(new Runnable() {
                    @Override
                    public void run() {
                        label.setVisible(blinkFlag);
                    }
                });

                // Sleep for 500 milliseconds
                Thread.sleep(500);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                // Create instance of BlinkingText
                BlinkingText blinkingText = new BlinkingText();

                // Create a frame
                JFrame frame = new JFrame("Blinking Text");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());

                // Add the label to the frame
                frame.add(blinkingText.label, BorderLayout.CENTER);

                // Set frame properties
                frame.setSize(400, 200);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);

                // Create and start a thread to handle blinking
                Thread thread = new Thread(blinkingText);
                thread.start();
            }
        });
    }
}

