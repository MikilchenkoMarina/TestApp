<%--
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Inspominder</title>
    <style>
        H1 {
            color: #000080;
            font-size: 200%;
            font-family: Arial, Verdana, sans-serif;
        }

        body {
            background-color: powderblue;
        }

        input {
            display: inline-block;
            margin-top: 2em;
            padding: 1em 2em 1em 2em;
            border-radius: 7px;
            border: 1px solid #373F34;
        }
    </style>
    <%--<link rel="stylesheet" type="text/css" href="<c:url value="/resources/myCustom.css" />">--%>
</head>
<body>
<h1>Register</h1>
<form method="POST">
    First Name:<input type="text" name="firstName"/> </br>
    Last Name: <input type="text" name="lastName"/> </br>
    Username: <input type="text" name="userName"/> </br>
    Password: <input type="text" name="password"/> </br>
    <input type="submit" value="Register"/>
</form>

</body>
</html>
