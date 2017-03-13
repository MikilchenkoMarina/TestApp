<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <link href="<c:url value="/resources/css/myCustom.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/css/bootstrap2.css" />" rel="stylesheet">
</head>

<body>


<div class="container">
    <c:choose>
        <c:when test="${pageContext.request.userPrincipal.name != null}">
            <form id="logoutForm" method="POST" action="${contextPath}/logout">
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            </form>
            <h1> Welcome , ${pageContext.request.userPrincipal.name} your login is correct ! </h1>
            <div class="form-style-7">
                <h2>
                    <a href="<c:url value="user/${pageContext.request.userPrincipal.name}"/>"> Go to
                        profile </a>
                </h2>
            </div>
        </c:when>
        <c:otherwise>
            <h1><s:message code="inspominder.welcome"/></h1>
            <div class="form-style-7">
                <h2>
                    <a href="<c:url value="/register"/>"><s:message code="inspominder.register"/> </a>
                    |
                    <a href="<c:url value="/login"/>"><s:message code="inspominder.login"/> </a>
                </h2>
            </div>
        </c:otherwise>
    </c:choose>
</div>


<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>
