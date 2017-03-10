<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="springForm" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <link href="<c:url value="/resources/css/myCustom.css" />" rel="stylesheet">
</head>

<body>

<h1><s:message code="inspominder.userProfile"/></h1>

<!-- /logout -->
<div>

    <c:if test="${pageContext.request.userPrincipal.name != null}">
        <form id="logoutForm" method="POST" action="${contextPath}/logout">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </form>
        <h2>Welcome ${pageContext.request.userPrincipal.name} | <a onclick="document.forms['logoutForm'].submit()">Logout</a>
        </h2>
    </c:if>

</div>


<div id="column-1">
    <h2><s:message code="inspominder.firstName"/> : </h2> ${user.firstName} <br/>
    <h2><s:message code="inspominder.lastName"/> : </h2> ${user.lastName} <br/>
    <h2><s:message code="inspominder.userName"/> : </h2> ${user.userName} <br/>
    <h2><s:message code="inspominder.password"/> : </h2> ${user.password} <br/>

</div>

<div id="column-2">
    <h3><s:message code="inspominder.Reminders"/></h3></br>

    <a href="<c:url value="${user.userId}"/>/reminders"> Reminders List</a>
    <ol>
        <c:forEach var="reminder" items="${reminderList}">
            <li>
                <div><c:out value="${reminder.themeId}"/> : <c:out value="${reminder.text}"/></div>
            </li>
        </c:forEach>
    </ol>


</div>
<div id="column-3">
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
</div>

<!-- /container -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>

</body>

</html>
