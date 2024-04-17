import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Q1 extends JFrame implements Runnable {
    private JLabel label;

    public Q1() {
        setTitle("Blinking Text");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        label = new JLabel("Blinking Text");
        label.setFont(new Font("Arial", Font.PLAIN, 24));
        add(label, BorderLayout.CENTER);

        Thread thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        try {
            while (true) {
                Thread.sleep(500); // Blinking interval
                label.setVisible(!label.isVisible()); // Toggle visibility
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Q1 blinkingText = new Q1();
            blinkingText.setVisible(true);
        });
    }
}