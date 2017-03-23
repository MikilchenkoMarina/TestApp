<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <link href="<c:url value="/resources/css/myCustom.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/css/bootstrap2.css" />" rel="stylesheet">
    <div class="page-header" align="center"><h1><s:message code="inspominder.homepage"/></h1></div>
</head>

<body>
<div class="col-lg-4 col-lg-offset-4">
    <c:choose>
        <c:when test="${pageContext.request.userPrincipal.name != null}">
            <div class="alert alert-dismissible alert-success">
                <spring:message code="inspominder.welcome"/> ${pageContext.request.userPrincipal.name}
                <spring:message code="inspominder.openProfileAnCreateReminder"/>
                <a class="btn btn-primary" href="<c:url value="user/${pageContext.request.userPrincipal.name}"/>">
                    <spring:message code="inspominder.goToProfile"/></a>
            </div>
        </c:when>
        <c:otherwise>
            <div class="alert alert-dismissible alert-success">
                For demo login you can use username: <em>inspouser</em>, password: <em>pass123</em>
            </div>
            <h2 class="text-primary"><s:message code="inspominder.welcome"/></h2>
        </c:otherwise>
    </c:choose>
</div>
<div class="row">
    <%@include file="/resources/html/carousel.html" %>
</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>
