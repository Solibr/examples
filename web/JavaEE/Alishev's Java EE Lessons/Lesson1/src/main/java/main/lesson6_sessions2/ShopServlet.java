package main.lesson6_sessions2;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.TreeMap;

@WebServlet("/shop")
public class ShopServlet extends HttpServlet {
    private static int usersCounter = 0;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter pw = resp.getWriter();
        resp.setContentType("text/html;charset=UTF-8");

        HttpSession session = req.getSession();
        Cart cart = (Cart) session.getAttribute("cart");

        if (cart == null) {
            cart = new Cart();
        }

        String name = req.getParameter("name");
        if (name != null) {
            int quantity;
            if (req.getParameter("quantity") == null) {
                quantity = 0;
            } else {
                quantity = Integer.parseInt(req.getParameter("quantity"));
            }

            Item newItem = new Item(name, quantity);
            cart.addItem(newItem);
            session.setAttribute("cart", cart);
        }

        TreeMap<String, Item> itemList = cart.getItemList();

        pw.println("<!DOCTYPE html>");
        pw.println("<html>");
        pw.println("<body>");
        pw.println("<h2>Сейчас в корзине</h2>");
        pw.println("<br/");
        pw.println("<table>");
        pw.println("<tr>");
        pw.println("<th>Товар</th>");
        pw.println("<th>Количество</th>");
        pw.println("</tr>");
        pw.println("<br/");
        for (Map.Entry<String, Item> entry : itemList.entrySet()) {
            pw.println("<tr>");
            pw.println("<td>" + entry.getValue().getName() + "</td>");
            pw.println("<td>" + entry.getValue().getQuantity() + "</td>");
            pw.println("</tr>");
            pw.println("<br/");
        }
        pw.println("</table>");
        pw.println("</body>");
        pw.println("</html>");

        pw.println("<br/><br/><br/><br/><br/><br/><br/><br/>");
        pw.println("Session ID: " + session.getId());
    }
}
