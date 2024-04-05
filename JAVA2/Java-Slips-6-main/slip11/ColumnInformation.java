//Q2 
//Write a Java program to display information about all columns in the DONAR table
//using ResultSetMetaData. 

// package com.slip11;

import java.sql.*;

public class ColumnInformation {
    // JDBC URL, username, and password
    static final String JDBC_URL = "jdbc:mysql://localhost:3306/user";
    static final String USERNAME = "root";
    static final String PASSWORD = "";

    public static void main(String[] args) {
        try {
            // Connect to the database
            Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);

            // Create a statement
            Statement statement = connection.createStatement();

            // Execute query to retrieve all columns from DONAR table
            ResultSet resultSet = statement.executeQuery("SELECT * FROM donor WHERE 1=0"); // We use WHERE 1=0 to get empty result set

            // Get the ResultSetMetaData
            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();

            // Display column information
            System.out.println("Column Information for DONAR table:");
            for (int i = 1; i <= columnCount; i++) {
                System.out.println("Column Name: " + metaData.getColumnName(i));
                System.out.println("Column Type: " + metaData.getColumnTypeName(i));
                System.out.println("Column Size: " + metaData.getColumnDisplaySize(i));
                System.out.println("Is Nullable: " + (metaData.isNullable(i) == ResultSetMetaData.columnNullable ? "Yes" : "No"));
                System.out.println("-------------------------------------");
            }

            // Close resources
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
