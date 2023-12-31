
<!-- Специальная строка, задающая возможность писать часть кода на Java -->
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!-- В web.xml маппинг этого файла не задан. Доступ к этой странице можно получить по URL /lesson1/firstJsp.jsp. Он соответствует пути внутри папки с приложением -->

<html>
    <head>
        <title>First JSP</title>
    </head>
    <body>
        <h2> Hello JSP! </h2>
        <p>

            <!-- Следующий тег позволяет писать Java код, который просто выполняется -->
            <%

                // требуется обращаться к классу Date по полному имени, потому что здесь не проведён импорт
                java.util.Date now = new java.util.Date();
                String str = "Текущая дата: " + now;
            %>

            <!-- Похожий тег позволяют писать Java код, который должен вернуть String. Точку с запятой ставить не нужно -->
            <%= str %>

            <!-- У Java кода внедрённого в jsp есть особенность: специальные переменные, например out, которая не нуждается в объявлении -->
            <%
                for (int i = 0; i < 10; i++) {
                    out.println("<p> Hello beatch! " + i + " </p>");
                }
            %>


        </p>
    </body>
</html>
