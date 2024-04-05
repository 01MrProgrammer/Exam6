
// package com.slip26;

import java.sql.*;

public class DeleteEmployeeDetails {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/user";
    static final String USER = "root";
    static final String PASS = "";

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java DeleteEmployeeDetails <employeeID>");
            return;
        }

        int empId = Integer.parseInt(args[0]);

        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            Class.forName(JDBC_DRIVER);
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            String sql = "DELETE FROM employee WHERE Eno = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, empId);

            int rowsDeleted = pstmt.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Employee details deleted successfully.");
            } else {
                System.out.println("No employee found with ID: " + empId);
            }
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstmt != null) pstmt.close();
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
