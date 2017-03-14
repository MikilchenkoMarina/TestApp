<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="springForm" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@page session="true" %>
<html>
<head>
    <link href="<c:url value="/resources/css/myCustom.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/css/bootstrap2.css" />" rel="stylesheet">
    <h1><s:message code="inspominder.login"/></h1>
</head>


<body>

<div class="col-md-4 col-md-offset-4" <%--id="column-3"--%>>
    <div class="bs-component">
        <div class="panel panel-primary">
            <div class="panel-heading">
        <%--       // <h3 class="panel-title">Add Reminder</h3>--%>
            </div>
            <div class="panel-body">
                <%--   // <div class="container">--%>
                <form method="POST" action="${contextPath}/login" class="form-style-7">

                    <div class="form-group ${error != null ? 'has-error' : ''}">
                        <span>${message}</span>
                        <ul>
                            <li>
                                <label> <s:message code="inspominder.userName"/> </label>
                                <input name="username" type="text"/>
                            </li>
                            <li>
                                <label> <s:message code="inspominder.password"/> </label>
                                <input name="password" type="password"/>
                                <span>${error}</span>
                                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                            </li>
                        </ul>

                        <button class="btn btn-primary" type="submit"><s:message code="inspominder.login"/></button>

                        <h4 class="text-center"><a href="register"><s:message code="inspominder.register"/></a></h4>
                    </div>

                </form>

                <%--       //  </div>--%>
                <!-- /container -->
            </div>
        </div>
    </div>

</div>


<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>


</body>
</html>