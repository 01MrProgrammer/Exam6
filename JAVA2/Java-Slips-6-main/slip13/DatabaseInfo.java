//Q1
//Write a Java program to display information about the database and list all the tables in
//the database. (Use DatabaseMetaData). 

// package com.slip13;

import java.sql.*;

public class DatabaseInfo {

    public static void main(String[] args) {
        Connection connection = null;
        try {
            // Connect to the database
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/school_database", "root", "");

            // Get DatabaseMetaData
            DatabaseMetaData metaData = connection.getMetaData();

            // Display database information
            System.out.println("Database Information:");
            System.out.println("Database Product Name: " + metaData.getDatabaseProductName());
            System.out.println("Database Product Version: " + metaData.getDatabaseProductVersion());
            System.out.println("Driver Name: " + metaData.getDriverName());
            System.out.println("Driver Version: " + metaData.getDriverVersion());

            // Display list of tables
            ResultSet tables = metaData.getTables(null, null, "%", new String[]{"TABLE"});
            System.out.println("\nTables in the Database:");
            while (tables.next()) {
                String tableName = tables.getString("TABLE_NAME");
                System.out.println(tableName);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close the connection
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
