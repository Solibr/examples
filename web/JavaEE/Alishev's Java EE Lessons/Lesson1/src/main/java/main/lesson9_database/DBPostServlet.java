package main.lesson9_database;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

@WebServlet("/dbPost")
public class DBPostServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/lesson9_database/dbPost.html").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter pw = resp.getWriter();

        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=" + "UTF-8");

        /*Map<String, String[]> parameters = req.getParameterMap();
        for (Map.Entry<String, String[]> parameter : parameters.entrySet()) {
            pw.println(parameter.getKey() + " : " + parameter.getValue()[0]);
            //pw.println(parameter.getKey() + " : " + req.getParameter(parameter.getKey()));
        }
        */

        String name = req.getParameter("name");
        int age = Integer.parseInt(req.getParameter("age"));

        // запись данных в БД
        try {
            Connection connection = DBConnection.getConnection();
            Statement statement = connection.createStatement();
            statement.execute("insert into shit(name, age) values('" + name + "', " + age + ")");

        } catch (SQLException e) {
            pw.println("connection failed");
            pw.println(e.getMessage());
            log(e.getMessage());
            StackTraceElement[] stack = e.getStackTrace();
            for (StackTraceElement element: stack) {
                log(element.toString());
            }
        }

        // редирект на этот же сервлет, но будет снова GET
        resp.sendRedirect("/dbPost");
    }
}
