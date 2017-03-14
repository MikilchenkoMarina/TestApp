<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="springForm" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>Inspominder</title>
    <link href="<c:url value="/resources/css/myCustom.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/css/bootstrap2.css" />" rel="stylesheet">
</head>

<body>
<h1><s:message code="inspominder.register"/></h1></br>

<div class="col-md-4 col-md-offset-4">
    <div class="bs-component">
        <div class="panel panel-primary">
            <div class="panel-heading">
                <h3 class="panel-title">Add Reminder</h3>
            </div>
            <div class="panel-body">

                <springForm:form method="POST" commandName="user" cssClass="form-style-7">
                    <ul>
                        <li>
                            <springForm:label path="firstName"> <s:message
                                    code="inspominder.firstName"/></springForm:label>
                            <springForm:input path="firstName" cssErrorClass="error"/>
                            <springForm:errors path="firstName" cssClass="error"/>
                        </li>

                        <li>
                            <springForm:label path="lastName"> <s:message
                                    code="inspominder.lastName"/></springForm:label>
                            <springForm:input path="lastName" cssErrorClass="error"/>
                            <springForm:errors path="lastName" cssClass="error"/>
                        </li>
                        <li>
                            <springForm:label path="userName"> <s:message
                                    code="inspominder.userName"/></springForm:label>
                            <springForm:input path="userName" cssErrorClass="error"/>
                            <springForm:errors path="userName" cssClass="error"/>
                        </li>
                        <li>
                            <springForm:label path="password"> <s:message
                                    code="inspominder.password"/></springForm:label>
                            <springForm:input path="password" cssErrorClass="error"/>
                            <springForm:errors path="password" cssClass="error"/>
                        </li>
                    </ul>
                    <springForm:button class="btn btn-primary"> <s:message code="inspominder.register"/></springForm:button>
                </springForm:form>

                <%--  /panel-body    --%>
            </div>
        </div>
    </div>

</div>
</body>
</html>
