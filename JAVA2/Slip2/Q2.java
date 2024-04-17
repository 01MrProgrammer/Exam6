import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Q2")
public class Q2 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        // Client information
        out.println("<h2>Client Information:</h2>");
        out.println("<p>IP Address: " + request.getRemoteAddr() + "</p>");
        out.println("<p>User-Agent (Browser Type): " + request.getHeader("User-Agent") + "</p>");
        
        // Server information
        out.println("<h2>Server Information:</h2>");
        out.println("<p>Server Name: " + request.getServerName() + "</p>");
        out.println("<p>Server Port: " + request.getServerPort() + "</p>");
        out.println("<p>Server Info (OS Type): " + System.getProperty("os.name") + "</p>");
        
        // Servlet information
        out.println("<h2>Loaded Servlets:</h2>");
        String[] servletNames = getServletContext().getServletRegistrationNames().toArray(new String[0]);
        for (String servletName : servletNames) {
            out.println("<p>" + servletName + "</p>");
        }
        
        out.close();
    }
}
