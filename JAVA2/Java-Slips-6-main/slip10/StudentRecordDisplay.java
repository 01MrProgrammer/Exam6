//Q2
//Write a Java program to display first record from student table (RNo, SName, Per) onto
//the TextFields by clicking on button. (Assume Student table is already created).

// package com.slip10;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class StudentRecordDisplay extends JFrame {
    private JTextField rNoField;
    private JTextField sNameField;
    private JTextField perField;
    private JButton displayButton;

    public StudentRecordDisplay() {
        setTitle("Display Student Record");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        rNoField = new JTextField(10);
        sNameField = new JTextField(10);
        perField = new JTextField(10);

        displayButton = new JButton("Display");
        displayButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayStudentRecord();
            }
        });

        JPanel panel = new JPanel(new GridLayout(4, 2));
        panel.add(new JLabel("Roll No:"));
        panel.add(rNoField);
        panel.add(new JLabel("Student Name:"));
        panel.add(sNameField);
        panel.add(new JLabel("Percentage:"));
        panel.add(perField);
        panel.add(displayButton);

        add(panel);
    }

    private void displayStudentRecord() {
        try {
            // Establish database connection
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/user", "root", "");

            // Create statement
            Statement statement = connection.createStatement();

            // Execute query to retrieve first record from student table
            ResultSet resultSet = statement.executeQuery("SELECT * FROM student LIMIT 1");

            // Display record onto text fields
            if (resultSet.next()) {
                rNoField.setText(resultSet.getString("RNo"));
                sNameField.setText(resultSet.getString("SName"));
                perField.setText(resultSet.getString("Per"));
            } else {
                JOptionPane.showMessageDialog(this, "No records found in the student table.");
            }

            // Close resources
            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error occurred: " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new StudentRecordDisplay().setVisible(true);
            }
        });
    }
}
