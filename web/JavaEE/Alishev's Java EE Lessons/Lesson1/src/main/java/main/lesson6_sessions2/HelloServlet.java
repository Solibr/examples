package main.lesson6_sessions2;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/hello")
public class HelloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // Принимаем тут данные в сессию, и показываем их в jsp после форварда
        String name = req.getParameter("name");
        if (name == null) {
            name = "Nigga";
        }
        req.getSession().setAttribute("name" , name);
        req.getRequestDispatcher("/WEB-INF/lesson6_sessions2/Hello.jsp").forward(req, resp);
    }
}
