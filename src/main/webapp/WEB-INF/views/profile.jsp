<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="springForm" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <link href="<c:url value="/resources/css/myCustom.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/css/bootstrap2.css" />" rel="stylesheet">
    <div class="page-header" align="center"><h1><s:message code="inspominder.userProfile"/></h1></div>
</head>

<body>
<%--account info panel--%>
<div class="col-md-4">
    <div class="bs-component">
        <div class="panel panel-primary">
            <div class="panel-heading">
                <h3 class="panel-title"><s:message code="inspominder.accountInfo"/></h3>
            </div>
            <div class="panel-body">
                <label><s:message code="inspominder.firstName"/> : </label> ${user.firstName} <br/>
                <label><s:message code="inspominder.lastName"/> : </label> ${user.lastName} <br/>
                <label><s:message code="inspominder.userName"/> : </label> ${user.userName} <br/>
            </div>
        </div>
    </div>
</div>

<%--reminders list panel--%>
<div class="col-md-4">
    <div class="bs-component">
        <div class="panel panel-primary">
            <div class="panel-heading">
                <h3 class="panel-title"><s:message code="inspominder.Reminders"/></h3>
            </div>
            <div class="panel-body">
                <a class="btn btn-primary" href="<c:url value="${user.userName}"/>/reminders"> <s:message
                        code="inspominder.openRemindersPage"/></a></br>
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
                            </li>
                        </c:forEach>
                    </ol>
                </div>
            </div>
        </div>
    </div>
</div>

<%--add reminder Form panel--%>
<div class="col-md-4">
    <div class="bs-component">
        <div class="panel panel-primary">
            <div class="panel-heading">
                <h3 class="panel-title"><s:message code="inspominder.addReminder"/></h3>
            </div>
            <div class="panel-body">

                <springForm:form method="POST" commandName="reminder" enctype="multipart/form-data"
                                 cssClass="form-style-7">
                    <ul>
                        <li>
                            <springForm:label path="text"> <s:message code="inspominder.text"/> </springForm:label>
                            <springForm:input path="text" cssErrorClass="error"/>
                            <springForm:errors path="text" cssClass="error"/>
                        </li>
                        <li>
                            <springForm:label path="imageLink"><s:message code="inspominder.image"/></springForm:label>
                            <input type="file" name="user-file"/>
                        </li>
                    </ul>
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                    <springForm:button class="btn btn-primary"> <s:message code="inspominder.save"/>
                    </springForm:button>
                </springForm:form>
            </div>
        </div>
    </div>
</div>

</body>
</html>
