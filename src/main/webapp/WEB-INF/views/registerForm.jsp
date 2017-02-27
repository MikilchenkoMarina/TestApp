<%--
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<title>Inspominder</title>
<%--    <style>
        body {background-color: powderblue;}
        h1   {color: blue;}
        p    {color: red;}
    </style>--%>
<link rel="stylesheet" type="text/css" href="<c:url value="/webapp/WEB-INF\css\myCustom.css" />">
    </head>
    <body>
    <h1>Register</h1>
    <form method="POST">
    First Name: <input type="text" name="firstName"/> </br>
    Last Name: <input type="text" name="lastName"/> </br>
    Username: <input type="text" name="username"/> </br>
    Password: <input type="text" name="password"/> </br>
    <input type="submit" value="Register"/>
    </form>

    </body>
    </html>
