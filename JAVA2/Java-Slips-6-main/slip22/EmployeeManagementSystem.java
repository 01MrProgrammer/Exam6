//Q1
//Write a Menu Driven program in Java for the following: Assume Employee table with
//attributes (ENo, EName, Salary) is already created. 1. Insert 2. Update 3. Display 4.
//Exit. 

// package com.slip22;

import java.sql.*;
import java.util.Scanner;
import java.util.*;
import java.io.*;

public class EmployeeManagementSystem {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/user";
    static final String USER = "root";
    static final String PASS = "";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        Scanner scanner = new Scanner(System.in);

        try {
            Class.forName(JDBC_DRIVER);
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            while (true) {
                System.out.println("\nEmployee Management System Menu:");
                System.out.println("1. Insert");
                System.out.println("2. Update");
                System.out.println("3. Display");
                System.out.println("4. Exit");
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        insertEmployee(conn, scanner);
                        break;
                    case 2:
                        updateEmployee(conn, scanner);
                        break;
                    case 3:
                        displayEmployees(conn);
                        break;
                    case 4:
                        System.out.println("Exiting the program...");
                        return;
                    default:
                        System.out.println("Invalid choice. Please enter a number between 1 and 4.");
                }
            }
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
            scanner.close();
        }
    }

//     static void displayEmployees(Connection conn) {
//		// TODO Auto-generated method stub
//    	PreparedStatement statement=conn.prepareStatement("SELECT * FROM Product");
//        ResultSet resultSet = statement.executeQuery();
//        System.out.println("\nProduct Table:");
//        System.out.println("Pid\tPname\tPrice");
//        while (resultSet.next()) {
//            int eno = resultSet.getInt("eno");
//            String ename = resultSet.getString("ename");
//            double salary = resultSet.getDouble("salary");
//            System.out.println(eno + "\t" + ename + "\t" + salary);
//	}

	static void insertEmployee(Connection conn, Scanner scanner) throws SQLException {
        System.out.println("\nEnter employee details:");
        System.out.print("Enter employee number: ");
        int eno = scanner.nextInt();
        scanner.nextLine();
        scanner.nextLine(); // Consume newline character
        System.out.print("Enter employee name: ");
        String ename = scanner.nextLine();
        System.out.print("Enter salary: ");
        double salary = scanner.nextDouble();

        String sql = "INSERT INTO Employee (ENo, EName, Salary) VALUES (?, ?, ?)";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, eno);
        pstmt.setString(2, ename);
        pstmt.setDouble(3, salary);
        int rowsAffected = pstmt.executeUpdate();
        System.out.println(rowsAffected + " row(s) inserted.");
    }

	static void updateEmployee(Connection conn, Scanner scanner) throws SQLException {
        System.out.print("\nEnter employee number to update salary: ");
        int eno = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter new Name: ");
        String ename=scanner.nextLine();
        System.out.print("Enter new salary: ");
        double salary = scanner.nextDouble();

        String sql = "UPDATE Employee SET Salary = ?, Ename = ? WHERE ENo = ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setDouble(1, salary);
        pstmt.setString(2, ename);
        pstmt.setInt(3, eno);
        int rowsAffected = pstmt.executeUpdate();
        System.out.println(rowsAffected + " row(s) updated.");
    }

    static void displayEmployees(Connection conn) throws SQLException {
        Statement stmt = conn.createStatement();
        String sql = "SELECT * FROM Employee";
        ResultSet rs = stmt.executeQuery(sql);

        System.out.println("\nEmployee details:");
        while (rs.next()) {
            int eno = rs.getInt("ENo");
            String ename = rs.getString("EName");
            double salary = rs.getDouble("Salary");
            System.out.println("Employee Number: " + eno + ", Employee Name: " + ename + ", Salary: " + salary);
        }
        rs.close();
    }
}
