<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="springForm" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Inspominder</title>
</head>

<body>

<h1>User Reminders list</h1>

<link href="<c:url value="/resources/css/myCustom.css" />" rel="stylesheet">

<div id="column-2">
    <h3><s:message code="inspominder.Reminders"/></h3></br>
    <springForm:form method="POST" commandName="reminderList">

        <ol>
            <c:forEach var="reminder" items="${reminderList}">
                <li>
                    <div><c:out value="${reminder.themeId}"/> : <c:out value="${reminder.text}"/></div>
                </li>
            </c:forEach>
        </ol>
       <%-- <ul>
            <springForm:checkboxes element="li" path="reminder" items="${reminderList}"/>
        </ul>--%>
        <springForm:button> Delete </springForm:button>
    </springForm:form>

</div>
</body>

</html>
