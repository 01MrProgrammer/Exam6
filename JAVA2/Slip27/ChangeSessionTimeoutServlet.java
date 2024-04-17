import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/ChangeSessionTimeoutServlet")
public class ChangeSessionTimeoutServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Get the session
        HttpSession session = request.getSession();

        // Set session inactive time interval to 5 minutes (300 seconds)
        session.setMaxInactiveInterval(300);

        response.getWriter().append("Session inactive time interval changed to 5 minutes.");
    }
}


