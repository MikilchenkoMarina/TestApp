<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="springForm" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Inspominder</title>
    <link href="<c:url value="/resources/css/myCustom.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/css/bootstrap2.css" />" rel="stylesheet">
    <div class="page-header" align="center"><h1><s:message code="inspominder.remindersPage"/></h1></div>
</head>

<body>
<h1><s:message code="inspominder.userProfile"/></h1>
<div class="col-md-4 col-md-offset-4" <%--id="column-3"--%>>
    <div class="bs-component">
        <div class="panel panel-primary">
            <div class="panel-body">
                <springForm:form method="delete" modelAttribute="reminder" cssClass="form-style-7">
                    <input type="hidden" name="_method" value="DELETE"/>

                    <div class="media-body">
                        <div class="snippet">
                            <a class="pull-left"> <img src="<c:url value="${reminder.imageLink}"/>"/> </a>
                            <p><h4><c:out value="${reminder.text}"/></h4></p>
                        </div>
                    </div>
                    <div class="alert alert-dismissible alert-danger">
                        <s:message code="inspominder.areYouSureDelete"/>
                    </div>
                    <springForm:button class="btn btn-primary btn-offset-primary">
                        <s:message code="inspominder.delete"/>
                    </springForm:button>
                </springForm:form>
            </div>
        </div>
    </div>
</div>
</body>
</html>
