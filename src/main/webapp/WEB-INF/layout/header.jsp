<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<!-- bootstarp css -->
<link href="<c:url value="/resources/css/bootstrap2.css" />" rel="stylesheet">

<div class="navbar navbar-default navbar-fixed-top">
    <div class="navbar-header">
        <a class="navbar-brand" href="/">Inspominder</a>
    </div>
    <div class="navbar-collapse collapse" id="navbar-main">
        <!-- multilanguage links  -->
        <ul class="nav navbar-nav">
            <li>
                <a href="?mylocale=en">English </a>
            </li>
            <li>
                <a href="?mylocale=de">German </a>
            </li>
        </ul>
        <!-- logout | profile| reminders list -->
        <ul class="nav navbar-nav navbar-right">
            <div class="container">
                <c:choose>
                    <c:when test="${pageContext.request.userPrincipal.name != null}">
                        <ul class="nav navbar-nav navbar-right">
                            <li>
                                <form id="logoutForm" method="POST" action="${contextPath}/logout">
                                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                                </form>
                            </li>
                            <li>
                                <a href="<c:url value="/user/${pageContext.request.userPrincipal.name}"/>"> My
                                    profile </a>
                            </li>
                            <li>
                                <a href="<c:url value="/user/${pageContext.request.userPrincipal.name}/reminders"/>"> My
                                    Reminders </a>
                            </li>
                            <li>
                                <a href="/login?logout" onclick=" document.forms['logoutForm'].submit()">
                                    Logout </a>
                            </li>
                        </ul>
                    </c:when>
                    <c:otherwise>
                        <ul class="nav navbar-nav navbar-right">
                            <li>
                                <a class="btn btn-default" vertical-align="middle"
                                   href="<c:url value="/register"/>"><s:message code="inspominder.register"/></a>
                            </li>
                            <li>
                                <a class="btn btn-primary" vertical-align="middle" href="<c:url value="/login"/>">
                                    <s:message code="inspominder.login"/></a>
                            </li>
                        </ul>
                    </c:otherwise>
                </c:choose>
            </div>
        </ul>
    </div>
</div>

<!-- /container -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
