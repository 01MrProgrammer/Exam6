// package com.slip15;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/VisitCounterServlet")
public class VisitCounterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Get the array of cookies associated with this domain
        Cookie[] cookies = request.getCookies();
        
        // Initialize visit count
        int visitCount = 0;

        if (cookies != null) {
            // Check if a cookie named "visitCount" exists
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("visitCount")) {
                    visitCount = Integer.parseInt(cookie.getValue());
                    break;
                }
            }
        }

        // Increase visit count by 1
        visitCount++;

        // Create or update the "visitCount" cookie
        Cookie visitCookie = new Cookie("visitCount", String.valueOf(visitCount));
        response.addCookie(visitCookie);

        // Display welcome message or visit count
        out.println("<html><head><title>Visit Counter</title></head><body>");
        if (visitCount == 1) {
            out.println("<h2>Welcome to the page!</h2>");
        } else {
            out.println("<h2>You have visited this page " + visitCount + " times.</h2>");
        }
        out.println("</body></html>");
    }
}
