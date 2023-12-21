package main.lesson7_cookies;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/delete-cookies")
public class DeleteCookiesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();
        if (cookies.length > 0) {
            Cookie cookie = cookies[0];

            // Устанавливаем время жизни куки равным нулю - это заставит браузер клиента при получении ответа сразу же удалить эту куку.
            cookie.setMaxAge(0);

            // Специальное значение времени жизни куки, при котором она живёт до первого закрытия браузера. Для значений больше 0 заакрытие браузера не имеет значения
            // cookie.setMaxAge(-1);

            resp.addCookie(cookie);
        }

        PrintWriter pw = resp.getWriter();
        pw.println("some cookie deleted");
    }
}
