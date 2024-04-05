//Q1
//Write a Java program to create a thread for moving a ball inside a panel vertically. The
//ball should be created when the user clicks on the start button.

// package com.slip9;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BallMovement extends JFrame {
    private JPanel panel;
    private JButton startButton;
    private BallThread ballThread;

    public BallMovement() {
        setTitle("Ball Movement");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel() {
            private int ballY = 0;

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(Color.RED);
                g.fillOval(180, ballY, 40, 40);
            }

            public void moveBall() {
                ballY += 5; // Change the value to control the speed of the ball
                repaint();
            }
        };

        startButton = new JButton("Start");
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (ballThread == null || !ballThread.isAlive()) {
                    ballThread = new BallThread(panel);
                    ballThread.start();
                }
            }
        });

        panel.setPreferredSize(new Dimension(400, 400));
        panel.setBackground(Color.WHITE);
        add(panel, BorderLayout.CENTER);
        add(startButton, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new BallMovement().setVisible(true);
            }
        });
    }

    static class BallThread extends Thread {
        private JPanel panel;

        public BallThread(JPanel panel) {
            this.panel = panel;
        }

        @Override
        public void run() {
            while (true) {
                panel.repaint();
                try {
                    Thread.sleep(50); // Adjust the sleep time to control the speed of the ball
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
