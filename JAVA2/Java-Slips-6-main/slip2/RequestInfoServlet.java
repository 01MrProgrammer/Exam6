//Q2
// package com.slip2;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.Enumeration;

public class RequestInfoServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        out.println("<html><head><title>Request Information</title></head><body>");

        // Client Information
        out.println("<h2>Client Information:</h2>");
        out.println("<b>IP Address:</b> " + request.getRemoteAddr() + "<br>");
        out.println("<b>Browser Type:</b> " + request.getHeader("User-Agent") + "<br>");

        // Server Information
        out.println("<h2>Server Information:</h2>");
        out.println("<b>Server Name:</b> " + request.getServerName() + "<br>");
        out.println("<b>Server Port:</b> " + request.getServerPort() + "<br>");
        out.println("<b>Servlet Container:</b> " + getServletContext().getServerInfo() + "<br>");
        out.println("<b>Operating System:</b> " + System.getProperty("os.name") + "<br>");

        // Loaded Servlets
        out.println("<h2>Loaded Servlets:</h2>");
        ServletContext servletContext = getServletContext();
        Enumeration<String> servletNames = servletContext.getServletNames();
        while (servletNames.hasMoreElements()) {
            String servletName = servletNames.nextElement();
            out.println(servletName + "<br>");
        }

        out.println("</body></html>");
        out.close();
    }
}
