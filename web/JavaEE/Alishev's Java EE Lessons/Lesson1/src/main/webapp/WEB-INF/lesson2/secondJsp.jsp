<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!--
 Этот файл находится в папке WEB-INF.
 Это не позволяет обратиться к нему по адресу файла,
 К файлу по-прежнему можно обратиться по url описанному в web.xml
 -->

<html>
    <head>
        <title>Second JSP</title>
    </head>
    <body>
        <h2> Hello JSP! Again... </h2>
        <p>

            <!-- это дирректива. Позволяет написать что-то что не является выражением. Например, так можно импортировать пакеты java или пользовательские классы -->
            <%@ page import="java.util.Date, main.lesson2.InfoHolder"%>

            <!-- теперь можно обращаться к классу по короткому имени -->
            <%= new Date() %>
        </p>
        <p>
            <%
                // если бы не было диррективы с импортом, пришлось бы обращаться к классам по полному имени
                // main.lesson2.InfoHolder info = new main.lesson2.InfoHolder();

                InfoHolder info = new InfoHolder();
                String str = info.getInfo();
                out.println(str + ".\t <--- Строка получена из другого класса");
            %>
        </p>

    </body>
</html>
