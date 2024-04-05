//Q2
/*Write a Java program to accept the details of Employee (Eno, EName, Designation,
Salary) from a user and store it into the database. (Use Swing)*/

// package com.slip1;

import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class EmployeeDetailsForm extends JFrame implements ActionListener {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JLabel enoLabel, enameLabel, designationLabel, salaryLabel;
    JTextField enoField, enameField, designationField, salaryField;
    JButton submitButton;

    public EmployeeDetailsForm() {
        setTitle("Employee Details Form");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        enoLabel = new JLabel("Eno:");
        enoLabel.setBounds(50, 50, 80, 30);
        add(enoLabel);

        enoField = new JTextField();
        enoField.setBounds(150, 50, 200, 30);
        add(enoField);

        enameLabel = new JLabel("EName:");
        enameLabel.setBounds(50, 90, 80, 30);
        add(enameLabel);

        enameField = new JTextField();
        enameField.setBounds(150, 90, 200, 30);
        add(enameField);

        designationLabel = new JLabel("Designation:");
        designationLabel.setBounds(50, 130, 80, 30);
        add(designationLabel);

        designationField = new JTextField();
        designationField.setBounds(150, 130, 200, 30);
        add(designationField);

        salaryLabel = new JLabel("Salary:");
        salaryLabel.setBounds(50, 170, 80, 30);
        add(salaryLabel);

        salaryField = new JTextField();
        salaryField.setBounds(150, 170, 200, 30);
        add(salaryField);

        submitButton = new JButton("Submit");
        submitButton.setBounds(150, 210, 100, 30);
        submitButton.addActionListener(this);
        add(submitButton);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submitButton) {
            try {
                String eno = enoField.getText();
                String ename = enameField.getText();
                String designation = designationField.getText();
                String salary = salaryField.getText();

                // Database connection
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/school_database","root","");
                Statement stmt = con.createStatement();

                // Insert data into database
                String sql = "INSERT INTO employee (Eno, EName, Designation, Salary) VALUES ('" + eno + "', '" + ename + "', '" + designation + "', '" + salary + "')";
                stmt.executeUpdate(sql);

                JOptionPane.showMessageDialog(this, "Employee details saved successfully!");

                // Close connection
                stmt.close();
                con.close();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        new EmployeeDetailsForm();
    }
}

