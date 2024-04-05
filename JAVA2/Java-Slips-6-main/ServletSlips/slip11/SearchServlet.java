// package com.slip11;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class SearchServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Retrieve customer number from the request
        String customerNumber = request.getParameter("customerNumber");

        // Perform database search
        // Assuming you have established a database connection and prepared a statement for the search
        try {
        	
        	Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/user", "root", "");
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM customer WHERE cno = ?");
            stmt.setString(1, customerNumber);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                // If customer found, display customer details
                String customerName = rs.getString("cname");
                String customerAddress = rs.getString("caddress");
                out.println("<h2>Customer Details</h2>");
                out.println("<p>Customer Number: " + customerNumber + "</p>");
                out.println("<p>Name: " + customerName + "</p>");
                out.println("<p>Address: " + customerAddress + "</p>");
            } else {
                // If customer not found, display error message
                out.println("<h2>Error</h2>");
                out.println("<p>Customer with number " + customerNumber + " not found.</p>");
            }

            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
            out.println("<h2>Error</h2>");
            out.println("<p>Database error occurred.</p>");
        } catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
