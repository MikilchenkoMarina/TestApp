<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <link href="<c:url value="/resources/css/myCustom.css" />" rel="stylesheet">
</head>

<body>

<div class="container">

    <c:if test="${pageContext.request.userPrincipal.name != null}">
        <form id="logoutForm" method="POST" action="${contextPath}/logout">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </form>
        <h2>
           Hello dear , ${pageContext.request.userPrincipal.name} your login is correct ! | <a href="/login?logout"  onclick=" document.forms['logoutForm'].submit()">Logout</a>
        </h2>
    </c:if>

</div>

<div class="form-style-7"><a id ="#link1" class="form-style-7" href="<c:url value="user/${pageContext.request.userPrincipal.name}"/>"> Go to  profile </a></div>

<!-- /container -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>
