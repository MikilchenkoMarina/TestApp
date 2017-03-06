<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="springForm" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Inspominder</title>
</head>

<body>
<h1>User Reminders list</h1>

<link href="<c:url value="/resources/css/myCustom.css" />" rel="stylesheet">
    <table>
        <tbody>

        <c:forEach var="reminder" items="${reminderListForm.reminderList}">
        <tr><td>${reminder.text}</td> </tr>
        </c:forEach>
 <%--       <c:forEach items="${resultList}" var="reminder" varStatus="status">
            <tr>
                <td>${reminder.text}</td>

            </tr>
        </c:forEach>--%>
        </tbody>
    </table>

</body>
</html>
