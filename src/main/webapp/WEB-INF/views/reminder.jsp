<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="springForm" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Inspominder</title>
    <link href="<c:url value="/resources/css/myCustom.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/css/bootstrap2.css" />" rel="stylesheet">
</head>

<body>
<h1><s:message code="inspominder.userProfile"/></h1>
<div class="col-md-4 col-md-offset-4" <%--id="column-3"--%>>
    <div class="bs-component">
        <div class="panel panel-primary">
            <div class="panel-heading">
                <%--       // <h3 class="panel-title">Add Reminder</h3>--%>
            </div>
            <div class="panel-body">
                <springForm:form method="delete" modelAttribute="reminder" cssClass="form-style-7">
                    <input type="hidden" name="_method" value="DELETE"/>
                    <img src="<c:url value="${reminder.imageLink}"/>"/></br>
                    <h4 class="text-primary"> ${reminder.text} </h4>
                    <h2>Are you sure You want Delete this reminder ?</h2>
                    <springForm:button class="btn btn-primary btn-offset-primary"> Delete </springForm:button>
                </springForm:form>
            </div>
        </div>
    </div>
</div>
</body>
</html>
