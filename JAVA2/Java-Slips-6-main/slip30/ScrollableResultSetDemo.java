//Q2
//Write a Java Program for the implementation of scrollable ResultSet. Assume Teacher
//table with attributes (TID, TName, Salary) is already created. 

// package com.slip30;

import java.sql.*;

public class ScrollableResultSetDemo {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/user";
    static final String USER = "root";
    static final String PASS = "";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;

        try {
            Class.forName(JDBC_DRIVER);
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connected to database");

            // Create a scrollable ResultSet
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            String sql = "SELECT * FROM teacher";
            ResultSet rs = stmt.executeQuery(sql);

            // Move cursor to the last row
            rs.last();

            // Display data from the last row
            System.out.println("Last Teacher Details:");
            System.out.println("TID: " + rs.getInt("Tid"));
            System.out.println("TName: " + rs.getString("Tname"));
            System.out.println("Salary: " + rs.getDouble("Salary"));

            // Move cursor to the first row
            rs.first();

            // Display data from the first row
            System.out.println("\nFirst Teacher Details:");
            System.out.println("TID: " + rs.getInt("Tid"));
            System.out.println("TName: " + rs.getString("Tname"));
            System.out.println("Salary: " + rs.getDouble("Salary"));

            // Move cursor to the third row
            rs.absolute(3);

            // Display data from the third row
            System.out.println("\nTeacher Details at 3rd row:");
            System.out.println("TID: " + rs.getInt("Tid"));
            System.out.println("TName: " + rs.getString("Tname"));
            System.out.println("Salary: " + rs.getDouble("Salary"));

            // Move cursor to the previous row
            rs.previous();

            // Display data from the previous row
            System.out.println("\nTeacher Details at previous row:");
            System.out.println("TID: " + rs.getInt("Tid"));
            System.out.println("TName: " + rs.getString("Tname"));
            System.out.println("Salary: " + rs.getDouble("Salary"));

            // Move cursor to the next row
            rs.next();

            // Display data from the next row
            System.out.println("\nTeacher Details at next row:");
            System.out.println("TID: " + rs.getInt("Tid"));
            System.out.println("TName: " + rs.getString("Tname"));
            System.out.println("Salary: " + rs.getDouble("Salary"));

            // Move cursor to the fourth row
            rs.absolute(4);

            // Display data from the fourth row
            System.out.println("\nTeacher Details at 4th row:");
            System.out.println("TID: " + rs.getInt("Tid"));
            System.out.println("TName: " + rs.getString("Tname"));
            System.out.println("Salary: " + rs.getDouble("Salary"));

            rs.close();
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) stmt.close();
            } catch (SQLException se2) {
            }
            try {
                if (conn != null) conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }
}
