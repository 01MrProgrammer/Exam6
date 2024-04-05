// package com.slip18;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class StudentDetailsServlet extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        // Retrieving student details from request parameters
        int seatNo = Integer.parseInt(request.getParameter("seatNo"));
        String studName = request.getParameter("studName");
        String studentClass = request.getParameter("studentClass");
        int totalMarks = Integer.parseInt(request.getParameter("totalMarks"));
        
        // Calculating percentage
        double percentage = (totalMarks / 500.0) * 100;
        
        // Calculating grade based on percentage
        String grade;
        if (percentage >= 90) {
            grade = "A+";
        } else if (percentage >= 80) {
            grade = "A";
        } else if (percentage >= 70) {
            grade = "B";
        } else if (percentage >= 60) {
            grade = "C";
        } else if (percentage >= 50) {
            grade = "D";
        } else {
            grade = "Fail";
        }
        
        // Displaying student details on the web page
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Student Details</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h2>Student Details</h2>");
        out.println("<p>Seat No: " + seatNo + "</p>");
        out.println("<p>Name: " + studName + "</p>");
        out.println("<p>Class: " + studentClass + "</p>");
        out.println("<p>Total Marks: " + totalMarks + "</p>");
        out.println("<p>Percentage: " + percentage + "%</p>");
        out.println("<p>Grade: " + grade + "</p>");
        out.println("</body>");
        out.println("</html>");
        
        out.close();
    }
}
