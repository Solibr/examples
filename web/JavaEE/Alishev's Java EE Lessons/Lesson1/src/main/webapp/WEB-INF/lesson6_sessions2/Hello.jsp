<html>
<body>

<!-- session - тоже сециальная перменная, которая позволяет получить доступ к сессии -->
<h1> Hello, <%= (String) session.getAttribute("name") %> </h1>


<p> Session ID: <%= session.getId() %> </p>

</body>
</html>