package com.slip19;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class LoginServletDB extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        // Retrieve username and password from the request
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        // Database connection parameters
        String url = "jdbc:mysql://localhost:3306/user";
        String user = "root";
        String dbPassword = "";
        
        // Database query
        String query = "SELECT * FROM users WHERE username=? AND password=?";
        
        try {
            // Load MySQL JDBC driver
            Class.forName("com.mysql.jdbc.Driver");
            
            // Establish database connection
            Connection conn = DriverManager.getConnection(url, user, dbPassword);
            
            // Prepare SQL statement
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            
            // Execute query
            ResultSet rs = pstmt.executeQuery();
            
            if (rs.next()) {
                // User found in database
                out.println("<html><body>");
                out.println("<h2>Welcome " + username + "</h2>");
                out.println("</body></html>");
            } else {
                // User not found in database
                out.println("<html><body>");
                out.println("<h2>Error: Invalid username or password</h2>");
                out.println("</body></html>");
            }
            
            // Close resources
            rs.close();
            pstmt.close();
            conn.close();
            
        } catch (Exception e) {
            out.println("<html><body>");
            out.println("<h2>Error: " + e.getMessage() + "</h2>");
            out.println("</body></html>");
            e.printStackTrace();
        }
        
        out.close();
    }
}
