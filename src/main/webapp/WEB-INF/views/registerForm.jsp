<%--
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="springForm" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Inspominder</title>
    <link href="<c:url value="/resources/css/myCustom.css" />" rel="stylesheet">
</head>
<br>
<h1>Register</h1>
<a href="?mylocale=en">English </a> | <a href="?mylocale=de">German </a>
<springForm:form method="POST" commandName="user">

    <springForm:label path="firstName" cssErrorClass="error"> First Name:</springForm:label>
    <springForm:input path="firstName" cssErrorClass="error"/>
    <springForm:errors path="firstName" cssClass="error"/> </br>

    <springForm:label path="lastName" cssErrorClass="error"> Last Name: </springForm:label>
    <springForm:input path="lastName" cssErrorClass="error"/>
    <springForm:errors path="lastName" cssClass="error"/> </br>

    <springForm:label path="userName" cssErrorClass="error"> Username:</springForm:label>
    <springForm:input path="userName" cssErrorClass="error"/>
    <springForm:errors path="userName" cssClass="error"/> </br>

    <springForm:label path="password" cssErrorClass="error"> Password: </springForm:label>
    <springForm:password path="password" cssErrorClass="error"/>
    <springForm:errors path="password" cssClass="error"/> </br>

    <springForm:button>Register</springForm:button>

</springForm:form>
</body>
</html>
