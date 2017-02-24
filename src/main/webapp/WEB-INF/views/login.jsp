<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>

<head>
    <title>Login Page</title>
</head>

<body>
<spring:form method="post" modelAttribute="userJSP" action="welcome-user">

    Name: <spring:input path="name"/> Enter UserName <br/>
    Password: <spring:input path="password"/> Enter password <br/>
    <spring:button>Submit</spring:button>

</spring:form>

</body>

</html>
