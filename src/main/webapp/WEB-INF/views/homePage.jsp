<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="springForm" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<html>
<head>
     <link href="<c:url value="/resources/css/myCustom.css" />" rel="stylesheet">
</head>

<body>
<h1><s:message code="inspominder.welcome"/></h1></br>
<h2><a href="<c:url value="/register"/>"><s:message code="inspominder.register"/> </a>
    | <a href="<c:url value="/login"/>"><s:message code="inspominder.login"/> </a></h2>
</body>

</html>