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

    <h3><s:message code="inspominder.Reminders"/></h3></br>

    <springForm:form method="post" commandName="reminderListForm" action="sent-list">


        <c:forEach var="reminder" items="${reminderList}" varStatus="status">
            <tr>
                <td>
                    <spring:bind path="reminderList[${status.index}]">
                        <input type="checkbox" value="<c:out value="${reminder.reminderId}"/>"/> ${reminder.text} </br>
                    </spring:bind>
               <%--     <springForm:checkbox path="reminderId" value="${reminder.reminderId}"/>--%>
                </td>
<%--                <td>${reminder.reminderId} <springForm:hidden path="reminder[${status.index}].reminderId"/></td>


                <td>${reminder.themeId}</td> --%>
                <td>${reminder.text}</td>
            </tr>
        </c:forEach>

        <%--    <ul>
                <springForm:checkboxes element="li" path="reminderList" items="${reminderList}"/>
            </ul>--%>
        <%--    <springForm:form method="POST" commandName="reminderListForm" action="sent-list">

                <table>
                    <tbody>
                    <c:forEach var="reminder" items="${reminderListForm.reminderList}" varStatus="status">
                        <tr>
                            <td>
                                <springForm:checkbox path="reminder[${status.index}].check" value="${reminder.reminderId}" />
        &lt;%&ndash;                       <springForm:checkbox path="reminderId" value="${reminder.reminderId}"/>&ndash;%&gt;
                            </td>
                            <td>${reminder.reminderId} <springForm:hidden path="reminder[${status.index}].reminderId"/></td>

        &lt;%&ndash;
                            <td>${reminder.themeId}</td>
                            <td>${reminder.text}</td>&ndash;%&gt;
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>--%>
        <springForm:button type="submit"> Delete </springForm:button>
    </springForm:form>

</div>
</body>

</html>
