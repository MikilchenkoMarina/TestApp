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

<div id="column-2">
    <springForm:form method="delete" modelAttribute="reminder" cssClass="form-style-7">
        <input type="hidden" name="_method" value="DELETE"/>
        ${reminder.reminderId}
        <img src="<c:url value="${reminder.imageLink}"/>"/>
        ${reminder.text} </br>

        <h2>Are you sure You want Delete this reminder ?</h2>


        <springForm:button> Delete </springForm:button>
    </springForm:form>

</div>

</body>

</html>
