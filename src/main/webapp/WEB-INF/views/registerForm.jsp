<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="springForm" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>Inspominder</title>
    <link href="<c:url value="/resources/css/myCustom.css" />" rel="stylesheet">
</head>

<body>
<h1><s:message code="inspominder.register"/></h1></br>

<springForm:form method="POST" commandName="user" cssClass="form-style-7">
    <ul>
        <li>
            <springForm:label path="firstName"> <s:message code="inspominder.firstName"/></springForm:label>
            <springForm:input path="firstName" cssErrorClass="error"/>
            <springForm:errors path="firstName" cssClass="error"/>
        </li>

        <li>
            <springForm:label path="lastName"> <s:message code="inspominder.lastName"/></springForm:label>
            <springForm:input path="lastName" cssErrorClass="error"/>
            <springForm:errors path="lastName" cssClass="error"/>
        </li>
        <li>
            <springForm:label path="userName"> <s:message
                    code="inspominder.userName"/></springForm:label>
            <springForm:input path="userName" cssErrorClass="error"/>
            <springForm:errors path="userName" cssClass="error"/>
        </li>
        <li>
            <springForm:label path="password"> <s:message
                    code="inspominder.password"/></springForm:label>
            <springForm:input path="password" cssErrorClass="error"/>
            <springForm:errors path="password" cssClass="error"/>
        </li>
    </ul>
    <springForm:button> <s:message code="inspominder.register"/></springForm:button>
</springForm:form>
</body>
</html>
