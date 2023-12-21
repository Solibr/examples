package main.lesson4_redirectAndForward;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

// if fact servlet provides redirect and forward

@WebServlet("/redirect")
public class RedirectServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String type = req.getParameter("type");

        if (type == null) {
            resp.sendRedirect("/redirect?type=input-here-some-shit");
        } else if (type.equals("google")) {
            resp.sendRedirect("https://www.google.com");
        } else if (type.equals("input-here-some-shit")) {
            resp.getWriter().println("Look at the link: input parameter - \"google\", for example");
        } else {
            resp.getWriter().println("I don't know what to do with it");
            resp.sendRedirect("https://www.google.com/search?q=shit&hl=ru&sxsrf=ALiCzsYytDbPA0ikhExrtM2xy6ixexZhFQ:1665085640339&source=lnms&tbm=isch&sa=X&ved=2ahUKEwjjq_Owr8z6AhWHp4sKHSaXBTYQ_AUoAXoECAEQAw&biw=1920&bih=937&dpr=1");
        }
    }
}
