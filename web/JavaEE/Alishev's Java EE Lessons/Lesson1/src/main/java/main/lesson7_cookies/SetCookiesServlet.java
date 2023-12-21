package main.lesson7_cookies;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/set-cookies")
public class SetCookiesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // Куки - пара "Ключ:значение", обязательно строковые
        Cookie cookie1 = new Cookie("name", "John");
        Cookie cookie2 = new Cookie("type", "new");
        Cookie cookie3 = new Cookie("color", "black");

        // устанавливаем время их жизни в секундах в браузере клиента.
        cookie1.setMaxAge(60 * 60);
        cookie2.setMaxAge(15);
        cookie3.setMaxAge(-1);      // -1 значение по умолчанию и обозначает, что куки живёт до первого закрытия браузера.

        resp.addCookie(cookie1);
        resp.addCookie(cookie2);
        resp.addCookie(cookie3);

        PrintWriter pw = resp.getWriter();
        pw.println("cookie has just set");
    }
}
