<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="springForm" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <link href="<c:url value="/resources/css/myCustom.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/css/bootstrap2.css" />" rel="stylesheet">
</head>

<body>

<h1><s:message code="inspominder.userProfile"/></h1>
<%--account info panel--%>
<div class="col-md-4">
    <div class="bs-component">
        <div class="panel panel-primary">
            <div class="panel-heading">
                <h3 class="panel-title">Account info</h3>
            </div>
            <div class="panel-body">
                <label><s:message code="inspominder.firstName"/> : </label> ${user.firstName} <br/>
                <label><s:message code="inspominder.lastName"/> : </label> ${user.lastName} <br/>
                <label><s:message code="inspominder.userName"/> : </label> ${user.userName} <br/>
                <label><s:message code="inspominder.password"/> : </label> ${user.password} <br/>

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
                <div class="scroll">
                    <h2><a href="<c:url value="${user.userId}"/>/reminders"> Open Reminders List</a></h2>
                    <ol class="custom-counter">
                        <c:forEach var="reminder" items="${reminderList}">
                            <li class="list-group-item">
                                <img id="reminder-image" src="<c:url value="${reminder.imageLink}"/>"/>
                                <h4 class="text-primary"><c:out value="${reminder.text}"/></h4>
                            </li>
                        </c:forEach>
                    </ol>
                </div>
            </div>
        </div>
    </div>
</div>

<%--add reminder Form panel--%>
<div class="col-md-4" <%--id="column-3"--%>>
    <div class="bs-component">
        <div class="panel panel-primary">
            <div class="panel-heading">
                <h3 class="panel-title">Add Reminder</h3>
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
                            <springForm:label path="imageLink"><s:message code="inspominder.theme"/></springForm:label>
                            <input type="file" name="user-file"/>
                        </li>
                    </ul>
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                    <springForm:button class="btn btn-primary"> <s:message code="inspominder.addReminder"/>
                    </springForm:button>
                </springForm:form>

                <%--  /panel-body    --%>
            </div>
        </div>
    </div>

</div>

</body>

</html>
