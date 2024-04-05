//Q2

// package com.slip17;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class NumberDisplay extends JFrame {

    private JTextField textField;
    private JButton startButton;
    private volatile boolean isRunning = false;

    public NumberDisplay() {
        setTitle("Number Display");
        setSize(300, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        textField = new JTextField(20);
        startButton = new JButton("Start");

        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!isRunning) {
                    isRunning = true;
                    startButton.setEnabled(false);
                    // Create and start a new thread for displaying numbers
                    Thread numberThread = new Thread(new NumberRunnable());
                    numberThread.start();
                }
            }
        });

        JPanel panel = new JPanel();
        panel.add(textField);
        panel.add(startButton);

        getContentPane().add(panel);
    }

    // Runnable implementation to continuously display numbers
    class NumberRunnable implements Runnable {
        @Override
        public void run() {
        	int i;
            for (i = 1; i <= 100; i++) {
                // Check if the thread should continue running
                if (!isRunning) {
                    break;
                }

                // Update the text field with the current number
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                    	
                        textField.setText(String.valueOf(i));
                    }
                });

                try {
                    Thread.sleep(500); // Sleep for 500 milliseconds
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }

            // Reset button state after completion
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    isRunning = false;
                    startButton.setEnabled(true);
                }
            });
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                NumberDisplay numberDisplay = new NumberDisplay();
                numberDisplay.setVisible(true);
            }
        });
    }
}
