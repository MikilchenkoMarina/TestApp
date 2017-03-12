<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<a href="<c:url value="/" />">
    <img src="<c:url value="/resources"/>/img/logo7.png" border="0"/>
</a>

<div class="form-style-7">

    <div class="top-right-block">

        <a href="?mylocale=en">English </a>| <a href="?mylocale=de">German </a>

        <div class="container">
            <c:if test="${pageContext.request.userPrincipal.name != null}">
                <form id="logoutForm" method="POST" action="${contextPath}/logout">
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                </form>

                <a href="/login?logout" onclick=" document.forms['logoutForm'].submit()">Logout</a>

            </c:if>
        </div>
    </div>

</div>

<!-- /container -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
