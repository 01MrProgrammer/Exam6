//Q1
//Write a Java Program to display the details of College (CID, CName, address, Year)
//on JTable. 

// package com.slip27;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class CollegeDetailsTable extends JFrame {
    private JTable table;

    public CollegeDetailsTable() {
        setTitle("College Details");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Data for the table (sample data)
        Object[][] data = {
                {"101", "ABC College", "123 Street, City", "2020"},
                {"102", "XYZ College", "456 Street, Town", "2019"},
                {"103", "PQR College", "789 Street, Village", "2021"}
        };

        // Column names
        String[] columnNames = {"CID", "CName", "Address", "Year"};

        // Create a table model
        DefaultTableModel model = new DefaultTableModel(data, columnNames);

        // Create a JTable with the model
        table = new JTable(model);

        // Add the table to a scroll pane
        JScrollPane scrollPane = new JScrollPane(table);
        getContentPane().add(scrollPane, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            CollegeDetailsTable collegeDetailsTable = new CollegeDetailsTable();
            collegeDetailsTable.setVisible(true);
        });
    }
}
