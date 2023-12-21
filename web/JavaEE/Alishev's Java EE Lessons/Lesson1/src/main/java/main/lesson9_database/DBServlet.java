package main.lesson9_database;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet("/db")
public class DBServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        PrintWriter pw = resp.getWriter();
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        // Connection connection;
        // Statement statement;
        try (Connection connection = DriverManager.getConnection("jdbc:postgresql:mydatabase",
                "postgres", "testtest") ) {

            Statement statement = connection.createStatement();

            req.setCharacterEncoding("UTF-8");
            resp.setContentType("text/html; charset=" + "UTF-8");

            ResultSet rs = statement.executeQuery("select * from shit");
            int columnCount = rs.getMetaData().getColumnCount();

            pw.println("<html>");
            pw.println("<body>");

            pw.println("<table>");
            pw.println("<tr>");
            for (int i = 0; i < columnCount; i++) {
                pw.print("\t<th>");
                pw.print(rs.getMetaData().getColumnName(i + 1));
                pw.println("</th>");
            }
            pw.println("</tr>");


            while (rs.next()) {
                pw.println("<tr>");
                for(int j = 0; j < columnCount; j++) {
                    pw.print("\t<td>");
                    pw.print(rs.getString(j + 1));
                    pw.println("</td>");
                }
                pw.println("</tr>");
            }
            pw.println("</table>");

            pw.println("</body>");
            pw.println("</html>");


        } catch (SQLException e) {
            pw.println("connection failed");
            pw.println(e.getMessage());
            log(e.getMessage());
            StackTraceElement[] stack = e.getStackTrace();
            for (StackTraceElement element: stack) {
                log(element.toString());
            }
        }
    }
}
