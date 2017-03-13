<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- bootstarp css -->
<link href="<c:url value="/resources/css/bootstrap2.css" />" rel="stylesheet">

<div class="navbar navbar-default navbar-fixed-top">
    <div class="navbar-header">
        <a class="navbar-brand" href="/">Inspominder</a>
    </div>
    <div class="navbar-collapse collapse">
        <!-- multilanguage links  -->
        <ul class="nav navbar-nav">
            <li>
                <a href="?mylocale=en">English </a>
            </li>
            <li>
                <a href="?mylocale=de">German </a>
            </li>
        </ul>
        <!-- logout  -->
        <ul class="nav navbar-nav navbar-right">
            <div class="container">
                <c:if test="${pageContext.request.userPrincipal.name != null}">
                    <ul class="nav navbar-nav navbar-right">
                        <li>
                            <form id="logoutForm" method="POST" action="${contextPath}/logout">
                                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                            </form>
                        </li>
                        <li>
                            <a href="/login?logout" onclick=" document.forms['logoutForm'].submit()"> Logout </a>
                        </li>
                    </ul>
                </c:if>
            </div>
        </ul>
    </div>
</div>

<!-- /container -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
