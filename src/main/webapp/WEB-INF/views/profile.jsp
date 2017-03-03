<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="springForm" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Inspominder</title>
</head>

<body>

<h1><s:message code="inspominder.userProfile"/></h1>

<link href="<c:url value="/resources/css/myCustom.css" />" rel="stylesheet">


<h2><s:message code="inspominder.firstName"/> : ${user.firstName} </h2> <br/>
<h2><s:message code="inspominder.lastName"/>: ${user.lastName} </h2> <br/>
<h2><s:message code="inspominder.userName"/>: ${user.userName} </h2> <br/>
<h2><s:message code="inspominder.password"/>: ${user.password}</h2> <br/>
<h3><s:message code="inspominder.Reminders"/></h3></br>

<ol>
    <c:forEach var="reminder" items="${reminderList}">
        <li>
            <div><c:out value="${reminder.themeId}"/> : <c:out value="${reminder.text}"/></div>
        </li>
    </c:forEach>
</ol>


<springForm:form method="POST" commandName="reminder" cssClass="form-style-7">
    <ul>
        <li>
            <springForm:label path="text"> <s:message code="inspominder.text"/> </springForm:label>
            <springForm:input path="text" cssErrorClass="error"/>
            <springForm:errors path="text" cssClass="error"/>
        </li>

        <li>
            <springForm:label path="themeId"><s:message code="inspominder.theme"/></springForm:label>
            <springForm:input path="themeId" cssErrorClass="error"/>
            <springForm:errors path="themeId" cssClass="error"/>
        </li>
    </ul>
    <springForm:button> <s:message code="inspominder.addReminder"/> </springForm:button>
</springForm:form>

</body>

</html>
