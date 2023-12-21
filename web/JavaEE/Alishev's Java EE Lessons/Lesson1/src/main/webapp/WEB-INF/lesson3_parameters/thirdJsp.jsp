<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
    <head>
        <title>Third JSP</title>
    </head>
    <body>

        <h3> Демонстрация обработки параметров <br/> запроса в JSP </h3>
        <p>
            <%

                // request - это специальная переменная, которая не нуждается в объявлении в jsp
                String name = request.getParameter("name");
                if (name == null) {
                    name = "nigga. You stupid forget to set parameters, nieeegga-a-a";
                }
                out.println("Hello, " + name);
            %>

        </p>

    </body>
</html>
