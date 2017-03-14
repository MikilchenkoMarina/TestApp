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

<div class="col-md-4">
    <div class="bs-component">
        <div class="panel panel-primary">
            <div class="panel-heading">
                <h1 class="lead"><s:message code="inspominder.Reminders"/></h1>
            </div>
            <div class="panel-body">
                <div class="scroll">
                    <ol class="custom-counter">
                        <c:forEach var="reminder" items="${reminderList}">

                            <li>


                                <div class="media-body">
                                    <div class="snippet">
                                        <a class="pull-left"> <img src="<c:url value="${reminder.imageLink}"/>"/> </a>
                                        <p><h4><c:out value="${reminder.text}"/></h4></p>
                                    </div>
                                </div>
                                <a class="btn btn-primary" href="<c:url value="reminders/${reminder.reminderId}"/>">
                                    Delete this reminder </a>
                            </li>
                        </c:forEach>
                    </ol>
                </div>
                <%--/!scroll--%>
            </div>
        </div>
    </div>
</div>
</body>
</html>
