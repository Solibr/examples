package main.lesson4_redirectAndForward;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/forward")
public class ForwardServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String type = req.getParameter("type");
        RequestDispatcher dispatcher;

        if (type == null) {
            resp.sendRedirect("/forward?type=input-here-some-shit");
        } else if (type.equals("input-here-some-shit")) {
            resp.getWriter().println("Look at the link: input some parameters: file, url, pic, some");
        } else if (type.equals("file")) {
            dispatcher = req.getRequestDispatcher("/WEB-INF/lesson2/secondJsp.jsp");
            dispatcher.forward(req, resp);
        } else if (type.equals("some")) {
            dispatcher = req.getRequestDispatcher("/params");
            dispatcher.forward(req, resp);
        } else if (type.equals("url")) {
            dispatcher = req.getRequestDispatcher("/jsp2?name=supNigga");
            dispatcher.forward(req, resp);
        } else if(type.equals("pic")) {
            dispatcher = req.getRequestDispatcher("/WEB-INF/lesson4_redirectAndForward/pic.png");
            dispatcher.forward(req, resp);
        } else {
            resp.getWriter().println("incorrect parameter");
        }

    }
}
