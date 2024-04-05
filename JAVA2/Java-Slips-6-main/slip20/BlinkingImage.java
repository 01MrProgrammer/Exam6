// package com.slip20;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import javax.imageio.ImageIO;

public class BlinkingImage extends JFrame {

    private JLabel imageLabel;

    public BlinkingImage() {
        setTitle("Blinking Image");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Load the image
        ImageIcon icon = loadImage("image.png"); // Change "image.png" to your image file path
        imageLabel = new JLabel(icon);

        // Create a timer to toggle image visibility every 500 milliseconds (half second)
        Timer timer = new Timer(500, new ActionListener() {
            boolean visible = true;

            @Override
            public void actionPerformed(ActionEvent e) {
                imageLabel.setVisible(visible);
                visible = !visible;
            }
        });
        timer.start();

        getContentPane().add(imageLabel, BorderLayout.CENTER);
    }

    // Method to load image
    private ImageIcon loadImage(String imagePath) {
        try {
            Image image = ImageIO.read(getClass().getResource(imagePath));
            return new ImageIcon(image);
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            BlinkingImage blinkingImage = new BlinkingImage();
            blinkingImage.setVisible(true);
        });
    }
}
