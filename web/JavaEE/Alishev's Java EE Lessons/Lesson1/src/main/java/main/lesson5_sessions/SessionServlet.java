package main.lesson5_sessions;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/session")
public class SessionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter pw = resp.getWriter();
        HttpSession session = req.getSession();

        Integer count = (Integer) session.getAttribute("count");

        if (count == null) {
            count = 1;
            session.setAttribute("count", count);
        }
        session.setAttribute("count", count + 1);

        pw.println("<html>");
        pw.println("<h2> You visited this site " + count + " times</h2>");
        pw.println("</html>");

        resp.setContentType("text/html");

        pw.println(session.getId());

    }
}
