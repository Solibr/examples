package main;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class FirstServlet extends javax.servlet.http.HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException {
        PrintWriter pw = response.getWriter();
        pw.println("<html>");
        for (int i = 0; i < 10; i++) {
            pw.println("<h1> Hello Egor!  </h1>");
        }

        pw.println("</html>");
    }

}
