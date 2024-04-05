//Q2
//Write a Java Program to create a PROJECT table with field’s project_id, Project_name,
//Project_description, Project_Status. Insert values in the table. Display all the details of
//the PROJECT table in a tabular format on the screen.(using swing). 

// package com.slip12;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.util.*;

public class ProjectTableGUI extends JFrame {

    private JTable table;
    private JScrollPane scrollPane;

    public ProjectTableGUI() {
        setTitle("Project Details");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        String[] columnNames = {"Project ID", "Project Name", "Description", "Status"};
        Object[][] data = getProjectData();

        table = new JTable(data, columnNames);
        scrollPane = new JScrollPane(table);
        getContentPane().add(scrollPane, BorderLayout.CENTER);
    }

    private Object[][] getProjectData() {
        Object[][] data = null;
        int Project_id;
        String Project_name, Project_desc, Project_status;
        Scanner sc=new Scanner(System.in);
        try {
            // Establish database connection
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/user", "root", "");

            // Create statement
            Statement statement = connection.createStatement();

            //insert data into project database
            
            System.out.println("Enter Project id: ");
			Project_id=sc.nextInt();
			System.out.println("Enter Project Name: ");
			sc.nextLine();			
			Project_name=sc.nextLine();
			System.out.println("Enter Project decription: ");
			Project_desc=sc.nextLine();
			System.out.println("Enter Project status: ");
			Project_status=sc.nextLine();

			PreparedStatement st=connection.prepareStatement("insert into project values(?,?,?,?)");
			st.setInt(1, Project_id);
			st.setString(2, Project_name);
			st.setString(3, Project_desc);
			st.setString(4, Project_status);
			st.executeUpdate();
			
			System.out.println("Records Inserted Successfully");
            
            // Execute query
            ResultSet resultSet = statement.executeQuery("SELECT * FROM project");

            // Get number of rows
            resultSet.last();
            int rowCount = resultSet.getRow();
            resultSet.beforeFirst();

            // Initialize data array
            data = new Object[rowCount][4];

            // Populate data array
            int row = 0;
            while (resultSet.next()) {
                data[row][0] = resultSet.getInt("project_id");
                data[row][1] = resultSet.getString("project_name");
                data[row][2] = resultSet.getString("project_description");
                data[row][3] = resultSet.getString("project_status");
                row++;
            }

            // Close connections
            resultSet.close();
            statement.close();
            connection.close();
            
            System.out.println("Records Displayed on GUI screen in Tabular Format.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return data;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ProjectTableGUI projectTableGUI = new ProjectTableGUI();
            projectTableGUI.setVisible(true);
        });
    }
}
