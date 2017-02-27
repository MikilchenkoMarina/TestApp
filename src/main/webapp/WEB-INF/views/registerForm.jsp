<%--
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="springForm" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Inspominder</title>
    <style>

        .error {
            color: red;
            font-weight: bold;
        }

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
<a href="?mylocale=en">English </a> | <a href="?mylocale=de">German </a>
<spring:form method="post" modelAttribute="user" action="#">
    First Name:<springForm:input path="firstName"/>
    <springForm:errors path="firstName" cssClass="error"/> </br>

    Last Name:<springForm:input path="lastName"/>
    <springForm:errors path="lastName" cssClass="error"/> </br>

    Username: <springForm:input path="userName"/>
    <springForm:errors path="userName" cssClass="error"/> </br>

    Password: <springForm:input path="password"/>
    <springForm:errors path="password" cssClass="error"/> </br>

    <spring:button>Register</spring:button>

</spring:form>
</body>
</html>
