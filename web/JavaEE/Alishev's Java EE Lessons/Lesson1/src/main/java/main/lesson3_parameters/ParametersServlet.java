package main.lesson3_parameters;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

@WebServlet("/params")
public class ParametersServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter pw = resp.getWriter();

        pw.println("<html>");

        String name = req.getParameter("name");

        if (name == null) {
            name = "world";
            pw.println("<h3> please, send parameter \"name\" in your query </h3>");
        }
        pw.println("<h1>Hello, " + name + "</h1>");
        pw.println("<h3> Parameters </h3>");
        Map<String, String[]> parameters = req.getParameterMap();
        for (Map.Entry<String, String[]> item : parameters.entrySet()) {
            pw.println("<h4> " + "Key: " + item.getKey()
                    + "\t Value: " + foo(item.getValue()) + " </h4>");
        }


        pw.println("</html>");
    }

    public String foo(String[] arr) {
        StringBuilder str = new StringBuilder();
        //Arrays.stream(arr.getValue());
        for (String s : arr) {
            str.append(s);
            str.append(" ");
        }
        return str.toString();
    }
}
